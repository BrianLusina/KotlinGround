package com.kotlinground.puzzles.search.binarysearch.findpeakelement

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContains

class FindPeakElementTest {
    @Test
    fun `should return 2 for nums = (1,2,3,1)`() {
        val nums = intArrayOf(1, 2, 3, 1)
        val expected = 2
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return either 5 or 1 for nums = (1,2,1,3,5,6,4)`() {
        val nums = intArrayOf(1, 2, 1, 3, 5, 6, 4)
        val expected1 = 1
        val expected5 = 5
        val actual = findPeakElement(nums)
        assertContains(intArrayOf(expected1, expected5), actual)
    }

    @Test
    fun `should return either 3 for nums = (0, 1, 2, 3, 2, 1, 0)`() {
        val nums = intArrayOf(0, 1, 2, 3, 2, 1, 0)
        val expected = 3
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from 0 10 3 2 1 0`() {
        val nums = intArrayOf(0, 10, 3, 2, 1, 0)
        val expected = 1
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from 0 10 0`() {
        val nums = intArrayOf(0, 10, 0)
        val expected = 1
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 16 from 0 1 2 12 22 32 42 52 62 72 82 92 102 112 122 132 133 132 111 0`() {
        val nums = intArrayOf(0, 1, 2, 12, 22, 32, 42, 52, 62, 72, 82, 92, 102, 112, 122, 132, 133, 132, 111, 0)
        val expected = 16
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from 0, 10, 5, 2`() {
        val nums = intArrayOf(0, 10, 5, 2)
        val expected = 1
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from 0, 2, 1, 0`() {
        val nums = intArrayOf(0, 2, 1, 0)
        val expected = 1
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from 0, 1, 0`() {
        val nums = intArrayOf(0, 1, 0)
        val expected = 1
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }
}
