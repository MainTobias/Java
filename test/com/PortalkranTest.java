package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortalkranTest {
    private Portalkran p;
    @BeforeEach
    void setUp() {
        p = new Portalkran(3, 100);
    }

    @Test
    void nachRechts() {
        Assertions.assertEquals(1, p.nachRechts(1));
        Assertions.assertEquals(2, p.nachRechts(1_000_000_000));
        Assertions.assertEquals(0, p.nachRechts(-1_000_000_000));
    }

    @Test
    void nachLinks() {
        p.nachRechts(1);
        Assertions.assertEquals(0, p.nachLinks(1));
        Assertions.assertEquals(0, p.nachLinks(1_000_000_000));
        Assertions.assertEquals(2, p.nachLinks(-1_000_000_000));
    }

    @Test
    void fuell() {
        Assertions.assertEquals(50, p.fuell(50));
        Assertions.assertEquals(100, p.fuell(1_000_000_000));
        Assertions.assertEquals(0, p.fuell(-150));
    }

    @Test
    void gibAlles() {
        p.fuell(1_000_000_000);
        Assertions.assertEquals(100, p.gibAlles());
        Assertions.assertEquals(0, p.fuell(0));
    }
}