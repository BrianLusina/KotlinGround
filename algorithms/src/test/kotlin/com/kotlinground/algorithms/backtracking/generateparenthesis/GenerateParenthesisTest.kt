package com.kotlinground.algorithms.backtracking.generateparenthesis

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class GenerateParenthesisTest {

    @Test
    fun `should return () for n = 1`() {
        val n = 1
        val expected = listOf("()")
        val actual = generateParenthesis(n)
        assertEquals(expected, actual)
    }
}
