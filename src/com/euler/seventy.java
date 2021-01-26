package com.euler;

import java.util.ArrayList;
import java.util.List;

public class seventy {
    public static void main(String[] args) {
        List<Counter> counters = new ArrayList<Counter>();
        for (int n = 2; n < 10_000_000; n++) {
            if (new Counter(phi(n)).equals(new Counter(n))) {
                counters.add(new Counter(n));
            }
        }
        Counter c = new Counter(0);
        double minimum = counters.get(0).original/(double)(phi((int) counters.get(0).original));
        for (Counter c2 : counters) {
            if (c2.original/(double)(phi((int) c2.original)) < minimum) {
                minimum = c2.original/(double)(phi((int) c2.original));
                c = c2;
            }
        }
        System.out.println(c.original);
    }

    static int phi(int n) {
        float result = n;
        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result *= (1.0 - (1.0 / (float) p));
            }
        }
        if (n > 1)
            result *= (1.0 - (1.0 / (float) n));
        return (int) result;
    }
}