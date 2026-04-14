package com.javaground.datastructures.linkedlists.singly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    @DisplayName("Can create a SinglyLinkedList and append data to it")
    void testCanCreateAndAppend() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);

        assertNotNull(list.headNode());
        assertEquals(1, list.headNode().data);
    }

    @Test
    @DisplayName("Can pop the last item from a linked list")
    void testCanPopTheLastItem() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);

        assertEquals(3, list.pop().data);
        assertEquals(2, list.pop().data);
        assertEquals(1, list.pop().data);
        assertNull(list.pop());
    }
}
