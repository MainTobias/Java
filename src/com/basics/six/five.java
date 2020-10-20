package com.basics.six;

import org.jetbrains.annotations.Contract;

import java.util.Arrays;

public class five {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rowSums(new int[][]{new int[]{1, 2, 2}, new int[]{3, 2, 5}, new int[]{4, 7, 5}})));
    }
    @Contract(pure = true)
    static long[] rowSums(int[][] matrix){
        long[] sums = new long[matrix[0].length];
        for (int i = 0; i < sums.length; i++) {
            long count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                count += matrix[i][j];
            }
            sums[i] = count;
        }
        return sums;
    }
}
