package com.kotlinground.puzzles.search.binarysearch.platesbetweencandles

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlatesBetweenCandlesTest {
    @Test
    fun `should return (2,3) from s = "**|**|***|", queries = ((2,5),(5,9))`() {
        val s = "**|**|***|"
        val queries = arrayOf(intArrayOf(2, 5), intArrayOf(5, 9))
        val expected = intArrayOf(2, 3)
        val actual = platesBetweenCandles(s, queries)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return (9, 0, 0, 0, 0) from s = "***|**|*****|**||**|*", queries = ((1,17),(4,5),(14,17),(5,11),(15,16))`() {
        val s = "***|**|*****|**||**|*"
        val queries =
            arrayOf(intArrayOf(1, 17), intArrayOf(4, 5), intArrayOf(14, 17), intArrayOf(5, 11), intArrayOf(15, 16))
        val expected = intArrayOf(9, 0, 0, 0, 0)
        val actual = platesBetweenCandles(s, queries)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return (2) from s = "||**||**|*", queries = ((3,8))`() {
        val s = "||**||**|*"
        val queries = arrayOf(intArrayOf(3, 8))
        val expected = intArrayOf(2)
        val actual = platesBetweenCandles(s, queries)

        assertEquals(expected, actual)
    }
}
