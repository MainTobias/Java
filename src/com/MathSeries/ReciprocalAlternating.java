package com.MathSeries;


import java.text.NumberFormat;
import java.util.Locale;

public class ReciprocalAlternating extends MathSeries {
    ReciprocalAlternating(int n) {
        super(n);
    }

    @Override
    double sumOfFirst_n_Elements() {
        int i = 0;
        int x = 1;
        double sum = 0.0;
        boolean negate = false;
        while (i < n) {
            if (x % 2 == 1) {
                i++;
                if (negate) {
                    sum -= 1.0 / x;
                } else {
                    sum += 1.0 / x;
                }
                negate = !negate;
            }
            x++;
        }
        return sum;
    }

    @Override
    double nth_Element() {
        int i = 0;
        int x = 1;
        boolean negate = true;
        while (i < n) {
            if (x % 2 == 1) {
                i++;
                negate = !negate;
            }
            x++;
        }
        return negate ? -1.0 / --x : 1.0 / --x;
    }

    @Override
    public String toString() {

        StringBuilder top = new StringBuilder();
        StringBuilder symbols = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        format.setMinimumFractionDigits(3);
        boolean negate = false;
        int i = 0;
        int x = 1;

        while (i < n) {
            if (x % 2 == 1) {
                i++;
                int x_length = String.valueOf(x).length();
                top.append(Reciprocal.times(" ", (x_length - Math.floorDiv(x_length, 2)))).append("1").append(Reciprocal.times(" ", 4 + (Math.floorDiv(x_length, 2))));
                symbols.append(Reciprocal.times("-", x_length + 2)).append(negate ? " + " : " - ");
                numbers.append(" ").append(x).append("    ");
                negate = !negate;
            }
            x++;
        }
        return top + "\n" + symbols.delete(symbols.length()-2, symbols.length()) + "= "+ format.format(sumOfFirst_n_Elements()) + "\n" + numbers;
    }
}

