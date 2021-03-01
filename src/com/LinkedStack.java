package com;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;

public class LinkedStack<E> {
    private int size;
    private Node<E> tos;

    public void push(E data) {
        tos = new Node<>(data, tos);
        size++;
    }

    public E pop() {
        if (tos == null)return null;// throw new EmptyStackException();
        Node<E> x = tos;
        tos = tos.successor;
        size--;
        return x.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E element() {
        if (tos == null) return null;
        return tos.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Node<E> x = tos;
        for (int i = 0; i < size; i++) {
            sb.append(x).append("\n");
            x = x.successor;
        }
        return sb.toString();
    }
}

class LinkedQueue<E> {
    private Node<E> snout;
    private Node<E> tail;
    private int size;

    public static void main(String[] args) {
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        for (int i = 0; i < 6; i++) {
            queue1.add(i);
        }
        System.out.println("getNth");
        System.out.println(4 +" "+ queue1.getNth(4));
        //assertEquals(5, queue1.getNth(4));
        System.out.println(queue1.getNth(4));
        queue1.add(5);
        System.out.println(5 +" "+ queue1.getNth(4));
        System.out.println(queue1.getNth(-3));
        System.out.println(0 +" "+ queue1.getNth(0));
        System.out.println(1 +" "+ queue1.getNth(0));
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E data) {
        Node<E> x = new Node<E>(data, null);
        if (snout == null) {
            snout = x;
        } else if(tail == null) {
            tail = x;
            snout.successor = tail;
        } else {
            tail.successor = x;
            tail = tail.successor;
        }
        size++;
    }

    public E get() {
        if (snout == null) {
            return null;
        } else if(tail == null){
            Node<E> x = snout;
            snout = null;
            size--;
            return x.data;
        }
        Node<E> x = snout;
        snout = snout.successor;
        size--;
        return x.data;
    }
    public E getNth(int n) {
        if (snout == null) throw new EmptyStackException();
        if (!(n >= 0 && n < size)) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: " + size);
        }
        if (n == 0) {
            Node<E> x = snout;
            snout = snout.successor;
            size--;
            return x.data;
        }
        if (n == size-1) {
            int i  = 0;
            Node<E> x = snout;
            while (i+1 < n) {
                x = x.successor;
                i++;
            }
            x.successor = null;
            Node<E> oldTail = tail;
            tail = x;
            size--;
            return oldTail.data;
        }
        int i  = 0;
        Node<E> x = snout;
        while (i+1 < n) {
            x = x.successor;
            i++;
        }
        Node<E> el = x.successor;
        x.successor = x.successor.successor;
        size--;
        return el.data;
    }

    public E element() {
        return snout != null ? snout.data : null;
    }
    public List<E> toList(){
        List<E> l = new ArrayList<E>();
        Node<E> x = snout;
        for (int i = 0; i < size; i++) {
            l.add(x.data);
            x = x.successor;
        }
        return l;
    }
    @Override
    public String toString() {
        return toList().toString();
    }
}

class Node<E> {
    public Node<E> successor;
    public E data;

    Node() {
        this(null, null);
    }

    public Node(E data, Node<E> successor) {
        this.data = data;
        this.successor = successor;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

class Datei {

    public static String öfffne(String pfad) {
        if (pfad.strip().equals("test.txt")) return "A\nB\nC";
        return pfad;
    }
}
class Order{
    public static String genString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    public static void main(String[] args) {
        int len = new Random().nextInt(1000);
        LinkedQueue<Order> orders = new LinkedQueue<>();
        for (int i = 0; i < len; i++) {
            orders.add(new Order(genString(), new Random().nextInt(50)));
        }
        System.out.println(orders);
        while (!orders.isEmpty()) {
            System.out.println(orders.get().customer + " wurde bearbeitet.");
            System.out.println(orders);
        }
    }
    final String customer;
    final int quantity;

    Order(String customer, int quantity) {
        this.customer = customer;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Customer " + customer + " has ordered " + quantity + (quantity == 1 ? " piece" : " pieces");
    }
}