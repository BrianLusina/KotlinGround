package com.javaground.datastructures.linkedlists.singly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SinglyLinkedListNodeTest {
    @Test
    @DisplayName("Can construct a single linked list node")
    void canConstructNode() {
        SinglyLinkedListNode<String> first = new SinglyLinkedListNode<>("to");
        SinglyLinkedListNode<String> second = new SinglyLinkedListNode<>("be");
        SinglyLinkedListNode<String> third = new SinglyLinkedListNode<>("or", null);
        first.next = second;
        second.next = third;

        assertEquals(first.next, second);
        assertEquals("to", first.data);
        assertEquals(second.next, third);
        assertEquals("be", second.data);
        assertEquals("or", third.data);
        assertNull(third.next);
    }
}
