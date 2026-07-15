package com.kotlinground.algorithms.stack.longestvalidparentheses

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class LongestValidParenthesesTest {
    companion object {
        @JvmStatic
        fun cases() = listOf(
            Arguments.of("(()", 2),
            Arguments.of(")()())", 4),
            Arguments.of("", 0),
            Arguments.of("())()", 2),
            Arguments.of("(())", 4),
            Arguments.of(")(", 0),
            Arguments.of("(", 0),
            Arguments.of("()", 2),
            Arguments.of("))(((", 0),
            Arguments.of("(()())", 6),
            Arguments.of(")()((()))((((", 8),
            Arguments.of("()(()))", 6),
            Arguments.of("(()))())(", 4),
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Longest valid parentheses using a stack`(input: String, expected: Int) {
        val actual = longestValidParentheses(input)
        assertEquals(expected, actual)
    }
}
