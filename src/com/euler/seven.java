package com.euler;

public class seven {
    public static void main(String[] args) {
        System.out.println(findPrime(10001));
    }
    public static long findPrime(long nth){
        int count = 0;
        long i = 2;
        while (count < nth) {
            if (isPrime(i)) count++;
            if (count == nth) {
                return i;
            }
            i++;
        }
        return -1;
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
