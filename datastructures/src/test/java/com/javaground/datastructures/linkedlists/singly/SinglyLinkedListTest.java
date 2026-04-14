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
}
