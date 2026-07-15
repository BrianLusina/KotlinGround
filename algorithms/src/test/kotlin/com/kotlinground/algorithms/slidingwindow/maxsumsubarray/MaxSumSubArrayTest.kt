package com.kotlinground.algorithms.slidingwindow.maxsumsubarray

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MaxSumSubArrayTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(intArrayOf(), 3, 0),
            Arguments.of(intArrayOf(2, 1, 5, 1, 3, 2), 3, 9),
            Arguments.of(intArrayOf(4, 2, -1, 9, 7, -3, 5), 4, 18),
        )
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `max sum sub array of size k`(nums: IntArray, k: Int, expected: Int) {
        val actual = maxSumSubArray(nums, k)
        assertEquals(expected, actual)
    }
}
