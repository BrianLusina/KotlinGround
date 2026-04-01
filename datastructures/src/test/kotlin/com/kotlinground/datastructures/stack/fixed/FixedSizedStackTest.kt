package com.kotlinground.datastructures.stack.fixed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class FixedSizedStackTest {

    @Test
    fun `Constructor rejects non-positive capacities`() {
        val ex1 = assertThrows(IllegalArgumentException::class.java) {
            FixedSizedStack<Int>(0)
        }
        assertTrue(
            ex1.message?.lowercase()?.contains("maxsize") == true ||
                    ex1.message?.lowercase()?.contains("maxsize") == true ||
                    ex1.message?.lowercase()?.contains("maxsize") == true
        )

        val ex2 = assertThrows(IllegalArgumentException::class.java) { FixedSizedStack<Int>(-5) }
        assertTrue(
            ex2.message?.lowercase()?.contains("maxsize") == true ||
                    ex2.message?.lowercase()?.contains("maxsize") == true
        )
    }

    @Test
    fun `push and pop single element works and updates size or isEmpty correctly`() {
        val s = FixedSizedStack<Int>(3)
        assertEquals(0, s.size)
        assertTrue(s.isEmpty)

        s.push(42)
        assertEquals(1, s.size)
        assertFalse(s.isEmpty)

        val v = s.pop()
        assertEquals(42, v)
        assertEquals(0, s.size)
        assertTrue(s.isEmpty)
    }

    @Test
    fun `LIFO order preserved with multiple pushes and pops`() {
        val s = FixedSizedStack<String>(5)
        s.push("a")
        s.push("b")
        s.push("c")
        assertEquals(3, s.size)

        assertEquals("c", s.pop())
        assertEquals("b", s.pop())
        assertEquals("a", s.pop())
        assertEquals(0, s.size)
        assertTrue(s.isEmpty)
    }

    @Test
    fun `peek returns top without removing it`() {
        val s = FixedSizedStack<Int>(2)
        s.push(10)
        s.push(20)
        assertEquals(2, s.size)

        assertEquals(20, s.peek())
        // size should remain unchanged
        assertEquals(2, s.size)
        assertEquals(20, s.pop())
        assertEquals(10, s.pop())
    }

    @Test
    fun `Overflow when pushing beyond capacity`() {
        val s = FixedSizedStack<Int>(2)
        s.push(1)
        s.push(2)
        val ex = assertThrows(IllegalStateException::class.java) { s.push(3) }
        assertTrue(ex.message?.lowercase()?.contains("overflow") == true)
        assertEquals(2, s.size)
    }

    @Test
    fun `Underflow on pop and peek when empty`() {
        val s = FixedSizedStack<Int>(1)
        val ex1 = assertThrows(IllegalStateException::class.java) { s.pop() }
        assertTrue(ex1.message?.lowercase()?.contains("underflow") == true)

        val ex2 = assertThrows(IllegalStateException::class.java) { s.peek() }
        assertTrue(ex2.message?.lowercase()?.contains("empty") == true)
    }

    @Test
    fun `Null elements are allowed and behave correctly`() {
        val s = FixedSizedStack<Int?>(2)
        s.push(null)
        assertEquals(1, s.size)
        assertNull(s.peek())
        assertEquals(1, s.size)
        assertNull(s.pop())
        assertEquals(0, s.size)
        assertTrue(s.isEmpty)
    }
}