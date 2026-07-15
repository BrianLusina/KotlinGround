package com.kotlinground.datastructures.stack.dynamic

import com.kotlinground.datastructures.utils.NullableWrapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class DynamicSizedStackTest {

    @Test
    fun `push and pop single element works and updates size or isEmpty correctly`() {
        val s = DynamicSizedStack<Int>()
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
        val s = DynamicSizedStack<String>()
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
        val s = DynamicSizedStack<Int>()
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
    fun `Underflow on pop and peek when empty`() {
        val s = DynamicSizedStack<Int>()
        val ex1 = assertThrows(IllegalStateException::class.java) { s.pop() }
        assertTrue(ex1.message?.lowercase()?.contains("underflow") == true)

        val ex2 = assertThrows(IllegalStateException::class.java) { s.peek() }
        assertTrue(ex2.message?.lowercase()?.contains("empty") == true)
    }

    @Test
    fun `Null elements are allowed and behave correctly`() {
        val s = DynamicSizedStack.forNullable<Int>()
        s.push(NullableWrapper(null))
        assertEquals(1, s.size)
        assertNull(s.peek())
        assertEquals(1, s.size)
        assertNull(s.pop())
        assertEquals(0, s.size)
        assertTrue(s.isEmpty)
    }
}