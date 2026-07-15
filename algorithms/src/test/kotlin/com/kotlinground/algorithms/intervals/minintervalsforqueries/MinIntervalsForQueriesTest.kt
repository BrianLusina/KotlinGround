package com.kotlinground.algorithms.intervals.minintervalsforqueries

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MinIntervalsForQueriesTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 4),
                    intArrayOf(3, 6),
                    intArrayOf(4, 4)
                ),
                intArrayOf(2, 3, 4, 5),
                intArrayOf(3, 3, 1, 4)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(2, 5),
                    intArrayOf(1, 8),
                    intArrayOf(20, 25)
                ),
                intArrayOf(2, 19, 5, 22),
                intArrayOf(2, -1, 4, 6)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(9,9)
                ),
                intArrayOf(1, 2, 4, 9, 10, 7),
                intArrayOf(3, 3, 5, 1, 3, -1)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(4, 4),
                    intArrayOf(2, 5),
                    intArrayOf(1, 7),
                    intArrayOf(6, 8)
                ),
                intArrayOf(4, 5, 6, 1, 8, 9),
                intArrayOf(1, 4, 3, 7, 3, -1)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(10, 20),
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 9),
                    intArrayOf(2, 12)
                ),
                intArrayOf(2, 4, 6, 10, 12, 21),
                intArrayOf(2, 3, 4, 11, 11, -1)
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `min intervals to include each query`(intervals: Array<IntArray>, queries: IntArray, expected: IntArray) {
        val actual = minIntervals(intervals, queries)
        assertContentEquals(expected, actual)
    }
}
