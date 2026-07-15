package com.kotlinground.puzzles.arrays.hindex

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class HIndexTest {
    @Test
    fun `citations = (3,0,6,1,5) should return 3`() {
        val citations = intArrayOf(3, 0, 6, 1, 5)
        val expected = 3
        val actual = hIndex(citations)
        assertEquals(expected, actual)
    }

    @Test
    fun `citations = (1,3,1) should return 1`() {
        val citations = intArrayOf(1, 3, 1)
        val expected = 1
        val actual = hIndex(citations)
        assertEquals(expected, actual)
    }

    @Test
    fun `citations = (9, 7, 6, 2, 1) should return 3`() {
        val citations = intArrayOf(9, 7, 6, 2, 1)
        val expected = 3
        val actual = hIndex(citations)
        assertEquals(expected, actual)
    }
}
