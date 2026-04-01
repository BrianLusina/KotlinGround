package com.kotlinground.algorithms.stack.arithmetic

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class ArithmeticExpressionTest {

    companion object {
        @JvmStatic
        fun cases() = listOf(
            Arguments.of("", 0),
            Arguments.of("5", 5),
            Arguments.of("(3+5)", 8),
            Arguments.of("9-4)", 5),
            Arguments.of("(7*6)", 42),
            Arguments.of("(8/4)", 2),
            Arguments.of("((3+5)*(2+4))", 48),
            Arguments.of("((2+(3*4))+5)", 19),
        )
    }

    /**
     * Tests for `evaluate` function in `ArithmeticExpressionKt` class.
     * This function evaluates a given arithmetic expression represented as a string and
     * returns its result as a Double. The function assumes that the expression is provided
     * in a format that supports parentheses and valid arithmetic operators (+, -, *, /).
     */

    @ParameterizedTest(name = "{index} => evaluate(\"{0}\") should return {1}")
    @MethodSource("cases")
    fun `evaluate arithmetic expression`(expression: String, expected: Int) {
        val actual = evaluate(expression)
        assertEquals(expected, actual)
    }

    @Test
    fun `evaluate should throw exception for invalid characters`() {
        val expression = "(2+3a)"
        assertFailsWith<NumberFormatException> {
            evaluate(expression)
        }
    }

    @Test
    fun `evaluate should throw exception for missing parentheses`() {
        val expression = "(2+3"
        assertFailsWith<NoSuchElementException> {
            evaluate(expression)
        }
    }

    @Test
    fun `evaluate should handle division by zero correctly`() {
        val expression = "(4/0)"
        assertFailsWith<ArithmeticException> {
            evaluate(expression)
        }
    }
}