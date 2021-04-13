package com.MathSeries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    Fibonacci f;

    @BeforeEach
    void setUp() {
        f = new Fibonacci(5);
    }

    @Test
    void sumOfFirst_n_Elements() {
        assertEquals(1 + 1 + 2 + 3 + 5, f.sumOfFirst_n_Elements());
        assertThrows(IllegalArgumentException.class, () -> new Fibonacci(0));
        assertThrows(IllegalArgumentException.class, () -> new Fibonacci(-1));
    }

    @Test
    void nth_Element() {
        assertEquals(5, f.nth_Element());
        assertEquals(3, new Fibonacci(4).nth_Element());
        assertThrows(IllegalArgumentException.class, () -> new Fibonacci(0));
        assertThrows(IllegalArgumentException.class, () -> new Fibonacci(-1));
    }
}