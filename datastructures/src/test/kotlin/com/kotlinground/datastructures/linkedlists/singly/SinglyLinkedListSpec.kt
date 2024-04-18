package com.kotlinground.datastructures.linkedlists.singly

import org.spekframework.spek2.Spek
import kotlin.test.assertEquals

object SinglyLinkedListSpec : Spek({
    group("Delete node by position") {
        test("linked list is [1,3,4,7,1,2,6], delete node at position 0") {
            val node5 = SinglyLinkedListNode(5)
            val node4 = SinglyLinkedListNode(4, node5)
            val node3 = SinglyLinkedListNode(3, node4)
            val node2 = SinglyLinkedListNode(2, node3)
            val head = SinglyLinkedListNode(1, node2)
            val singlyLinkedList = SinglyLinkedList(head)

            val actual = singlyLinkedList.deleteNodeAtPosition(0)
            assertEquals(head, actual)
        }
    }
})
