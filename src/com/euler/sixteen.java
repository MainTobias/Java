package com.euler;

import java.math.BigInteger;

public class sixteen {
    public static void main(String[] args) {
        BigInteger b = BigInteger.TWO.pow(1000);
        String basS = b.toString();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < basS.length(); i++) {
            sum = sum.add(new BigInteger(basS.substring(i, i+1)));
        }
        System.out.println(sum);
    }
}
