package com.basics.five;

public class one {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i <= 200; i++){
            sum += i;
        }
        System.out.println("Sum of all numbers in [0;200] = " + sum);

        sum = 0;
        for (int i = 100; i <= 200; i++){
            if (i%2==1) sum += i;
        }
        System.out.println("Sum of all odd numbers in [100;200] = " + sum);

        sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println("Sum of all numbers in [0;" + Integer.MAX_VALUE + "] = " + sum);
    }
}
