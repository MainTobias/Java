package com.basics.six;

import java.util.ArrayList;
import java.util.List;

public class two {
    public static void main(String[] args) {

    }
    static int[] concatArrays(int[] ones, int[] twos){
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(int one : ones){
            for(int two : twos) {
                if (one == two) {
                    out.add(one);
                    break;
                }
            }
        }
        return out;
    }
}
