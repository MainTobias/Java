package com.GeometricObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    Circle c;
    @BeforeEach
    void setUp() {
        c = new Circle(10);
    }

    @Test
    void scale() {
        c.scale(50);
        assertEquals(500, c.radius);
        assertThrows(IllegalArgumentException.class, () -> c.scale(-1));
        assertThrows(IllegalArgumentException.class, () -> c.scale(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> c.scale(Double.NEGATIVE_INFINITY));
        assertThrows(IllegalArgumentException.class, () -> c.scale(Double.POSITIVE_INFINITY));
    }

    @Test
    void IllegalArgs() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> new Circle(Double.POSITIVE_INFINITY));
        assertThrows(IllegalArgumentException.class, () -> new Circle(Double.NEGATIVE_INFINITY));
        assertThrows(IllegalArgumentException.class, () -> new Circle(-1));
    }

    @Test
    void calcArea() {
        assertEquals(c.calcArea(), 100 * Math.PI);
        c.scale(0.5);
        assertEquals(c.calcArea(), 25 * Math.PI);
    }

    @Test
    void calcPerimeter() {
        assertEquals(2 * 10 * Math.PI, c.calcPerimeter());
        c.scale(100);
        assertEquals(2 * 1000 * Math.PI, c.calcPerimeter());
    }
}