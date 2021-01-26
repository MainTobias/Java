package com.euler;

public class six {
    public static void main(String[] args) {
        System.out.println(square(sum(100))-sumOfSquares(100));
    }

    private static long sumOfSquares(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += square(i);
        }
        return sum;
    }

    private static long sum(int n){
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private static long square(long n){
        return n*n;
    }
}
