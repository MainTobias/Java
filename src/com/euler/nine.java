package com.euler;

public class nine {
    public static void main(String[] args) {
        main: for (int i = 0; i < 10_000; i++) {
            System.out.println(i);
            for (int j = 0; j < 10_000; j++) {
                for (int k = 0; k < 10_000; k++) {
                    if (getProduct(i, j, k) != -1){
                        System.out.println(getProduct(i, j, k));
                        break main;
                    }
                }
            }
        }
    }
    private static long getProduct(int a, int b, int c){
        if (!(a < b && b < c)) {
            return -1;
        }
        if (!(a+b+c==1000)){
            return -1;
        }
        if (!(square(a)+square(b)==square(c))) {
            return -1;
        }
        return (long) a *b*c;
    }
    private static long square(long n){
        return n*n;
    }
}
