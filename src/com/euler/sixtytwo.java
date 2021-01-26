package com.euler;

import java.util.ArrayList;
import java.util.List;

public class sixtytwo {
    public static void main(String[] args) {
        List<List<Counter>> counts = new ArrayList<>();
        all:
        for (int i = 0; true; i++) {
            Counter c = new Counter(cube(i));
            for (List<Counter> cs : counts) {
                if (cs.get(0).equals(c)) {
                    cs.add(c);
                    System.out.println(cs.get(0).original + "   " + cs.size());
                    if (cs.size() == 5) {
                        for (Counter css : cs) {
                            System.out.println(css.original);
                        }
                        break all;
                    }
                    continue all;
                }
            }
            List<Counter> countss = new ArrayList<>();
            countss.add(c);
            counts.add(countss);
        }
    }

    static long cube(long n) {
        return n * n * n;
    }
}
