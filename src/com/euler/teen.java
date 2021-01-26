package com.euler;

public class teen {
    public static void main(String[] args) {
        System.out.println(sumOfPrimes(2_000_000));
    }
    private static long sumOfPrimes(int max){
        long sum = 0;
        int i = 2;
        while (i < max){
            if (isPrime(i)){
                sum += i;
            }
            i++;
        }
        return sum;
    }
    static boolean isPrime(long n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (long i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}
