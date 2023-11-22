package com.kotlinground.bitmanipulation.countbits

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class CountBitsTest {
    @Test
    fun `should return (0,1,1) for input of 2`() {
        val input = 2
        val expected = intArrayOf(0, 1, 1)
        val actual = countBits(input)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return (0,1,1,2,1,2) for input of 5`() {
        val input = 5
        val expected = intArrayOf(0, 1, 1, 2, 1, 2)
        val actual = countBits(input)
        assertContentEquals(expected, actual)
    }
}
