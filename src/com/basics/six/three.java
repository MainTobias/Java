package com.basics.six;

import java.util.Arrays;
import java.util.Random;

public class three {
    public static void main(String[] args) {
        int[] rints = three.getRandoms();
        System.out.println(Arrays.toString(rints));
        System.out.println("Min: " + Arrays.stream(rints).min().getAsInt());
        System.out.println("Max: " + Arrays.stream(rints).max().getAsInt());
    }
    private static int[] getRandoms(int length, int bound){
        Random rng = new Random();
        int[] temp = new int[length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rng.nextInt(bound);
        }
        return temp;
    }
    private static int[] getRandoms(){
        Random rng = new Random();
        int[] temp = new int[20];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rng.nextInt(25);
        }
        return temp;
    }
}
