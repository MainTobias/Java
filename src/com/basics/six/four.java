package com.basics.six;

import java.util.Arrays;

public class four {
    public static void main(String[] args) {
        int[][] a = a();
        String formatted = "";
        for (int i = 0; i < a.length; i++) {
            StringBuilder out = new StringBuilder();
            for (int j = 0; j < a[i].length; j++) {
                out.append(repeat(" ", 3 - String.valueOf(a[i][j]).length()) + String.valueOf(a[i][j]));
            }
            formatted += out.toString() + "\n";
        }
        System.out.println(formatted);
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

    static String repeat(String toRepeat, int times){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < times; i++) {
            out.append(toRepeat);
        }
        return out.toString();
    }
}
