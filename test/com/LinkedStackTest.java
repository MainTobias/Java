package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LinkedStackTest {
    LinkedStack ls = new LinkedStack();

    @Test
    void test() {
        String s = Datei.öfffne("test.txt");
        for (String si : s.split("\n")) {
            ls.push(si);
        }
        StringBuilder sb = new StringBuilder();
        while (!ls.isEmpty()) {
            sb.append(ls.pop());
        }
        Assertions.assertEquals("CBA", sb.toString());
    }
}