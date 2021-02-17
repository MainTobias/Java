package com;

import java.util.EmptyStackException;
import java.util.Random;

public class LinkedStack<E> {
    private int size;
    private Node<E> tos;

    public void push(E data) {
        Node<E> x = new Node<>(data, tos);
        tos = x;
        size++;
    }

    public E pop() {
        if (tos == null) throw new EmptyStackException();
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
            sb.append(i).append(": ").append(x);
            x = x.successor;
        }
        return sb.toString();
    }
}

class LinkedQueue<E> {
    private Node<E> snout;
    private Node<E> tail;
    private int size;

    public int getSize() {
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
        if (tail == null) {
            return null;
        } else if(snout == null){
            Node<E> x = tail;
            tail = null;
            size--;
            return x.data;
        }
        Node<E> x = snout;
        snout = snout.successor;
        size--;
        return x.data;
    }

    public E element() {
        return snout != null ? snout.data : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Size: " + size + "\n");
        Node<E> x = snout;
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ").append(x).append("\n");
            x = x.successor;
        }
        return sb.toString();
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