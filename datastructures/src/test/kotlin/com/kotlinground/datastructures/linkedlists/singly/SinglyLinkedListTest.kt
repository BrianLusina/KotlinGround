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

class SingleLinkedListDeleteMiddleNodeTest {
    @Test
    fun `should delete middle node from linked list of (1,3,4,7,1,2,6)`() {
        val values = intArrayOf(1, 3, 4, 7, 1, 2, 6)
        val singlyLinkedList = SinglyLinkedList<Int>()
        for (value in values) {
            singlyLinkedList.append(value)
        }
        val expected = SinglyLinkedListNode(7)
        val actual = singlyLinkedList.deleteMiddle()

        assertEquals(expected, actual)
    }

    @Test
    fun `should delete middle node from linked list of (1,3,4,7,1,2,6) using 2 pointers`() {
        val values = intArrayOf(1, 3, 4, 7, 1, 2, 6)
        val singlyLinkedList = SinglyLinkedList<Int>()
        for (value in values) {
            singlyLinkedList.append(value)
        }
        val expected = SinglyLinkedListNode(7)
        val actual = singlyLinkedList.deleteMiddle2Pointers()

        assertEquals(expected, actual)
    }
}

class SingleLinkedListOddEvenTest {
    private fun runTest(data: IntArray, expected: IntArray) {
        val linkedList = SinglyLinkedList<Int>()
        for (d in data) {
            linkedList.append(d)
        }

        var actualHead = linkedList.oddEvenList()
        val actualNodes = arrayListOf<Int>()

        while (actualHead != null) {
            actualNodes.add(actualHead.data)
            actualHead = actualHead.next
        }

        val zipped = actualNodes.toIntArray() zip expected

        for ((expectedNode, actualNode) in zipped) {
            assertEquals(expectedNode, actualNode)
        }
    }

    @Test
    fun `should return (1,3,5,2,4) from linked list of (1,2,3,4,5)`() {
        val values = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(1, 3, 5, 2, 4)
        runTest(values, expected)
    }

    @Test
    fun `should return (2,1,3,5,6,4,7) from linked list of (2,3,6,7,1,5,4)`() {
        val values = intArrayOf(2, 1, 3, 5, 6, 4, 7)
        val expected = intArrayOf(2, 3, 6, 7, 1, 5, 4)
        runTest(values, expected)
    }
}

class SingleLinkedListMaxPairSumTest {
    @Test
    fun `should return 6 from a linked list of (5,4,2,1) using list of integers`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(5, 4, 2, 1)
        for (d in values) {
            linkedList.append(d)
        }

        val expected = 6
        val actual = maximumPairSum(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 7 from a linked list of (4,2,2,3) using list of integers`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(4, 2, 2, 3)
        for (d in values) {
            linkedList.append(d)
        }

        val expected = 7
        val actual = maximumPairSum(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 100001 from a linked list of (1,100000) using list of integers`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(1, 100000)
        val expected = 100001
        for (d in values) {
            linkedList.append(d)
        }

        val actual = maximumPairSum(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 6 from a linked list of (5,4,2,1) using stack`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(5, 4, 2, 1)
        for (d in values) {
            linkedList.append(d)
        }

        val expected = 6
        val actual = maximumPairSumStack(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 7 from a linked list of (4,2,2,3) using stack`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(4, 2, 2, 3)
        for (d in values) {
            linkedList.append(d)
        }

        val expected = 7
        val actual = maximumPairSumStack(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 7 from a linked list of (1,100000) using stack`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(1, 100000)
        val expected = 100001
        for (d in values) {
            linkedList.append(d)
        }

        val actual = maximumPairSumStack(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 6 from a linked list of (5,4,2,1) using reverse in place`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(5, 4, 2, 1)
        for (d in values) {
            linkedList.append(d)
        }

        val expected = 6
        val actual = maximumPairSumReverseInPlace(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 7 from a linked list of (4,2,2,3) using reverse in place`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(4, 2, 2, 3)
        for (d in values) {
            linkedList.append(d)
        }

        val expected = 7
        val actual = maximumPairSumReverseInPlace(linkedList.headNode())
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 7 from a linked list of (1,100000) using reverse in place`() {
        val linkedList = SinglyLinkedList<Int>()
        val values = intArrayOf(1, 100000)
        val expected = 100001
        for (d in values) {
            linkedList.append(d)
        }

        val actual = maximumPairSumReverseInPlace(linkedList.headNode())
        assertEquals(expected, actual)
    }
}
