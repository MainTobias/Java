package com.euler;

/**
*https://projecteuler.net/problem=1
**/

public class one {
    public static void main(String[] args) {
        System.out.println(calc(1, 999, 3, 5));
    }
    static long calc(int start, int end, int... ofmultiples) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            for (int ofMultiple : ofmultiples) {
                if (i % ofMultiple == 0) {
                    sum += i;
                    break;
                }
            }
        }
        return sum;
    }
}
