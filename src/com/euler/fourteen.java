package com.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fourteen {
    private static HashMap<Long, Long> sequence = new HashMap();
    public static void main(String[] args) {
        long longestChain = 0;
        long biggestNum = 0;
        for (long i = 2; i < 1_000_000; i++) {
            getCount(i);
            if (getCount(i) >= longestChain) {
                longestChain = getCount(i);
                biggestNum = i;
            }
        }
        System.out.println(biggestNum + "  " + longestChain);
    }
    private static long getCount(long n){
        long count = 1;
        long nBackup = n;
        while (n > 1) {
            if (sequence.containsKey(n)) {
                count += sequence.get(n);
                count--;
                n = 1;
            } else {
                n = getNewN(n);
                count++;
            }
        }
        sequence.put(nBackup, count);
        return count;
    }

    private static long getNewN(long n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3*n + 1;
        }
    }
}
