package com.basics.six;


import java.util.Arrays;

public class six {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(colSums(new int[][]{new int[]{1, 2, 2, 3}, new int[]{3, 2, 5, 7}, new int[]{4, 7, 5}})));
    }
    static long[] colSums(int[][] matrix){
        int longest = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (longest < matrix[i].length) longest = matrix[i].length;
        }
        long[] sums = new long[longest];
        for (int i = 0; i < longest; i++) {
            long sum = 0;
            for (int j = 0; j < longest; j++) {
                if(longest -1 > j && i < matrix[j].length) sum += matrix[j][i];
            }
            sums[i] = sum;
        }
        return sums;
    }
}
