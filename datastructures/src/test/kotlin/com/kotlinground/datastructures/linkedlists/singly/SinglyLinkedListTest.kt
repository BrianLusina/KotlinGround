package com.kotlinground.datastructures.linkedlists.singly

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SinglyLinkedListTest {

    @Test
    fun `should reverse the list making the head the tail and vice versa`() {
        val node5 = SinglyLinkedListNode(5)
        val node4 = SinglyLinkedListNode(4, node5)
        val node3 = SinglyLinkedListNode(3, node4)
        val node2 = SinglyLinkedListNode(2, node3)
        val head = SinglyLinkedListNode(1, node2)
        val singlyLinkedList = SinglyLinkedList(head)
        singlyLinkedList.reverse()

        val actualHead = singlyLinkedList.headNode()

        assertEquals(node5, actualHead)
    }

    @Test
    fun `should reverse list of 1-2 to 2-1`() {
        val node2 = SinglyLinkedListNode(2)
        val head = SinglyLinkedListNode(1, node2)
        val singlyLinkedList = SinglyLinkedList(head)
        singlyLinkedList.reverse()

        val actualHead = singlyLinkedList.headNode()

        assertEquals(node2, actualHead)
    }

    @Test
    fun `should reverse empty list`() {
        val singlyLinkedList = SinglyLinkedList<Int>(null)
        singlyLinkedList.reverse()

        val actualHead = singlyLinkedList.headNode()
        assertNull(actualHead)
    }
}
