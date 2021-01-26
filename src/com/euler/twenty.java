package com.euler;

import java.math.BigInteger;

public class twenty {
    public static void main(String[] args) {
        String digits = fact(100).toString();
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        System.out.println(sum);
    }
    private static BigInteger fact(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(fact(n-1));
    }
}
