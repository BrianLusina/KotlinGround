package com.kotlinground.puzzles.search.binarysearch.searchrotatedsortedarray

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RotatedSortedArray2Test {
    @Test
    fun `Should return true for nums 2, 5, 6, 0, 0, 1, 2 and target = 0`() {
        val nums = intArrayOf(2, 5, 6, 0, 0, 1, 2)
        val target = 0
        val actual = searchWithDuplicates(nums, target)
        assertTrue(actual)
    }

    @Test
    fun `Should return false for nums = 2, 5, 6, 0, 0, 1, 2 and target = 3`() {
        val nums = intArrayOf(2, 5, 6, 0, 0, 1, 2)
        val target = 3
        val actual = searchWithDuplicates(nums, target)
        assertFalse(actual)
    }

    @Test
    fun `Should return true for nums = 1, 0, 1, 1, 1 and target = 0`() {
        val nums = intArrayOf(1, 0, 1, 1, 1)
        val target = 0
        val actual = searchWithDuplicates(nums, target)
        assertTrue(actual)
    }

    @Test
    fun `Should return true for nums = 1, 3, 5 and target = 0`() {
        val nums = intArrayOf(1, 3, 5)
        val target = 0
        val actual = searchWithDuplicates(nums, target)
        assertTrue(actual)
    }

    @Test
    fun `Should return true for nums = 5, 1, 3 and target = 3`() {
        val nums = intArrayOf(5, 1, 3)
        val target = 3
        val actual = searchWithDuplicates(nums, target)
        assertTrue(actual)
    }
}
