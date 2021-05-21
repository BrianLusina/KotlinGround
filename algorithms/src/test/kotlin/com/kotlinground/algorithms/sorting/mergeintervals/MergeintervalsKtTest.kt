package com.kotlinground.algorithms.sorting.mergeintervals

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MergeintervalsKtTest {

    @Test
    fun `Test for intervals 1,3, 2,6, 8,10, 15,18`() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        val actual = mergeintervals(intervals)
        val expected = arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        Assertions.assertEquals(expected, actual)
    }
}
