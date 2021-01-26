package com;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RectangleTest {

    @Test
    public void setWidth() {
        Rectangle r = new Rectangle(5.0, 10.0);
        r.setWidth(0.0005);
        Assertions.assertEquals(1.0, r.getWidth());
        r.setWidth(50_000);
        Assertions.assertEquals(20.0, r.getWidth());
        r.setWidth(1.23);
        Assertions.assertEquals(1.23, r.getWidth());
    }

    @Test
    public void setLength() {
        Rectangle r = new Rectangle(5.0, 10.0);
        r.setLength(0.0005);
        Assertions.assertEquals(1.0, r.getLength());
        r.setLength(50_000);
        Assertions.assertEquals(20.0, r.getLength());
        r.setLength(1.23);
        Assertions.assertEquals(1.23, r.getLength());
    }

    @Test
    public void calcCircumference() {
        Rectangle r = new Rectangle(5.0, 10.0);
        Assertions.assertEquals(30.0, r.calcCircumference());
        r.setWidth(9.235);
        r.setLength(12.575);
        Assertions.assertEquals(43.62, r.calcCircumference());
    }

    @Test
    public void calcArea() {
        Rectangle r = new Rectangle(5.0, 10.0);
        Assertions.assertEquals(50.0, r.calcArea());
        r.setLength(1.23);
        r.setWidth(4.56);
        Assertions.assertEquals(5.6088, r.calcArea());
    }
}