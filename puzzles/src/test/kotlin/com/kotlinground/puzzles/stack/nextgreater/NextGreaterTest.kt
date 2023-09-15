package com.kotlinground.puzzles.stack.nextgreater

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextGreaterTest {
    @Test
    fun `should return (5, 10, 10, -1) from an input (4, 5, 2, 10)`() {
        val nums = intArrayOf(4, 5, 2, 10)
        val expected = intArrayOf(5, 10, 10, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (-1, -1, -1) from an input (3, 2, 1)`() {
        val nums = intArrayOf(3, 2, 1)
        val expected = intArrayOf(-1, -1, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (5, 25, 25, -1) from an input (4, 5, 2, 25)`() {
        val nums = intArrayOf(4, 5, 2, 25)
        val expected = intArrayOf(5, 25, 25, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (-1, 12, 12, -1) from an input (13, 7, 6, 12)`() {
        val nums = intArrayOf(13, 7, 6, 12)
        val expected = intArrayOf(5, 25, 25, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (1) from an input (-1)`() {
        val nums = intArrayOf(1)
        val expected = intArrayOf(-1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (35 42 42 -1 28 39 -1 28 -1) from an input (34, 35, 27, 42, 5, 28, 39, 20, 28)`() {
        val nums = intArrayOf(34, 35, 27, 42, 5, 28, 39, 20, 28)
        val expected = intArrayOf(35, 42, 42, -1, 28, 39, -1, 28 - 1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (13, 21, -1, -1) from an input (11, 13, 21, 3)`() {
        val nums = intArrayOf(11, 13, 21, 3)
        val expected = intArrayOf(13, 21, -1, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (13, 21, -1, -1) from an input (6, 8, 0, 1, 3)`() {
        val nums = intArrayOf(6, 8, 0, 1, 3)
        val expected = intArrayOf(8, -1, 1, 3, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (8 -1 6 2 6 7 -1 -1) from an input (3, 8, 4, 1, 2, 6, 7, 2)`() {
        val nums = intArrayOf(3, 8, 4, 1, 2, 6, 7, 2)
        val expected = intArrayOf(8, -1, 6, 2, 6, 7, -1, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (3, 4, 4, -1) from an input (1, 3, 2, 4)`() {
        val nums = intArrayOf(1, 3, 2, 4)
        val expected = intArrayOf(3, 4, 4, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (8, -1, 4, -1) from an input (7, 8, 1, 4)`() {
        val nums = intArrayOf(7, 8, 1, 4)
        val expected = intArrayOf(8, -1, 4, -1)
        val actual = nextGreater(nums)
        assertArrayEquals(expected, actual)
    }
}
