package com.kotlinground.puzzles.arrays.candy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CandyTest {

    @Test
    fun `should return 5 from ratings=(1,0,2)`() {
        val ratings = intArrayOf(1, 0, 2)
        val expected = 5
        val actual = candy(ratings)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from ratings=(1,2,2)`() {
        val ratings = intArrayOf(1, 2, 2)
        val expected = 4
        val actual = candy(ratings)
        assertEquals(expected, actual)
    }
}
