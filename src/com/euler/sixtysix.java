package com.euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class sixtysix {
    static List<Integer> lefts = new ArrayList<>();
    static AtomicReference<BigInteger> Xmax = new AtomicReference<>(BigInteger.ZERO);
    public static void main(String[] args) {
        for (int D = 2; D <= 1000; D++) {
            lefts.add(D);
        }
        for (int D = 2; D <= 1000; D++) {
            if (Math.sqrt(D) == (int)(Math.sqrt(D))) {
                lefts.remove(Integer.valueOf(D));
                continue;
            }
            int finalD = D;
            new Thread(() -> {
                BigInteger x = getMinimalX(BigInteger.valueOf(finalD));
                if (x.compareTo(Xmax.get()) == 1) Xmax.set(x);
                System.out.println("D =" + finalD + " biggest = " + Xmax.get());
                lefts.remove(Integer.valueOf(finalD));
            }).start();
        }
        new Timer().schedule(new stillLeft(), 0, 5000);
    }

    static class stillLeft extends TimerTask {
        @Override
        public void run() {
            if(lefts.size() == 0) {
                System.out.println(Xmax);
                System.exit(0);
            } else if(lefts.size() < 20) {
                System.out.println("These tasks are left: " + lefts);
            } else {
                System.out.println("There are still " + lefts.size() + " tasks left.");
            }
        }
    }


    static BigInteger getMinimalX(BigInteger D) {
        BigInteger y = BigInteger.valueOf(0);
        BigInteger x = BigInteger.valueOf(1);
        while (true) {
            BigDecimal n = getY(D, x);
            if (x.mod(BigInteger.valueOf(1000000)).compareTo(BigInteger.ZERO) == 0) System.out.printf("%,d\n", x.intValue());
            if (isInteger(n) && !(n.compareTo(BigDecimal.valueOf(0)) == 0) && getSolution(x, n.toBigInteger(), D).equals(BigInteger.valueOf(1))) {
                y = n.toBigInteger();
                break;
            }
            x = x.add(BigInteger.ONE);
        }
        return x;
    }

    static BigDecimal getY(BigInteger D, BigInteger x) {
        MathContext mc = new MathContext(100);
        return BigDecimal.valueOf(-1).multiply(BigDecimal.valueOf(1).subtract(new BigDecimal(x).pow(2))).divide(new BigDecimal(D), 100, RoundingMode.HALF_UP).sqrt(mc);
    }

    static BigDecimal getX(BigInteger D, BigInteger y) {
        MathContext mc = new MathContext(100);
        return new BigDecimal(BigInteger.valueOf(1).add(D.multiply(square(y)))).sqrt(mc);
    }

    static BigInteger getSolution(BigInteger x, BigInteger y, BigInteger D) {
        return square(x).subtract(D.multiply(square(y)));
    }

    static BigInteger square(BigInteger n) {
        return n.pow(2);
    }

    static boolean isInteger(BigDecimal number) {
        return number.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }

}
