package com.kotlinground.datastructures.arrays.arbitraryprecisionincrement

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ArbitraryPrecisionIncrementTest {
    @Test
    fun `should return (1,5,0) from (1,4,9)`() {
        val a = arrayListOf(1, 4, 9)
        val expected = intArrayOf(1, 5, 0)
        val actual = arbitraryPrecisionIncrement(a)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return (1,0, 0, 0) from (9,9,9)`() {
        val a = arrayListOf(9, 9, 9)
        val expected = intArrayOf(1, 0, 0, 0)
        val actual = arbitraryPrecisionIncrement(a)
        assertContentEquals(expected, actual)
    }
}
