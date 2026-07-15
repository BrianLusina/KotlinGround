package com.kotlinground.datastructures.arrays.arrayadvancegame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArrayAdvanceGameTest {
    @Test
    fun `should return true for 3, 3, 1, 0, 2, 0, 1`() {
        val a = intArrayOf(3, 3, 1, 0, 2, 0, 1)
        val actual = arrayAdvance(a)
        assertTrue(actual)
    }

    @Test
    fun `should return false for 3, 2, 0, 0, 2, 0, 1`() {
        val a = intArrayOf(3, 2, 0, 0, 2, 0, 1)
        val actual = arrayAdvance(a)
        assertFalse(actual)
    }

    @Test
    fun `should return true for 1, 4, 1, 1, 0, 2, 3`() {
        val a = intArrayOf(1, 4, 1, 1, 0, 2, 3)
        val actual = arrayAdvance(a)
        assertTrue(actual)
    }
}
