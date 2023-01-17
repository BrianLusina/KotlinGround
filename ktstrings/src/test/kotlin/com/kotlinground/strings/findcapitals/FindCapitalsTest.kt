package com.kotlinground.strings.findcapitals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindCapitalsTest {
    @Test
    fun `Should return (0,3,4,6) for word CodEWaRs`() {
        val word = "CodEWaRs"
        val expected = intArrayOf(0, 3, 4, 6)
        val actual = findCapitals(word)
        assertEquals(expected, actual)
    }
}
