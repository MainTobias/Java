package com.PlayerColors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player p1;
    Player p2;
    @BeforeEach
    void setUp() {
        Player.reset();
        p1 = new Player("Heinz", 100, Color.Blue);
        p2 = new Player("Fritz", 200, Color.Red);
    }

    @Test
    void alreadyAssignedColor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player("a", 1, Color.Blue));
    }

    @Test
    void compareTo() {
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Heinz has a player ID of 100 and a color of Blue", p1.toString());
        Assertions.assertEquals("Fritz has a player ID of 200 and a color of Red", p2.toString());
    }
}