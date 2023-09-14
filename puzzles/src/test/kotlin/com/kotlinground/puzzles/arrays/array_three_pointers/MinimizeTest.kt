package com.kotlinground.puzzles.arrays.array_three_pointers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimizeTest {
    @Test
    fun `should return 5 for a=(1, 4, 10), b =(2, 15, 20), c =(10, 12)`() {
        val a = listOf(1, 4, 10)
        val b = listOf(2, 15, 20)
        val c = listOf(10, 12)
        val expected = 5
        val actual = minimize(a, b, c)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 for a=(20, 24, 100), b =(2, 19, 22, 79, 800), c =(10, 12, 23, 24, 119)`() {
        val a = listOf(20, 24, 100)
        val b = listOf(2, 19, 22, 79, 800)
        val c = listOf(10, 12, 23, 24, 119)
        val expected = 2
        val actual = minimize(a, b, c)
        assertEquals(expected, actual)
    }
}
