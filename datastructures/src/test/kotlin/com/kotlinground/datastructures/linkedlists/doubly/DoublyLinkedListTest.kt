package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.generateKey
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class DoublyLinkedListTest {
    private lateinit var subject: DoublyLinkedList<Int>

    @BeforeEach
    fun setUp() {
        subject = DoublyLinkedList()
    }

    @Test
    fun pushPop() {
        subject.append(10)
        subject.append(20)
        assertEquals(20, subject.pop())
        assertEquals(10, subject.pop())
    }

    @Test
    fun pushShift() {
        subject.append(10)
        subject.append(20)
        assertEquals(10, subject.shift())
        assertEquals(20, subject.shift())
    }

    @Test
    fun unshiftShift() {
        subject.prepend(10)
        subject.prepend(20)
        assertEquals(20, subject.shift())
        assertEquals(10, subject.shift())
    }

    @Test
    fun unshiftPop() {
        subject.prepend(10)
        subject.prepend(20)
        assertEquals(10, subject.pop())
        assertEquals(20, subject.pop())
    }

    @Test
    fun example() {
        subject.append(10)
        subject.append(20)
        assertEquals(20, subject.pop())

        subject.append(30)
        assertEquals(10, subject.shift())

        subject.prepend(40)
        subject.append(50)
        assertEquals(40, subject.shift())
        assertEquals(50, subject.pop())
        assertEquals(30, subject.shift())
    }
}

class DoublyLinkedListMoveTailToHead {

    @Test
    fun `should move tail of (r, a, c, e, c, a, r) to become (r, r, a, c, e, c, a)`() {
        val singlyLinkedList = DoublyLinkedList<String>()
        val data = arrayOf("r", "a", "c", "e", "c", "a", "r")
        for (d in data) {
            singlyLinkedList.append(d)
        }

        val expected = "r"

        singlyLinkedList.moveTailToHead()
        val actual = singlyLinkedList.headNode()
        assertNotNull(actual)
        kotlin.test.assertEquals(expected, actual.data)

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
        val singlyLinkedList = DoublyLinkedList<String>()
        val data = arrayOf("a", "b", "c", "d")
        for (d in data) {
            singlyLinkedList.append(d)
        }

        val expected = "d"

        singlyLinkedList.moveTailToHead()

        val actual = singlyLinkedList.headNode()
        assertNotNull(actual)
        kotlin.test.assertEquals(expected, actual.data)

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


class DoublyLinkedInsertAfter {

    @Test
    fun `Should insert E after B in list A-B-C-D to become A-B-E-C-D`() {
        val doublyLinkedList = DoublyLinkedList<String>()
        val data = arrayListOf("A", "B", "C", "D")
        for (d in data) {
            doublyLinkedList.append(d)
        }
        val actual = doublyLinkedList.headNode()
        assertNotNull(actual)

        val expected = arrayListOf("A", "B", "E", "C", "D")
        val newData = "E"
        val key = generateKey("B")
        doublyLinkedList.insertAfter(newData, key)

        val actualData = arrayListOf<String>()

        for (node in doublyLinkedList) {
            actualData.add(node.data)
        }

        assertContentEquals(expected, actualData)
    }
}


class DoublyLinkedDeleteByKeyTest {
    @Test
    fun `should delete a node 5 from linked list (1-2-3-4-5-6) to become (1-2-3-4-6)`() {
        val data = intArrayOf(1, 2, 3, 4, 5, 6)
        val expected = arrayListOf(1, 2, 3, 4, 6)
        val linkedList = DoublyLinkedList<Int>()

        for (d in data) {
            linkedList.append(d)
        }

        linkedList.deleteNodeByKey("5")

        val actualHead = linkedList.headNode()
        assertNotNull(actualHead)

        val actualData = arrayListOf<Int>()
        for (node in linkedList) {
            actualData.add(node.data)
        }

        kotlin.test.assertEquals(expected, actualData)
    }
}


class DoublyLinkedListReverseTest {

    @Test
    fun `should reverse the list making the head the tail and vice versa`() {
        val node5 = DoublyLinkedListNode(5)
        val node4 = DoublyLinkedListNode(4, node5)
        val node3 = DoublyLinkedListNode(3, node4)
        val node2 = DoublyLinkedListNode(2, node3)
        val head = DoublyLinkedListNode(1, node2)
        val doublyLinkedList = DoublyLinkedList<Int>(head)
        doublyLinkedList.reverse()

        val actualHead = doublyLinkedList.headNode()

        assertEquals(node5, actualHead)
    }

    @Test
    fun `should reverse list of 1-2 to 2-1`() {
        val node2 = DoublyLinkedListNode(2)
        val head = DoublyLinkedListNode(1, node2)
        val doublyLinkedList = DoublyLinkedList(head)
        doublyLinkedList.reverse()

        val actualHead = doublyLinkedList.headNode()

        kotlin.test.assertEquals(node2, actualHead)
    }

    @Test
    fun `should reverse empty list`() {
        val doublyLinkedList = DoublyLinkedList<Int>(null)
        doublyLinkedList.reverse()

        val actualHead = doublyLinkedList.headNode()
        assertNull(actualHead)
    }
}


class DoublyLinkedListRemoveDuplicatesTest {

    private fun <T> runTestAssertion(data: ArrayList<T>, expected: ArrayList<T>) {
        val doublyLinkedList = DoublyLinkedList<T>()
        for (d in data) {
            doublyLinkedList.append(d)
        }

        doublyLinkedList.removeDuplicates()

        val actualData = arrayListOf<T>()
        for (current in doublyLinkedList) {
            actualData.add(current.data)
        }

        assertContentEquals(expected, actualData)
    }

    @Test
    fun `should return null for empty list`() {
        val doublyLinkedList = DoublyLinkedList<Any>(null)
        val actual = doublyLinkedList.removeDuplicates()

        assertNull(actual)
    }

    @Test
    fun `should removes duplicates from (1,6,1,4,2,2,4) to become (1,6,4,2)`() {
        val data = arrayListOf(1, 6, 1, 4, 2, 2, 4)
        val expected = arrayListOf(1, 6, 4, 2)
        runTestAssertion(data, expected)
    }

    @Test
    fun `Should remove duplicates from list of 1-4-7-4 to 1-4-7`() {
        val data = arrayListOf(1, 4, 7, 4)
        val expected = arrayListOf(1, 4, 7)
        runTestAssertion(data, expected)
    }
}
