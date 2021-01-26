package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    private Ingredient i;
    @BeforeEach
    void setUp() {
        i = new Ingredient("Rat");
    }

    @Test
    void getName() {
        Assertions.assertEquals(i.getName(), "Rat");
    }

    @Test
    void setName() {
        Assertions.assertEquals(i.getName(), "Rat");
        i.setName("Rotten tiger flesh");
        Assertions.assertEquals(i.getName(), "Rotten tiger flesh");
    }

    @Test
    void power() {
        Assertions.assertEquals(i.power(), 3);
        i.setName("Rotten tiger flesh");
        Assertions.assertEquals(i.power(), 18);
    }
}