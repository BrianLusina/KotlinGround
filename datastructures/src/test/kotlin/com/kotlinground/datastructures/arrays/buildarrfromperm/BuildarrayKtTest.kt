package com.kotlinground.datastructures.arrays.buildarrfromperm

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BuildArrayTest {

    @Test
    fun `Test one with 0, 2, 1, 5, 3, 4`() {
        val nums = intArrayOf(0, 2, 1, 5, 3, 4)
        val expected = intArrayOf(0, 1, 2, 4, 5, 3)
        val actual = buildArray(nums)

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `Test one with 5, 0, 1, 2, 3, 4`() {
        val nums = intArrayOf(5, 0, 1, 2, 3, 4)
        val expected = intArrayOf(4, 5, 0, 1, 2, 3)
        val actual = buildArray(nums)

        Assertions.assertEquals(expected, actual)
    }
}
