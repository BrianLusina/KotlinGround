package com.kotlinground.algorithms.slidingwindow.maxpointsfromcards

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MaxPointsFromCards {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3, 12),
            Arguments.of(intArrayOf(2, 2, 2), 2, 4),
            Arguments.of(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7, 55),
            Arguments.of(intArrayOf(2, 11, 4, 5, 3, 9, 2), 3, 17),
            Arguments.of(intArrayOf(1, 100, 10, 0, 4, 5, 6), 3, 111),
            Arguments.of(intArrayOf(1, 1000, 1), 1, 1),
            Arguments.of(intArrayOf(1, 79, 80, 1, 1, 1, 200, 1), 3, 202),
            Arguments.of(intArrayOf(100, 40, 17, 9, 73, 75), 3, 248),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5, 40),
        )
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `max points from picking k cards from either end`(cards: IntArray, k: Int, expected: Int) {
        val actual = maxPointsFromCards(cards, k)
        assertEquals(expected, actual)
    }
}