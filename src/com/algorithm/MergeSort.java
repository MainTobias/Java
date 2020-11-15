package com.algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{2,1}, new int[]{3, 4 ,8 ,-6})));
    }
    static int[] sort(int[] unsorted){
        int[] temp = new int[unsorted.length];
        int[][] = new int[][];
    }
    static private int[][] combine(int[][] unsorted){
        if (unsorted.length == 1){
            return unsorted;
        } else{

        }
    }
    static private int[] merge(int[] one, int[] two){
        int[] temp = new int[one.length + two.length];
        boolean[] temp_moved = new boolean[temp.length];
        for (int i = 0; i < one.length+two.length; i++) {
            if (i < one.length){
                temp[i] = one[i];
            } else {
                temp[i] = two[i- one.length];
            }
        }
        int[] merged = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            //fix that
            int min = Integer.MAX_VALUE;
            int minpos = 0;
            for (int j = 0; j < temp.length; j++) {
                if(!temp_moved[j]){
                    if(temp[j] < min){
                        min = temp[j];
                        minpos = j;
                    }
                }
            }
            temp_moved[minpos] = true;
            merged[i] = min;
        }
        return merged;
    }
}
