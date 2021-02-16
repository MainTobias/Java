package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedList<E> {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(-1, "data");
        System.out.println(list);
    }

    private int length;
    private ListNode<E> first;
    private ListNode<E> last;

    LinkedList() {
        first = null;
        last = null;
    }

    public int size() {
        return length;
    }

    private boolean startFromEnd(int index) {
        return index > length / 2;
    }

    private ListNode<E> getNode(int index) {
        if (!(index >= 0 && index < this.length)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
        ListNode<E> x;
        if (startFromEnd(index)) {
            x = last;
            for (int i = length - 1; i > index; i--) {
                x = x.predecessor;
            }
        } else {
            x = first;
            for (int i = 0; i + 1 <= index; i++) {
                x = x.successor;
            }
        }
        return x;
    }
    public LinkedList<E> replaceAll(E data, E replacement) {
        ListNode<E> x = first;
        for (int i = 0; i < length; i++) {
            if (x.data.equals(data)) {
                x.data = replacement;
            }
            if (x.successor == null) break;
            x = x.successor;
        }
        return this;
    }

    public LinkedList<E> set(int index, E data) {
        getNode(index).data = data;
        return this;
    }

    public E get(int index) {
        ListNode<E> x = getNode(index);
        if (x == null) return null;
        return x.data;
    }

    public E getLast() {
        if (last == null) return null;
        return last.data;
    }

    public E getFirst() {
        if (first == null) return null;
        return first.data;
    }

    public LinkedList<E> clear() {
        length = 0;
        first = null;
        last = null;
        return this;
    }

    public LinkedList<E> removeAll(E data) {
        ListNode<E> x = first;
        for (int i = 0; i < length; i++) {
            if (x.data.equals(data)) {
                x.pullOut();
                if (i == 0) {
                    if (first != null) first = first.successor;
                } else {
                    if (last != null) last = last.predecessor;
                }
                i--;
                length--;
            }
            if (x.successor == null) break;
            x = x.successor;
        }
        return this;
    }

    public E pop() {
        return pop(length-1);
    }
    public E pop(int index) {
        ListNode<E> x = getNode(index);
        remove(index);
        return x.data;
    }

    public LinkedList<E> remove(int index) {
        if (!(index >= 0 && index < this.length)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
        getNode(index).pullOut();
        if (index == 0) {
            first = first.successor;
        } else if (index == length - 1) {
            last = last.predecessor;
        }
        length--;
        return this;
    }

    public LinkedList<E> add(E data) {
        if (first == null) {
            first = new ListNode<E>(data, null, null);
        } else if (last == null) {
            last = new ListNode<E>(data, first, null);
            first.successor = last;
        } else {
            last = new ListNode<E>(data, last, null);
            last.predecessor.successor = last;
        }
        length++;
        return this;
    }

    public LinkedList<E> insert(int index, E data) {
        if (length == 0 && index == 0) {
            add(data);
            return this;
        }
        if (!(index >= 0 && index < this.length)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
        ListNode<E> x = getNode(index);
        if (index == length - 1) {
            last = new ListNode<E>(data, x, null);
            x.successor = last;
            x.predecessor.successor = x;
        } else {
            ListNode<E> toInsert = new ListNode<E>(data, x.predecessor, x);
            if (index == 0) {
                first = toInsert;
            } else {
                x.predecessor.successor = toInsert;
            }
            x.predecessor = toInsert;
        }
        length++;
        return this;
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        ListNode<E> x = first;
        while (true) {
            list.add(x.data);
            if (x.successor == null) break;
            x = x.successor;
        }
        return list;
    }

    @Override
    public String toString() {
        if (first == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        ListNode<E> x = first;
        while (true) {
            sb.append(x.data);
            if (x.successor == null) {
                break;
            } else {
                sb.append(", ");
            }
            x = x.successor;
        }
        return sb.append("]").toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LinkedList<E> other = (LinkedList<E>) o;
        if (this == null && other == null) {
            return true;
        }
        if (this == null || other == null) {
            return false;
        }
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!Objects.equals(this.get(i), other.get(i))) {
                return false;
            }
        }
        return true;
    }
}

class ListNode<E> {
    public ListNode<E> predecessor;
    public ListNode<E> successor;
    public E data;

    ListNode() {
        this(null, null, null);
    }

    public ListNode(E data, ListNode<E> predecessor, ListNode<E> successor) {
        this.data = data;
        this.predecessor = predecessor;
        this.successor = successor;

    }

    public void pullOut() {
        if (predecessor != null) predecessor.successor = successor;
        if (successor != null) successor.predecessor = predecessor;
    }
}
