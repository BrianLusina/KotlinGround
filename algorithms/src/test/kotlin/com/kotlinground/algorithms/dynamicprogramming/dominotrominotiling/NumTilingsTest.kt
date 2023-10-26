package com.kotlinground.algorithms.dynamicprogramming.dominotrominotiling

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumTilingsTest {
    @Test
    fun `should return 5 for n = 3`() {
        val n = 3
        val expected = 5
        val actual = numTilings(n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 for n = 1`() {
        val n = 1
        val expected = 1
        val actual = numTilings(n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 312342182 for n = 30`() {
        val n = 30
        val expected = 312342182
        val actual = numTilings(n)
        assertEquals(expected, actual)
    }
}
