package com.basics.six;


import java.util.Arrays;

public class five {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rowSums(new int[][]{new int[]{1, 2, 2, 4}, new int[]{3, 2, 5}, new int[]{4, 7, 5}})));
    }

    static long[] rowSums(int[][] matrix) {
        long[] sums = new long[matrix.length];
        for (int i = 0; i < sums.length; i++) {
            long sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i].length > j) sum += matrix[i][j];
            }
            sums[i] = sum;
        }
        return sums;
    }
}
