package com.kotlinground.algorithms.heap.finalarraystate

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

class GetFinalStateTest {
    companion object {
        @JvmStatic
        fun finalArrayStateAfterKMultiplicationOpsTestCases() = listOf(
            Arguments.of(intArrayOf(2,1,3,5,6), 5, 2, intArrayOf(8,4,6,5,6)),
            Arguments.of(intArrayOf(1, 2), 3, 4,intArrayOf(16,8)),
        )
    }

    @ParameterizedTest
    @MethodSource("finalArrayStateAfterKMultiplicationOpsTestCases")
    fun `Final Array State After K Multiplication Operations I with priority queue`(nums: IntArray, k: Int, multiplier: Int, expected: IntArray) {
        val actual = getFinalState(nums, k, multiplier)
        assertContentEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("finalArrayStateAfterKMultiplicationOpsTestCases")
    fun `Final Array State After K Multiplication Operations I with full scan`(nums: IntArray, k: Int, multiplier: Int, expected: IntArray) {
        val actual = getFinalStateScan(nums, k, multiplier)
        assertContentEquals(expected, actual)
    }
}
