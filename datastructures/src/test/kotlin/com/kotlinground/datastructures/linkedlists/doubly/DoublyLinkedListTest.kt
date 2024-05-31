package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.circular.CircularLinkedList
import com.kotlinground.datastructures.linkedlists.generateKey
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertNotNull

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