package com.basics.six;

import java.util.Arrays;

public class four {
    public static void main(String[] args) {
        for(String s : Arrays.deepToString(a()).split("],")){
            System.out.println(s);
        }
    }

    private static int[][] a() {
        int[][] twoDim = new int[9][9];
        for (int i = 0; i < twoDim.length; i++) {
            for (int j = 0; j < 9; j++) {
                twoDim[i][j] = (i+1)*(j+1);
            }
        }
        return twoDim;
    }
}
