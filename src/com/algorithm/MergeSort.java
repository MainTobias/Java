package com.algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{-1,-2,0,2,3})));
    }
    static int[] sort(int[] unsorted){
        int[] temp = new int[unsorted.length];
        int[][] parted= new int[unsorted.length][1];
        for (int i = 0; i < unsorted.length; i++) {
            parted[i][0] = unsorted[i];
        }
        return combine(parted)[0];
    }
    static private int[][] combine(int[][] unsorted){
        if(unsorted.length >= 2){
            int[][] temp = new int[(int) Math.ceil(unsorted.length/2.0)][];
            for (int i = 0; i < unsorted.length; i++) {
                if(i%2==0){
                    if(i+1<unsorted.length){
                        temp[i/2] = merge(unsorted[i], unsorted[i+1]);
                    } else {
                        temp[i/2] = unsorted[i];
                    }
                }
            }
            if(temp.length >= 2){
                return combine(temp);
            }
            return temp;
        } else {
            return unsorted;
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
