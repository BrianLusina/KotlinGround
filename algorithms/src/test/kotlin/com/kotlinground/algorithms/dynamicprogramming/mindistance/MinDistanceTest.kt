package com.kotlinground.algorithms.dynamicprogramming.mindistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinDistanceTest {
    @Test
    fun `should return 0 from a = abcd and b=abcd`() {
        val a = "abcd"
        val b = "abcd"
        val expected = 0
        assertTest(a, b, expected)
    }

    @Test
    fun `should return 4 from a = '' and b=abcd`() {
        val a = ""
        val b = "abcd"
        val expected = 4
        assertTest(a, b, expected)
    }

    @Test
    fun `should return 1 from a = abad and b=abac`() {
        val a = "abad"
        val b = "abac"
        val expected = 1
        assertTest(a, b, expected)
    }

    @Test
    fun `should return 2 from a = Anshuman and b=Antihuman`() {
        val a = "Anshuman"
        val b = "Antihuman"
        val expected = 2
        assertTest(a, b, expected)
    }

    @Test
    fun `should return 3 from a = horse and b=ros`() {
        val a = "horse"
        val b = "ros"
        val expected = 3
        assertTest(a, b, expected)
    }

    @Test
    fun `should return 5 from a = intention and b=execution`() {
        val a = "intention"
        val b = "execution"
        val expected = 5
        assertTest(a, b, expected)
    }

    private fun assertTest(a: String, b: String, expected: Int) {
        val actual = minDistance(a, b)
        assertEquals(expected, actual)
    }
}
