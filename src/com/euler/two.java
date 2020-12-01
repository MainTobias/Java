package com.euler;

/**
 *https://projecteuler.net/problem=2
 **/

public class two {
    public static void main(String[] args) {
        System.out.println(getEvenFibonacciSum(4_000_000));
    }
    static long getEvenFibonacciSum(long max, long evenSum, long one, long two){
        if (two % 2 == 0) evenSum += two;
        long totalSum = one + two;
        if (totalSum < max) {
            return getEvenFibonacciSum(max, evenSum, two, totalSum);
        } else {
            return evenSum;
        }
    }
    static long getEvenFibonacciSum(long max){
        return getEvenFibonacciSum(max, 0, 1, 2);
    }
}
