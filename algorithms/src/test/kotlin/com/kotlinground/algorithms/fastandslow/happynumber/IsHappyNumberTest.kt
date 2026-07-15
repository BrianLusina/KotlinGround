package com.kotlinground.algorithms.fastandslow.happynumber

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class IsHappyNumberTest {

    companion object {
        @JvmStatic
        fun cases() = listOf(
            Arguments.of(23, true),
            Arguments.of(2, false),
            Arguments.of(19, true),
            Arguments.of(1, true),
            Arguments.of(8, false),
            Arguments.of(7, true),
            Arguments.of(5, false),
            Arguments.of(25, false),
            Arguments.of(2147483646, false),
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Is Happy Number using Fast and Slow Pointers`(input: Int, expected: Boolean) {
        assertEquals(expected, isHappyNumber(input))
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Is Happy Number using a set`(input: Int, expected: Boolean) {
        assertEquals(expected, isHappyNumber2(input))
    }
}