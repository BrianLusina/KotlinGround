package com.kotlinground.puzzles.arrays.maxconsecutiveones

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class MaxConsecutiveZeroesTest {
    companion object {
        @JvmStatic
        fun longestOnesTestCases() = listOf(
            Arguments.of(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2, 6),
            Arguments.of(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3, 10),
        )

        @JvmStatic
        fun maxOnesTestCases() = listOf(
            Arguments.of(intArrayOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1), 4),
            Arguments.of(intArrayOf(1, 0, 1, 1, 0, 1), 2),
            Arguments.of(intArrayOf(1, 0, 1, 1, 0, 1), 2),
            Arguments.of(intArrayOf(0, 0, 0), 0),
            Arguments.of(intArrayOf(1, 1, 1), 3),
        )
    }

    @ParameterizedTest
    @MethodSource("longestOnesTestCases")
    fun `longest ones test`(nums: IntArray, k: Int, expected: Int) {
        val actual = longestOnes(nums, k)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("maxOnesTestCases")
    fun `max ones test cases`(nums: IntArray, expected: Int) {
        val actual = findMaxConsecutiveOnes(nums)
        assertEquals(expected, actual)
    }
}
