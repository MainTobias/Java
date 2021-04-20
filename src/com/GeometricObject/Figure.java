package com.GeometricObject;

public abstract class Figure implements GeometricObject {
    double rX;
    double rY;
    Figure(){}
    @Override
    public void translate(double x, double y) {
        if (!(Double.isFinite(x) && Double.isFinite(y))) {
            throw new IllegalArgumentException("Variables x and y must be a number.");
        }
        rX += x;
        rY += y;
    }

    @Override
    public abstract void scale(double s);

    @Override
    public abstract double calcArea();

    @Override
    public abstract double calcPerimeter();
}
