package com.MathSeries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReciprocalTest {
    Reciprocal r;
    @BeforeEach
    void setUp() {
        r = new Reciprocal(5);
    }

    @Test
    void sumOfFirst_n_Elements() {
        assertEquals(1 + 1.0 / 3 + 1.0 / 5 + 1.0 / 7 + 1.0 / 9, r.sumOfFirst_n_Elements());
        assertThrows(IllegalArgumentException.class, () -> new Reciprocal(0));
        assertThrows(IllegalArgumentException.class, () -> new Reciprocal(-1));
    }

    @Test
    void nth_Element() {
        assertEquals(1.0 / 9 ,r.nth_Element());
        assertThrows(IllegalArgumentException.class, () -> new Reciprocal(0));
        assertThrows(IllegalArgumentException.class, () -> new Reciprocal(-1));
        System.out.println(new Reciprocal(4));
    }
}