package com.algorithm;

import java.util.Arrays;
import java.util.Random;

public class Heap {
    public long comparisons;
    public static void main(String[] args) {
        Heap h = new Heap();
        Random rng = new Random();
        int aSize = 1000000;
        int[] unsorted = new int[aSize];
        for (int i = 0; i < aSize; i++) {
            unsorted[i] = rng.nextInt();
        }
        System.out.println(Arrays.toString(h.sort(unsorted)));
        System.out.println(h.comparisons);
    }

    public int[] sort(int[] a) {
        int[] copy = a.clone();
        heapify(copy);
        return copy;
    }

    private void heapify(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--){
            versickern(a, i, a.length);
        }

        for (int n = a.length; n > 1; n--) {
            int t = a[0];
            a[0] = a[n-1];
            a[n-1] = t;
            versickern(a, 0, n - 1);
        }
    }

    private void versickern(int[] a, int i, int n) {
        while (i < n / 2) {
            int l = (i + 1) * 2 - 1;
            int r = (i + 1) * 2;
            int max;
            if (r < n && a[r] > a[l]) {
                max = r;
            } else {
                max = l;
            }
            if (a[max] > a[i]) {
                int t = a[i];
                a[i] = a[max];
                a[max] = t;
                i = max;
            } else {
                break;
            }
        comparisons += 2;
        }
    }
}
