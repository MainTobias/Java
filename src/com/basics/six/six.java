package com.basics.six;

import org.jetbrains.annotations.Contract;

import java.util.Arrays;

public class six {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(colSums(new int[][]{new int[]{1, 2, 2}, new int[]{3, 2, 5}, new int[]{4, 7, 5}})));
    }
    @Contract(pure = true)
    static long[] colSums(int[][] matrix){
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
