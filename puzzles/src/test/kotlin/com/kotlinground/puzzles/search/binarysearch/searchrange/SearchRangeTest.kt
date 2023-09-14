package com.kotlinground.puzzles.search.binarysearch.searchrange

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SearchRangeTest {
    @Test
    fun `should return (3, 4) for nums=(5, 7, 7, 8, 8, 10) and target 8`() {
        val nums = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 8
        val expected = intArrayOf(3, 4)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (-1, -1) for nums=(5, 7, 7, 8, 8, 10) and target 6`() {
        val nums = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 6
        val expected = intArrayOf(-1, -1)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (-1, -1) for nums=() and target 0`() {
        val nums = intArrayOf()
        val target = 0
        val expected = intArrayOf(-1, -1)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (0, 0) for nums=(1) and target 1`() {
        val nums = intArrayOf(1)
        val target = 1
        val expected = intArrayOf(0, 0)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (0, 1) for nums=(2, 2) and target 2`() {
        val nums = intArrayOf(2, 2)
        val target = 2
        val expected = intArrayOf(0, 1)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (0, 0) for nums=(1, 3) and target 1`() {
        val nums = intArrayOf(1, 3)
        val target = 1
        val expected = intArrayOf(0, 0)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (1, 1) for nums=(1, 4) and target 4`() {
        val nums = intArrayOf(1, 4)
        val target = 4
        val expected = intArrayOf(1, 1)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (1, 1) for nums=(1, 2, 3) and target 2`() {
        val nums = intArrayOf(1, 2, 3)
        val target = 2
        val expected = intArrayOf(1, 1)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `should return (0, 2) for nums=(3, 3, 3) and target 3`() {
        val nums = intArrayOf(3, 3, 3)
        val target = 3
        val expected = intArrayOf(0, 2)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }
}
