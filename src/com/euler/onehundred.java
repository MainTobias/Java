package com.euler;

import java.math.BigDecimal;
import java.math.MathContext;

public class onehundred {
    public static void main(String[] args) {
        long b = 15;
        long n = 21;
        long target = 1000000000000L;

        while(n < target){
            long btemp = 3 * b + 2 * n - 2;
            long ntemp = 4 * b + 3 * n - 3;

            b = btemp;
            n = ntemp;
        }
        System.out.println(b);
        System.out.println(n);
    }
    static BigDecimal getX(BigDecimal d){
        MathContext mc = new MathContext(25);
        final BigDecimal sqrt = BigDecimal.valueOf(0.5).pow(2).add(d.multiply(d.subtract(BigDecimal.ONE)).divide(BigDecimal.valueOf(2))).sqrt(mc);
        BigDecimal x1 = BigDecimal.valueOf(0.5).add(sqrt);
        BigDecimal x2 = BigDecimal.valueOf(0.5).subtract(sqrt);
        if (isInteger(x1) && x1.compareTo(BigDecimal. ZERO) >= 0) {
            return x1;
        }
        if (isInteger(x2) && x2.compareTo(BigDecimal. ZERO) >= 0) {
            return x2;
        }
        return BigDecimal.ONE.negate();
    }
    static boolean isInteger(BigDecimal number) {
        return number.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }
}
