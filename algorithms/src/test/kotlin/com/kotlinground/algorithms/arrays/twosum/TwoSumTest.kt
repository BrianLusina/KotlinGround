package com.kotlinground.algorithms.arrays.twosum

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TwoSumTest {

    @Test
    fun `numbers = (2,7,11,15), target = 9`() {
        val numbers = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(1, 2)
        val actual = twoSum(numbers, target)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `numbers = (2,3,4), target = 6`() {
        val numbers = intArrayOf(2,3,4)
        val target = 6
        val expected = intArrayOf(1, 3)
        val actual = twoSum(numbers, target)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `numbers = (-1,0), target = -1`() {
        val numbers = intArrayOf(-1, 0)
        val target = -1
        val expected = intArrayOf(1, 2)
        val actual = twoSum(numbers, target)
        assertContentEquals(expected, actual)
    }
}
