package com.basics.six;

import java.util.ArrayList;
import java.util.Arrays;

public class two {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(concatArrays(new int[]{2,2,1}, new int[]{2,3,1})));
    }
    static int[] concatArrays(int[] ones, int[] twos){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int one : ones){
            for(int two : twos) {
                if (one == two) {
                    temp.add(one);
                    break;
                }
            }
        }
        int[] out = new int[temp.size()];
        for (int i = 0; i < out.length; i++){
            out[i] = temp.get(i);
        }
        return out;
    }
}
