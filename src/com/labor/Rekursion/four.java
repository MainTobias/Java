package com.labor.Rekursion;

import java.util.List;

public class four {
    public static void main(String[] args) {
        System.out.println(pas(5,4));
    }
    static int pas(int n,int k){
        if (k == 0 || k == n) return 1;
        return pas(n-1, k) + pas(n-1, k-1);
    }
}
