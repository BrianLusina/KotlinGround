package com.kotlinground.algorithms.arrays.nonconstructiblechange

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class NonConstructibleChangeTest {

    @ParameterizedTest
    @MethodSource("cases")
    fun smallestNonConstructibleChange(input: MutableList<Int>, expected: Int) {
        assertEquals(expected, nonConstructibleChange(input))
    }

    companion object {
        @JvmStatic
        fun cases() = listOf(
            Arguments.of(mutableListOf(5, 7, 1, 1, 2, 3, 22), 20),
            Arguments.of(listOf(1,1,1,1,1), 6),
            Arguments.of(listOf(1, 5, 1, 1, 1, 10, 15, 20, 100), 55),
            Arguments.of(listOf(6, 4, 5, 1, 1, 8, 9), 3),
            Arguments.of(listOf<Int>(), 1),
            Arguments.of(listOf(87), 1),
            Arguments.of(listOf(5, 6, 1, 1, 2, 3, 4, 9), 32),
            Arguments.of(listOf(5, 6, 1, 1, 2, 3, 43), 19),
            Arguments.of(listOf(2), 1),
            Arguments.of(listOf(1, 1), 3),
            Arguments.of(listOf(109, 2000, 8765, 19, 18, 17, 16, 8, 1, 1, 2, 4), 87),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7), 29)
        )
    }

    @Test
    fun `should not mutate the input coins list`() {
        val coins = mutableListOf(5, 7, 1, 1, 2, 3, 22)
        val snapshot = coins.toList()
        nonConstructibleChange(coins)
        assertEquals(coins, snapshot)
    }
}
