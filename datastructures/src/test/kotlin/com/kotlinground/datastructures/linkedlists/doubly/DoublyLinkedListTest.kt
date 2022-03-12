package com.kotlinground.datastructures.linkedlists.doubly

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
