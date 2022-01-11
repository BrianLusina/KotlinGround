package com.kotlinground.datastructures.arrays.containsduplicates

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class ContainsDuplicateTest {

    @Test
    fun `Should return true for nums 1,2,3,1`() {
        val nums = intArrayOf(1, 2, 3, 1)

        val actual = containsDuplicate(nums)
        assertTrue(actual)
    }

    @Test
    fun `Should return false for nums 1,2,3,4`() {
        val nums = intArrayOf(1, 2, 3, 4)

        val actual = containsDuplicate(nums)
        assertFalse(actual)
    }

    @Test
    fun `Should return true for nums 1,1,1,3,3,4,3,2,4,2`() {
        val nums = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)

        val actual = containsDuplicate(nums)
        assertTrue(actual)
    }
}