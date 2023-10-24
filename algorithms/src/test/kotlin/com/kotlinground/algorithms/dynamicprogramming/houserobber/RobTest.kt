package com.kotlinground.algorithms.dynamicprogramming.houserobber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RobTest {
    @Test
    fun `should return 4 for nums = (1,2,3,1)`() {
        val nums = intArrayOf(1, 2, 3, 1)
        val expected = 4
        val actual = rob(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 for nums = (2,7,9,3,1)`() {
        val nums = intArrayOf(2, 7, 9, 3, 1)
        val expected = 12
        val actual = rob(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0 for nums = ()`() {
        val nums = intArrayOf()
        val expected = 0
        val actual = rob(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 for nums = (3)`() {
        val nums = intArrayOf(3)
        val expected = 3
        val actual = rob(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 5 for nums = (3, 5)`() {
        val nums = intArrayOf(3, 5)
        val expected = 5
        val actual = rob(nums)
        assertEquals(expected, actual)
    }
}
