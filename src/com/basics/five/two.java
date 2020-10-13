package com.basics.five;

public class two {
    public static void main(String[] args) {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= 32; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0) out.append("Fizz");
                if (i % 5 == 0) out.append("Buzz");
            } else {
                out.append(i);
            }
            out.append("\n");
        }
        System.out.println(out.toString());
    }
}