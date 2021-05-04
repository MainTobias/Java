package com.MathSeries;

public class Fibonacci extends MathSeries {
    Fibonacci(int n) {
        super(n);
    }

    @Override
    double sumOfFirst_n_Elements() {
        int a1 = 1;
        int a2 = 1;
        int i = 0;
        int sum = 0;
        while (i < n) {
            int t = a1 + a2;
            sum += a1;
            a1 = a2;
            a2 = t;
            i++;
        }
        return sum;
    }

    @Override
    double nth_Element() {
        int a1 = 1;
        int a2 = 1;
        int i = 2;
        while (i < n) {

            int t = a1 + a2;
            a1 = a2;
            a2 = t;
            i++;
        }
        return a2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a1 = 1;
        int a2 = 1;
        int i = 0;
        while (i < n) {
            sb.append(a1);
            sb.append(",");
            int t = a1 + a2;
            a1 = a2;
            a2 = t;
            i++;
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
}
