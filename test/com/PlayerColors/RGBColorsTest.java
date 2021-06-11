package com.PlayerColors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RGBColorsTest {
    RGBColors rgb;
    @BeforeEach
    void setUp() {
        rgb = new RGBColors(255,254,255);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("RGBColors{" +
                "hex='" + "#fffeff" + '\'' +
                ", r=" + 255 +
                ", g=" + 254 +
                ", b=" + 255 +
                '}', rgb.toString());
    }

    @Test
    void compareToo() {
        Assertions.assertEquals(0,rgb.compareToo(new RGBColors(255,254,255)));
        Assertions.assertFalse(rgb.compareToo(new RGBColors(255,253,255)) < 0);
        Assertions.assertTrue(rgb.compareToo(new RGBColors(255,255,255)) < 0);
    }

    @Test
    void getR() {
        Assertions.assertEquals(255, rgb.getR());
    }

    @Test
    void getG() {
        Assertions.assertEquals(254, rgb.getG());
    }

    @Test
    void getB() {
        Assertions.assertEquals(255, rgb.getB());

    }

    @Test
    void getHex() {
        Assertions.assertEquals("#fffeff", rgb.getHex());
    }
}