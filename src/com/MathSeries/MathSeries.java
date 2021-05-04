package com.MathSeries;

abstract class MathSeries {
    public MathSeries(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
    }
    MathSeries(){}
    int n;
    abstract double sumOfFirst_n_Elements();
    abstract double nth_Element();
    @Override
    public String toString() {
        return "Calculation of the mathematic series with " + n +
                "Elements";
    }
}
