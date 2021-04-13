package com.MathSeries;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Reciprocal extends MathSeries {
    Reciprocal(int n) {
        super(n);
    }


    @Override
    double sumOfFirst_n_Elements() {
        int i = 0;
        int x = 1;
        double sum = 0.0;
        while (i < n) {
            if (x % 2 == 1) {
               i++;
               sum += 1.0 / x;
            }
            x++;
        }
        return sum;
    }

    @Override
    double nth_Element() {
        int i = 0;
        int x = 1;
        while (i < n) {
            if (x % 2 == 1) {
                i++;
            }
            x++;
        }
        return 1.0 / --x;
    }
    static String times(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
    @Override
    public String toString() {

        StringBuilder top = new StringBuilder();
        StringBuilder symbols = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        format.setMinimumFractionDigits(3);
        int i = 0;
        int x = 1;

        while (i < n) {
            if (x % 2 == 1) {
                i++;
                int x_length = String.valueOf(x).length();
                top.append(times(" ", (x_length - Math.floorDiv(x_length, 2)))).append("1").append(times(" ", 4 + (Math.floorDiv(x_length, 2))));
                symbols.append(times("-", x_length + 2)).append(" + ");
                numbers.append(" ").append(x).append("    ");
            }
            x++;
        }
        return top + "\n" + symbols.delete(symbols.length()-2, symbols.length()) + "= "+ format.format(sumOfFirst_n_Elements()) + "\n" + numbers;
    }
}
