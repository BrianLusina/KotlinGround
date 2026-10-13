package com.kotlinground.algorithms.search.binary.search2dmatrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SearchMatrixTest {
    companion object {
        @JvmStatic
        fun search2dMatrixIITestCases() = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(-7, -1, 5, 11),
                    intArrayOf(-6, 0, 6, 14),
                    intArrayOf(-4, 2, 9, 20),
                    ),
                6,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-2, 0, 3),
                    intArrayOf(1, 4, 7),
                    ),
                -5,
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-10, -3),
                    intArrayOf(-4, 2),
                    intArrayOf(0, 5),
                    ),
                9,
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-13),
                    ),
                -13,
                true
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("search2dMatrixIITestCases")
    fun `Search 2D Matrix II`(matrix: Array<IntArray>, target: Int, expected: Boolean) {
        val actual = searchMatrix(matrix, target)
        assertEquals(expected, actual)
    }
}