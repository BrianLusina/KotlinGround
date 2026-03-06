package com.kotlinground.ktmath.poweroftwo

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class IsPowerOfTwoTests {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(1, true),
            Arguments.of(16, true),
            Arguments.of(4, true),
            Arguments.of(3, false),
            Arguments.of(-512, false),
            Arguments.of(123456, false),
        )
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `is power of two`(n: Int, expected: Boolean) {
        assertEquals(expected, isPowerOfTwo(n))
    }
}