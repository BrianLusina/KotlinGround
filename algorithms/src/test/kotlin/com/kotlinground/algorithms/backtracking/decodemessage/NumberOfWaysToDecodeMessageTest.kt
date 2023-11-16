package com.kotlinground.algorithms.backtracking.decodemessage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToDecodeMessageTest {
    @Test
    fun `should return 2 for input of 12`() {
        val digits = "12"
        val expected = 2
        assert(digits, expected)
    }

    @Test
    fun `should return 3 for input of 123`() {
        val digits = "123"
        val expected = 3
        assert(digits, expected)
    }

    @Test
    fun `should return 8 for input of 11223`() {
        val digits = "11223"
        val expected = 8
        assert(digits, expected)
    }

    @Test
    fun `should return 2 for input of 313`() {
        val digits = "313"
        val expected = 2
        assert(digits, expected)
    }

    @Test
    fun `should return 0 for input of 02`() {
        val digits = "02"
        val expected = 0
        assert(digits, expected)
    }

    private fun assert(digits: String, expected: Int) {
        val actual = numberOfWaysToDecodeMessage(digits)
        assertEquals(expected, actual)
    }
}
