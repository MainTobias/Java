package com.algorithm;

import java.util.Arrays;
import java.util.Random;

public class Vergleich {
    public static void main(String[] args) {
        int[] len10 = new int[10];
        int[] len100 = new int[100];
        int[] len1000 = new int[1000];
        int[] len10000 = new int[10000];
        fill(len10, len100, len1000, len10000);
        long quicksort10 = QuickSort1.quicksort(len10.clone(), 0, len10.length - 1, 0);
        long quicksort100 = QuickSort1.quicksort(len100.clone(), 0, len100.length - 1, 0);
        long quicksort1000 = QuickSort1.quicksort(len1000.clone(), 0, len1000.length - 1, 0);
        long quicksort10000 = QuickSort1.quicksort(len10000.clone(), 0, len10000.length - 1, 0);
        System.out.println(quicksort10 +" "+ quicksort100 +" "+ quicksort1000 +" "+ quicksort10000);
        MergeSort1 m = new MergeSort1();
        m.sort(len10.clone());
    }

    private static void fill(int[]... arr) {
        for (int i = 0; i < arr.length; i++) {
            fill(arr[i]);
        }
    }
    
    private static void fill(int[] arr) {
        Random rng = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rng.nextInt();
        }
    }
}

class QuickSort1 {
    static long quicksort(int[] A, int lo, int hi, int count) {
        if (lo < hi) {
            int p = partition(A, lo, hi);
            count += quicksort(A, lo, p, count);
            count += quicksort(A, p + 1, hi, count);
            count++;
        }
        return count;
    }

    static int partition(int[] A, int lo, int hi) {
        int pivot = A[Math.floorDiv((hi + lo), 2)];
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            do {
                i = i + 1;
            } while (A[i] < pivot);
            do {
                j = j - 1;
            } while (A[j] > pivot);
            if (i >= j) {
                return j;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}

class MergeSort1 {
    public int count = 0;
    int[] sort(int[] unsorted) {
        int[] temp = new int[unsorted.length];
        int[][] parted = new int[unsorted.length][1];
        for (int i = 0; i < unsorted.length; i++) {
            parted[i][0] = unsorted[i];
        }
        return combine(parted)[0];
    }

    private int[][] combine(int[][] unsorted) {
        if (unsorted.length >= 2) {
            int[][] temp = new int[(int) Math.ceil(unsorted.length / 2.0)][];
            for (int i = 0; i < unsorted.length; i++) {
                if (i % 2 == 0) {
                    if (i + 1 < unsorted.length) {
                        temp[i / 2] = merge(unsorted[i], unsorted[i + 1]);
                    } else {
                        temp[i / 2] = unsorted[i];
                    }
                }
            }
            if (temp.length >= 2) {
                return combine(temp);
            }
            return temp;
        } else {
            return unsorted;
        }
    }

    private int[] merge(int[] one, int[] two) {
        int[] temp = new int[one.length + two.length];
        boolean[] temp_moved = new boolean[temp.length];
        for (int i = 0; i < one.length + two.length; i++) {
            if (i < one.length) {
                temp[i] = one[i];
            } else {
                temp[i] = two[i - one.length];
            }
        }
        int[] merged = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            int min = Integer.MAX_VALUE;
            int minpos = 0;
            for (int j = 0; j < temp.length; j++) {
                if (!temp_moved[j]) {
                    if (temp[j] < min) {
                        min = temp[j];
                        minpos = j;
                    }
                }
            }
            count++;
            temp_moved[minpos] = true;
            merged[i] = min;
        }
        return merged;
    }
}