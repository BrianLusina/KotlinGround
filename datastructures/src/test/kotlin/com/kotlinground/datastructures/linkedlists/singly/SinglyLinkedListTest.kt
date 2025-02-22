package com.kotlinground.datastructures.linkedlists.singly

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

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

class SinglyLinkedListRemoveDuplicatesTest {

    @Test
    fun `should return null for empty list`() {
        val singlyLinkedList = SinglyLinkedList<Any>(null)
        val actual = singlyLinkedList.removeDuplicates()

        assertNull(actual)
    }

    @Test
    fun `should removes duplicates from (1,6,1,4,2,2,4) to become (1,6,4,2)`() {
        val singlyLinkedList = SinglyLinkedList<Int>()
        val data = intArrayOf(1, 6, 1, 4, 2, 2, 4)
        for (d in data) {
            singlyLinkedList.append(d)
        }

        val actualHead = singlyLinkedList.removeDuplicates()
        var current = actualHead
        val actualData = arrayListOf<Int>()

        while (current != null) {
            actualData.add(current.data)
            current = current.next
        }

        val expected = arrayListOf(1, 6, 4, 2)

        assertContentEquals(expected, actualData)
    }
}

class SinglyLinkedListNtToLastNodeTest {

    @Test
    fun `should return null for empty list`() {
        val singlyLinkedList = SinglyLinkedList<Any>(null)
        val actual = singlyLinkedList.nthToLastNode(1)

        assertNull(actual)
    }

    @Test
    fun `should return C for (A,B,C,D) for n = 2`() {
        val singlyLinkedList = SinglyLinkedList<String>()
        val data = arrayOf("A", "B", "C", "D")
        for (d in data) {
            singlyLinkedList.append(d)
        }
        val expected = "C"
        val actualNode = singlyLinkedList.nthToLastNode(2)
        assertNotNull(actualNode)
        assertEquals(expected, actualNode.data)
    }
}

class SinglyLinkedListRotateTest {

    @Test
    fun `should rotate (1,2,3,4,5,6) by k = 4 to (5, 6, 1, 2, 3, 4)`() {
        val singlyLinkedList = SinglyLinkedList<Int>()
        val data = arrayOf(1, 2, 3, 4, 5, 6)
        for (d in data) {
            singlyLinkedList.append(d)
        }
        val expected = 5
        val actualNode = singlyLinkedList.rotate(4)
        assertNotNull(actualNode)
        assertEquals(expected, actualNode.data)
    }
}

class SinglyLinkedListIsPalindromeTest {

    @Test
    fun `should return true for (r, a, c, e, c, a, r)`() {
        val singlyLinkedList = SinglyLinkedList<String>()
        val data = arrayOf("r", "a", "c", "e", "c", "a", "r")
        for (d in data) {
            singlyLinkedList.append(d)
        }

        val actual = singlyLinkedList.isPalindrome()
        assertTrue(actual)
    }

    @Test
    fun `should return true for (r, a, c, e, c, a, r) using two pointers`() {
        val singlyLinkedList = SinglyLinkedList<String>()
        val data = arrayOf("r", "a", "c", "e", "c", "a", "r")
        for (d in data) {
            singlyLinkedList.append(d)
        }

        val actual = singlyLinkedList.isPalindromeTwoPointers()
        assertTrue(actual)
    }
}

class SinglyLinkedListMoveTailToHead {

    @Test
    fun `should move tail of (r, a, c, e, c, a, r) to become (r, r, a, c, e, c, a)`() {
        val singlyLinkedList = SinglyLinkedList<String>()
        val data = arrayOf("r", "a", "c", "e", "c", "a", "r")
        for (d in data) {
            singlyLinkedList.append(d)
        }

        val expected = "r"

        singlyLinkedList.moveTailToHead()
        val actual = singlyLinkedList.headNode()
        assertNotNull(actual)
        assertEquals(expected, actual.data)

        var current = actual
        val actualData = arrayListOf<String>()

        while (current != null) {
            actualData.add(current.data)
            current = current.next
        }

        val expectedData = arrayListOf("r", "r", "a", "c", "e", "c", "a")

        assertContentEquals(expectedData, actualData)
    }

    @Test
    fun `should move tail of (a, b, c, d) to become (d, a, b, c)`() {
        val singlyLinkedList = SinglyLinkedList<String>()
        val data = arrayOf("a", "b", "c", "d")
        for (d in data) {
            singlyLinkedList.append(d)
        }

        val expected = "d"

        singlyLinkedList.moveTailToHead()

        val actual = singlyLinkedList.headNode()
        assertNotNull(actual)
        assertEquals(expected, actual.data)

        var current = actual
        val actualData = arrayListOf<String>()

        while (current != null) {
            actualData.add(current.data)
            current = current.next
        }

        val expectedData = arrayListOf("d", "a", "b", "c")

        assertContentEquals(expectedData, actualData)
    }
}

class SinglyLinkedSumTwoLinkedLists {

    @Test
    fun `Should sum 5-6-3 to 8-4-2 to become 3-1-6`() {
        val firstNumber = arrayOf(5, 6, 3)
        val firstLinkedList = SinglyLinkedList<Int>()
        for (num in firstNumber) {
            firstLinkedList.append(num)
        }

        val secondNumber = intArrayOf(8, 4, 2)
        val secondLinkedList = SinglyLinkedList<Int>()
        for (num in secondNumber) {
            secondLinkedList.append(num)
        }

        val expectedNumber = arrayListOf(3, 1, 6)

        val actual = firstLinkedList + secondLinkedList
        var current = actual.headNode()

        val actualNumber = arrayListOf<Int>()
        while (current != null) {
            actualNumber.add(current.data)
            current = current.next
        }

        assertContentEquals(expectedNumber, actualNumber)
    }
}

class SinglyLinkedDeleteNodeByPosition {

    @Test
    fun `Should delete node at position 0 of linked list (1,3,4,7,1,2,6)`() {
        val node5 = SinglyLinkedListNode(5)
        val node4 = SinglyLinkedListNode(4, node5)
        val node3 = SinglyLinkedListNode(3, node4)
        val node2 = SinglyLinkedListNode(2, node3)
        val head = SinglyLinkedListNode(1, node2)
        val singlyLinkedList = SinglyLinkedList(head)

        val actual = singlyLinkedList.deleteNodeAtPosition(0)
        assertEquals(head, actual)
    }

    @Test
    fun `Should delete node at position 1 of linked list (1,3,4,7,1,2,6)`() {
        val node5 = SinglyLinkedListNode(5)
        val node4 = SinglyLinkedListNode(4, node5)
        val node3 = SinglyLinkedListNode(3, node4)
        val node2 = SinglyLinkedListNode(2, node3)
        val head = SinglyLinkedListNode(1, node2)
        val singlyLinkedList = SinglyLinkedList(head)

        val actual = singlyLinkedList.deleteNodeAtPosition(1)
        assertEquals(node2, actual)
    }
}

class SinglyLinkedDeleteNthLastNode {

    @Test
    fun `should raise Exception when the value of n is out of bounds`() {
        val linkedList = SinglyLinkedList<Int>()
        val data = intArrayOf(43, 68, 11, 5, 69, 37, 70)
        for(d in data) {
            linkedList.append(d)
        }

        assertThrows<IllegalArgumentException> {
            linkedList.deleteNthLastNode(8)
        }
    }

    @Test
    fun `should delete nth last node where n=1 and list is (43,68,11,5,69,37,70) to become (43,68,11,5,69,37)`() {
        val linkedList = SinglyLinkedList<Int>()
        val data = intArrayOf(43,68,11,5,69,37,70)
        for(d in data) {
            linkedList.append(d)
        }

        val newHead = linkedList.deleteNthLastNode(0)
        assertNotNull(newHead)
        assertEquals(newHead.data, 43)

        val expected = intArrayOf(43,68,11,5,69,37)
        val actual = arrayListOf<Int>()

        for (node in linkedList) {
            actual.add(node.data)
        }

        assertContentEquals(expected, actual.toIntArray())
    }
}
