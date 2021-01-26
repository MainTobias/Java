package com.euler;

public class sevenhundredeight {
    public static void main(String[] args) {
        System.out.println(f(90));
        System.out.println(S(100_000_000_000_000L));
    }
    private static long S(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += f(i);
            if (i % 1000000 == 0) System.out.println(i);
        }
        return sum;
    }
    public static int f(long n)
    {
        int count = 0;
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2) {
            count++;
        }
        return (int)(Math.pow(2.0, (double)(count)));
    }
}
