package com.labor.Rekursion;

public class two {
    public static void main(String[] args) {
        System.out.println(getFibonacci(10));
    }
    static int getFibonacci(int n){
        return getFibonacci(1, 1, n-2);
    }
    static int getFibonacci(int last1, int last2, int n){
        if (n == 1) return last1 + last2;
        return getFibonacci(last2, last1+last2, n-1);
    }
}
