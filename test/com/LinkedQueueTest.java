package com;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author maus
 */
public class LinkedQueueTest {

    private LinkedQueue queue1, queue2;

    @BeforeEach
    public void setUp() {
        queue1 = new LinkedQueue();
        for (int i = 0; i < 6; i++) {
            queue1.add(i);
        }
        queue2 = new LinkedQueue();
        queue2.add("Eins");
        queue2.add("Zwei");
        queue2.add("Drei");
    }

    /**
     * Test of size method, of class LinkedQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        assertEquals(6, queue1.size());
        assertEquals(3, queue2.size());
        queue1 = new LinkedQueue();
        assertEquals(0, queue1.size());
        queue1.add(1);
        queue1.add(1);
        queue1.add(1);
        assertEquals(3, queue1.size());
        queue1.get();
        assertEquals(2, queue1.size());
    }

    /**
     * Test of isEmpty method, of class LinkedQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertFalse(queue1.isEmpty());
        assertFalse(queue2.isEmpty());
        queue1 = new LinkedQueue();
        assertTrue(queue1.isEmpty());
        for (int i = 0; i < 3; i++) {
            queue2.get();
        }
        assertTrue(queue2.isEmpty());
    }

    /**
     * Test of add method, of class LinkedQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        for (int i = 0; i < 3; i++) {
            assertEquals(i, queue1.get());
        }
        for (int i = 0; i < 3; i++) {
            queue1.add(i);
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(i + 3, queue1.get());
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(i, queue1.get());
        }
        System.out.println(queue1.toString());
        assertNull(queue1.get());
        assertEquals("Eins", queue2.get());
        queue2.add("Vier");
        assertEquals("Zwei", queue2.get());
        assertEquals("Drei", queue2.get());
        assertEquals("Vier", queue2.get());
        assertNull(queue2.get());
    }

    /**
     * Test of getNth method, of class LinkedQueue.
     */
    @Test
    public void testGetNth() {
        System.out.println("getNth");
        assertEquals(4, queue1.getNth(4));
        //assertEquals(5, queue1.getNth(4));
        assertNull(queue1.getNth(4));
        queue1.add(5);
        assertEquals(5, queue1.getNth(4));
        assertNull(queue1.getNth(-3));
        assertEquals(0, queue1.getNth(0));
        assertEquals(1, queue1.getNth(0));
        assertEquals("Zwei", queue2.getNth(1));
        queue2.add("Vier");
        assertEquals("Vier", queue2.getNth(2));
        assertEquals("Drei", queue2.getNth(1));
    }

    /**
     * Test of element method, of class LinkedQueue.
     */
    @Test
    public void testElement() {
        System.out.println("element");
        for (int i = 0; i < 6; i++) {
            assertEquals(0, queue1.element());
        }
        for (int i = 0; i < 6; i++) {
            assertEquals(queue1.element(), i);
            queue1.get();
        }
        assertEquals("Eins", queue2.element());
        queue2.get();
        assertEquals("Zwei", queue2.element());
        queue2.getNth(1);
        assertEquals("Zwei", queue2.element());
    }

    /**
     * Test of toString method, of class LinkedQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("[]", new LinkedQueue().toString());
        assertEquals("[0, 1, 2, 3, 4, 5]", queue1.toString());
        assertEquals("[Eins, Zwei, Drei]", queue2.toString());
        queue2.add("4");
        assertEquals("[Eins, Zwei, Drei, 4]", queue2.toString());
        queue2.getNth(1);
        assertEquals("[Eins, Drei, 4]", queue2.toString());
        queue2.getNth(2);
        assertEquals("[Eins, Drei]", queue2.toString());
    }

}