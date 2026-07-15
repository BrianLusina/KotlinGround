package com.javaground.datastructures.stack.fixed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizedStackTest {

    @Test
    @DisplayName("Constructor rejects non-positive capacities")
    void constructorValidation() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> new FixedSizedStack<>(0));
        assertTrue(ex1.getMessage().toLowerCase().contains("maxsize"));
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> new FixedSizedStack<>(-5));
        assertTrue(ex2.getMessage().toLowerCase().contains("maxsize"));
    }

    @Test
    @DisplayName("push/pop single element works and updates size/isEmpty correctly")
    void pushPopSingle() {
        FixedSizedStack<Integer> s = new FixedSizedStack<>(3);
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());

        s.push(42);
        assertEquals(1, s.size());
        assertFalse(s.isEmpty());

        int v = s.pop();
        assertEquals(42, v);
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
    }

    @Test
    @DisplayName("LIFO order preserved with multiple pushes/pops")
    void lifoOrder() {
        FixedSizedStack<String> s = new FixedSizedStack<>(5);
        s.push("a");
        s.push("b");
        s.push("c");
        assertEquals(3, s.size());

        assertEquals("c", s.pop());
        assertEquals("b", s.pop());
        assertEquals("a", s.pop());
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
    }

    @Test
    @DisplayName("peek returns top without removing it")
    void peekDoesNotRemove() {
        FixedSizedStack<Integer> s = new FixedSizedStack<>(2);
        s.push(10);
        s.push(20);
        assertEquals(2, s.size());

        assertEquals(20, s.peek());
        // size should remain unchanged
        assertEquals(2, s.size());
        assertEquals(20, s.pop());
        assertEquals(10, s.pop());
    }

    @Test
    @DisplayName("Overflow when pushing beyond capacity")
    void overflowOnPush() {
        FixedSizedStack<Integer> s = new FixedSizedStack<>(2);
        s.push(1);
        s.push(2);
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> s.push(3));
        assertTrue(ex.getMessage().toLowerCase().contains("overflow"));
        assertEquals(2, s.size());
    }

    @Test
    @DisplayName("Underflow on pop and peek when empty")
    void underflowOnEmpty() {
        FixedSizedStack<Integer> s = new FixedSizedStack<>(1);
        IllegalStateException ex1 = assertThrows(IllegalStateException.class, s::pop);
        assertTrue(ex1.getMessage().toLowerCase().contains("underflow"));

        IllegalStateException ex2 = assertThrows(IllegalStateException.class, s::peek);
        assertTrue(ex2.getMessage().toLowerCase().contains("empty"));
    }

    @Test
    @DisplayName("Null elements are allowed and behave correctly")
    void nullElementHandling() {
        FixedSizedStack<Integer> s = new FixedSizedStack<>(2);
        s.push(null);
        assertEquals(1, s.size());
        assertNull(s.peek());
        assertEquals(1, s.size());
        assertNull(s.pop());
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
    }
}
