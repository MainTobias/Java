package com.basics.six;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class one {
    public static void main(String[] args) {
        System.out.println("test = " + Arrays.toString(filterDuplicates(new int[]{0,1,2,3,4,3,3,1,0,3,7,6})));
    }

    static int[] filterDuplicates(int[] numbers) {
        ArrayList<Integer> uniques = new ArrayList<Integer>();
        for (int x : numbers){
            if (one.count(numbers, x) < 2){
                uniques.add(x);
            }
        }
        Collections.sort(uniques);
        return uniques.stream().mapToInt(i->i).toArray();
    }

    private static int count(int[] numbers, int key) {
        int count = 0;
        for (int x : numbers) {
            if (x == key) count++;
        }
        return count;
    }
}
