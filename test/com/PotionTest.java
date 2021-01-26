package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {
    private Potion p;
    @BeforeEach
    void setUp() {
        Ingredient ingredient1 = new Ingredient("Toad");
        Ingredient ingredient2 = new Ingredient("Lizard");
        Ingredient ingredient3 = new Ingredient("Spider");
        p = new Potion(ingredient1, ingredient2, ingredient3);
    }

    @Test
    void isReady() {
        assertFalse(p.isReady());
        for (int i = 0; i < 4; i++) {
            p.stir();
        }
        assertFalse(p.isReady());
        p.stir();
        assertTrue(p.isReady());
    }

    @Test
    void stir() {
        assertFalse(p.isReady());
        p.stir();
        assertFalse(p.isReady());
        for (int i = 0; i < 4; i++) {
            p.stir();
        }
        assertTrue(p.isReady());
    }

    @Test
    void power() {
        System.out.println(p.power());
        Assertions.assertEquals(16, p.power());
        for (int i = 0; i < 5; i++) {
            p.stir();
        }
        Assertions.assertEquals(32, p.power());
    }
}