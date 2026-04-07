package com.javaground.datastructures.stack.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicSizedStackTest {

    @Test
    @DisplayName("push/pop single element works and updates size/isEmpty correctly")
    void pushPopSingle() {
        DynamicSizedStack<Integer> s = new DynamicSizedStack<>();
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
        DynamicSizedStack<String> s = new DynamicSizedStack<>();
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
        DynamicSizedStack<Integer> s = new DynamicSizedStack<>();
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
    @DisplayName("Underflow on pop and peek when empty")
    void underflowOnEmpty() {
        DynamicSizedStack<Integer> s = new DynamicSizedStack<>();
        IllegalStateException ex1 = assertThrows(IllegalStateException.class, s::pop);
        assertTrue(ex1.getMessage().toLowerCase().contains("underflow"));

        IllegalStateException ex2 = assertThrows(IllegalStateException.class, s::peek);
        assertTrue(ex2.getMessage().toLowerCase().contains("empty"));
    }

    @Test
    @DisplayName("Null elements are allowed and behave correctly")
    void nullElementHandling() {
        DynamicSizedStack<Integer> s = new DynamicSizedStack<>();
        s.push(null);
        assertEquals(1, s.size());
        assertNull(s.peek());
        assertEquals(1, s.size());
        assertNull(s.pop());
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
    }
}