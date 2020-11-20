package com.algorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = new int[20];
        Random rng = new Random();
        long start, finish, timeElapsed;
        int[] copy;
        for (int i = 0; i < A.length; i++) {
            A[i] = rng.nextInt(50);
        }

        System.out.println(Arrays.toString(A));
        copy = A.clone();
        start = System.nanoTime();
        System.out.println(quicksort(copy, 0, A.length - 1, 0));
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(Arrays.toString(copy) + "\nTook: " + timeElapsed);
        copy = A.clone();
        start = System.nanoTime();
        Arrays.sort(copy);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println(Arrays.toString(copy) + "\nTook: " + timeElapsed);
    }
    static long quicksort(int[] A, int lo, int hi, int count){
        if (lo < hi){
            int p = partition(A, lo, hi);
            count += quicksort(A, lo, p, count);
            count += quicksort(A, p + 1, hi, count);
            count++;
        }
        return count;
    }
    static int partition(int[] A, int lo, int hi){
        int pivot = A[Math.floorDiv((hi+lo), 2)];
        int i = lo -1;
        int j = hi + 1;
        while (true){
            do {
                i = i + 1;
            } while(A[i] < pivot);
            do{
                j = j - 1;
            } while (A[j] > pivot);
            if (i >= j){
                return j;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
