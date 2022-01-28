package com.kotlinground.datastructures.arrays.containsduplicates

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ContainsNearbyAlmostDuplicateTest {

    @Test
    fun `Should return true for nums = (1, 2, 3, 1) and k = 3 and t = 0`() {
        val input = intArrayOf(1, 2, 3, 1)
        val k = 3
        val t = 0
        val actual = containsNearbyAlmostDuplicate(input, k, t)
        assertTrue(actual)
    }

    @Test
    fun `Should return true for nums = (1, 0, 1, 1) and k = 1 and t = 2`() {
        val input = intArrayOf(1, 0, 1, 1)
        val k = 1
        val t = 2
        val actual = containsNearbyAlmostDuplicate(input, k, t)
        assertTrue(actual)
    }

    @Test
    fun `Should return false for nums = (1, 5, 9, 1, 5, 9) and k = 2 and t = 3`() {
        val input = intArrayOf(1, 5, 9, 1, 5, 9)
        val k = 2
        val t = 3
        val actual = containsNearbyAlmostDuplicate(input, k, t)
        assertFalse(actual)
    }
}