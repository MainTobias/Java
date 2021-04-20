package com.GeometricObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle r;
    @BeforeEach
    void setUp() {
        r = new Rectangle(1, 1);
    }

    @Test
    void IllegalArgs() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(500, Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(Double.POSITIVE_INFINITY, 100));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(Double.NEGATIVE_INFINITY, 100));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 100));
    }

    @Test
    void scale() {
        r.scale(5);
        assertEquals("5.0,5.0", r.height + "," + r.width);
    }

    @Test
    void calcArea() {
        r.scale(5);
        assertThrows(IllegalArgumentException.class, () -> r.scale(-1));
        assertEquals(100.0, r.calcArea());
    }

    @Test
    void calcPerimeter() {
        r.scale(10);
        assertEquals(100.0, r.calcArea());
    }
}