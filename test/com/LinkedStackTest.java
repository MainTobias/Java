package com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author maus
 */
public class LinkedStackTest {
    private LinkedStack stack1, stack2;

    public LinkedStackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stack1 = new LinkedStack();
        stack2 = new LinkedStack();
        for (int i = 0; i < 5; i++) {
            stack1.push(i + 1);
        }
        for (int i = 0; i < 5; i++) {
            stack2.push(i % 3 + 1);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        assertEquals(stack1.size(), 5);
        assertEquals(stack2.size(), 5);
        stack1.push("Hugo");
        stack1.push("Sepp");
        assertEquals(stack1.size(), 7);
        for (int i = 0; i < 3; i++) {
            stack1.pop();
        }
        assertEquals(stack1.size(), 4);
        for (int i = 0; i < 4; i++) {
            stack1.pop();
        }
        assertNull(stack1.pop());
    }

    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        for (int i = 0; i < 5; i++) {
            stack1.push(i * 3);
        }
        assertEquals(stack1.size(), 10);
        assertEquals(stack1.element(), 12);
        for (int i = 0; i < 9; i++) {
            stack1.pop();
        }
        assertEquals(stack1.size(), 1);
        assertEquals(stack1.element(), 1);
    }

    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        //siehe push
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertFalse(stack1.isEmpty());
        assertFalse(stack2.isEmpty());
        for (int i = 0; i < 5; i++) {
            stack1.pop();
        }
        assertTrue(stack1.isEmpty());
        stack2 = new LinkedStack();
        assertTrue(stack2.isEmpty());
    }

    /**
     * Test of element method, of class LinkedStack.
     */
    @Test
    public void testElement() {
        System.out.println("element");
        for (int i = 0; i < 5; i++) {
            assertEquals(stack1.element(), 5 - i);
            stack1.pop();
        }
        assertNull(stack1.element());
        for (int i = 4; i >= 0; i--) {
            assertEquals(stack2.element(), i % 3 + 1);
            stack2.pop();
        }
        assertNull(stack2.element());
    }

    /**
     * Test of toString method, of class LinkedStack.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("5\n4\n3\n2\n1\n", stack1.toString());
        assertEquals("2\n1\n3\n2\n1\n", stack2.toString());
        stack1.pop();
        stack2.push("Hugo");
        assertEquals("4\n3\n2\n1\n", stack1.toString());
        stack1.element();
        assertEquals("4\n3\n2\n1\n", stack1.toString());
        assertEquals("Hugo\n2\n1\n3\n2\n1\n", stack2.toString());
    }

}