package com.kotlinground.algorithms.dynamicprogramming.uniquepaths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathsMathTest {
    @Test
    fun `should return 28 for m=3 and n=7`() {
        val m = 3
        val n = 7
        val expected = 28
        val actual = uniquePathsMath(m, n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 for m=3 and n=2`() {
        val m = 3
        val n = 2
        val expected = 3
        val actual = uniquePathsMath(m, n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1916797311 for m=51 and n=9`() {
        val m = 51
        val n = 9
        val expected = 1916797311
        val actual = uniquePathsMath(m, n)
        assertEquals(expected, actual)
    }
}

class UniquePathsTopDownTest {
    @Test
    fun `should return 28 for m=3 and n=7`() {
        val m = 3
        val n = 7
        val expected = 28
        val actual = uniquePathsTopDown(m, n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 for m=3 and n=2`() {
        val m = 3
        val n = 2
        val expected = 3
        val actual = uniquePathsTopDown(m, n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1916797311 for m=51 and n=9`() {
        val m = 51
        val n = 9
        val expected = 1916797311
        val actual = uniquePathsTopDown(m, n)
        assertEquals(expected, actual)
    }
}

class UniquePathsBottomUpTest {
    @Test
    fun `should return 28 for m=3 and n=7`() {
        val m = 3
        val n = 7
        val expected = 28
        val actual = uniquePathsBottomUp(m, n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 for m=3 and n=2`() {
        val m = 3
        val n = 2
        val expected = 3
        val actual = uniquePathsBottomUp(m, n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1916797311 for m=51 and n=9`() {
        val m = 51
        val n = 9
        val expected = 1916797311
        val actual = uniquePathsBottomUp(m, n)
        assertEquals(expected, actual)
    }
}
