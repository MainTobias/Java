package com.labor.Rekursion;

public class one {
    public static void main(String[] args) {
        System.out.println(getSomeRecursive(3));
        System.out.println(getSomeNotRecursive(3));
    }

    static double getSomeNotRecursive(int n) {
        if (n < 1) return 0;
        double num = 0;
        boolean isNegative = false;
        int last = 1;
        while (n >= 1) {
            if (isNegative){
                num -= 1.0/last;
            } else {
                num += 1.0/last;
            }
            isNegative = !isNegative;
            n--;
            last += 2;
        }
        return num;
    }


    static double getSomeRecursive(int n){
        if (n < 1) return 0;
        return getSomeRecursive(n, 1, false);
    }
    static double getSomeRecursive(int repeat, int last, boolean isNegative){
        if (repeat == 1){
            return 1.0/(last);
        } else {
            if (isNegative){
                return -(1.0/last) + getSomeRecursive(repeat-1, last+2, false);
            } else {
                return 1.0/last + getSomeRecursive(repeat-1, last+2, true);
            }
        }
    }
}
