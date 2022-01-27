package com.kotlinground.datastructures.arrays.containsduplicates

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ContainsNearbyDuplicateTest {

    @Test
    fun `Should return true for nums = (1, 2, 3, 1) and k = 3`() {
        val input = intArrayOf(1, 2, 3, 1)
        val result = containsNearbyDuplicate(input, 3)
        assertTrue(result)
    }

    @Test
    fun `Should return true for nums = (1, 0, 1, 1) and k = 1`() {
        val input = intArrayOf(1, 0, 1, 1)
        val result = containsNearbyDuplicate(input, 1)
        assertTrue(result)
    }

    @Test
    fun `Should return false for nums = (1, 2, 3, 1, 2, 3) and k = 2`() {
        val input = intArrayOf(1, 2, 3, 1, 2, 3)
        val result = containsNearbyDuplicate(input, 2)
        assertFalse(result)
    }
}