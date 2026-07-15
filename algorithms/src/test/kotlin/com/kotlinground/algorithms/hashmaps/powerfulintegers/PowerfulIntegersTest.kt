package com.kotlinground.algorithms.hashmaps.powerfulintegers

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

class PowerfulIntegersTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(2, 2, 20, listOf(2, 3, 4, 5, 6, 8, 9, 10, 12, 16, 17, 18, 20)),
            Arguments.of(1, 1, 5, listOf(2)),
            Arguments.of(5, 3, 50, listOf(2, 4, 6, 8, 10, 14, 26, 28, 32, 34)),
            Arguments.of(100, 100, 1000000, listOf(2, 101, 200, 10001, 10100, 20000)),
            Arguments.of(2, 5, 0, emptyList<Int>()),
            Arguments.of(2, 3, 10, listOf(2, 3, 4, 5, 7, 9, 10)),
            Arguments.of(3, 5, 15, listOf(2, 4, 6, 8, 10, 14)),
        )
    }

    @ParameterizedTest(name = "{index} => powerfulIntegers({0}, {1}, {2}) should return {3}")
    @MethodSource("testCases")
    fun `powerful integers`(x: Int, y: Int, bound: Int, expected: List<Int>) {
        val actual = powerfulIntegers(x, y, bound)
        actual.sort()
        assertContentEquals(expected, actual)
    }

    @ParameterizedTest(name = "{index} => powerfulIntegersLogarithmicBounds({0}, {1}, {2}) should return {3}")
    @MethodSource("testCases")
    fun `powerful integers logarithmic bounds`(x: Int, y: Int, bound: Int, expected: List<Int>) {
        val actual = powerfulIntegersLogarithmicBounds(x, y, bound)
        actual.sort()
        assertContentEquals(expected, actual)
    }
}
