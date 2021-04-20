package com.GeometricObject;


public class Rectangle extends Figure {
    double width;
    double height;
    Rectangle() {};
    Rectangle(double width, double height) {
        if (!(Double.isFinite(width) && Double.isFinite(height)) || width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }
    @Override
    public void scale(double s) {
        if (s < 0 || !Double.isFinite(s)) {
            throw new IllegalArgumentException("Variable s must be greater than 0 and a number.");
        }
        width *= s;
        height *= s;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (width + height);
    }
}
