package com.GeometricObject;

public class Circle extends Figure {
    double radius;
    Circle(){}
    Circle(double radius) {
        if (radius < 0 || !Double.isFinite(radius)) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }
    @Override
    public void scale(double s) {
        if (s < 0 || !Double.isFinite(s)) {
            throw new IllegalArgumentException("Variable s must be greater than 0 and a number.");
        }
        radius *= s;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calcPerimeter() {
        return Math.PI * radius * 2;
    }
}
