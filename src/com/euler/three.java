package com.euler;

import java.util.*;

/**
 * https://projecteuler.net/problem=3
 **/

public class three {
    public static void main(String[] args) {
        System.out.println(largestPrimeFactorOf(600_851_475_143L));
    }
    static long largestPrimeFactorOf(long n){
        List<Long> primes = new ArrayList<>();
        long res = n;
        for (long i = 2; i <= n; i++) {
            if (i%10_000==0){
                System.out.printf("%,d + %,d\n", i, res);
            }
            while (res % i == 0) {
                res /= i;
                primes.add(i);
            }
            if (res == 1){
                break;
            }
        }
        return primes.get(primes.size()-1);
    }

    static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
