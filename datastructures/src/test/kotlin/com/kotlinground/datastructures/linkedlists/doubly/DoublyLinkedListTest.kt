package com.kotlinground.datastructures.linkedlists.doubly

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
