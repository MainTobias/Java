package com;

public class Rectangle {
    private double length;
    private double width;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 1.0) {
            width = 1.0;
        } else if (width >= 20.0) {
            width = 20.0;
        }
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 1.0) {
            length = 1.0;
        } else if (length >= 20.0) {
            length = 20.0;
        }
        this.length = length;
    }

    public double calcCircumference() {
        return 2 * length + 2 * width;
    }

    public double calcArea() {
        return length * width;
    }

    Rectangle() {
        this(1.0, 1.0);
    }

    Rectangle(double length, double width) {
        this.setLength(length);
        this.setWidth(width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
