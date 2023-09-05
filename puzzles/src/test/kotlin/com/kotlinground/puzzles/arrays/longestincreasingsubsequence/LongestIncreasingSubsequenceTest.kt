package com.kotlinground.puzzles.arrays.longestincreasingsubsequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceTest {

    @Test
    fun `should return 3 from input of (1, 2, 1, 5)`() {
        val nums = intArrayOf(1, 2, 1, 5)
        val expected = 3
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 6 from input of (0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)`() {
        val nums = intArrayOf(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)
        val expected = 6
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 from input of (3, 10, 2, 1, 20)`() {
        val nums = intArrayOf(3, 10, 2, 1, 20)
        val expected = 3
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from input of (3, 2)`() {
        val nums = intArrayOf(3, 2)
        val expected = 1
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from input of (50, 3, 10, 7, 40, 80)`() {
        val nums = intArrayOf(50, 3, 10, 7, 40, 80)
        val expected = 4
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from input of (10,9,2,5,3,7,101,18)`() {
        val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
        val expected = 4
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from input of (0,1,0,3,2,3)`() {
        val nums = intArrayOf(0, 1, 0, 3, 2, 3)
        val expected = 4
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from input of (7,7,7,7,7,7,7)`() {
        val nums = intArrayOf(7, 7, 7, 7, 7, 7, 7)
        val expected = 1
        val actual = longestIncreasingSubsequence(nums)
        assertEquals(expected, actual)
    }
}
