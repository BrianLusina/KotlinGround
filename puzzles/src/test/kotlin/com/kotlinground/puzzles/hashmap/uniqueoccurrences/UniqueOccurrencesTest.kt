package com.kotlinground.puzzles.hashmap.uniqueoccurrences

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UniqueOccurrencesTest {
    @Test
    fun `should return true for arr = 1,2,2,1,1,3`() {
        val arr = intArrayOf(1, 2, 2, 1, 1, 3)
        val actual = uniqueOccurrences(arr)
        assertTrue(actual)
    }

    @Test
    fun `should return false for arr = 1,2`() {
        val arr = intArrayOf(1, 2)
        val actual = uniqueOccurrences(arr)
        assertFalse(actual)
    }

    @Test
    fun `should return true for arr = -3,0,1,-3,1,1,1,-3,10,0`() {
        val arr = intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)
        val actual = uniqueOccurrences(arr)
        assertTrue(actual)
    }

    @Test
    fun `should return false for arr = 1,2,4,3,1,3,3,4`() {
        val arr = intArrayOf(1, 2, 4, 3, 1, 3, 3, 4)
        val actual = uniqueOccurrences(arr)
        assertFalse(actual)
    }

    @Test
    fun `should return true for arr = 1,2,4,3,1,3,3,4,4,4`() {
        val arr = intArrayOf(1, 2, 4, 3, 1, 3, 3, 4, 4, 4)
        val actual = uniqueOccurrences(arr)
        assertTrue(actual)
    }

    @Test
    fun `should return true for arr = -1,-1,-1,-3,-1,-1`() {
        val arr = intArrayOf(-1, -1, -1, -3, -1, -1)
        val actual = uniqueOccurrences(arr)
        assertTrue(actual)
    }
}