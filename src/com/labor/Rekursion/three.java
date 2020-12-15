package com.labor.Rekursion;

public class three {
    public static void main(String[] args) {
        System.out.println(GCD(9, 20, 30));
    }
    static int GCD(int... n){
        int gcd = GCD(n[0], n[1]);
        for (int i = 0; i < n.length; i++) {
            gcd = GCD(gcd, n[i]);
        }
        return gcd;
    }
    static int GCD(int x, int y){
        if (y == 0) return x;
        return GCD(y, x%y);
    }
}
