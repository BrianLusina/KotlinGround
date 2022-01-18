package com.kotlinground.datastructures.arrays.maxprofit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxProfitTest {

    @Test
    fun `Should return 0 for an empty array`() {
        val prices = intArrayOf()
        assertEquals(0, maxProfit(prices))
    }

    @Test
    fun `Should return 0 when prices are the same`() {
        val prices = intArrayOf(1, 1, 1, 1)
        assertEquals(0, maxProfit(prices))
    }

    @Test
    fun `Should return 0 for single element array`() {
        val prices = intArrayOf(1)
        assertEquals(0, maxProfit(prices))
    }

    @Test
    fun `Should return 5 for prices of 7, 1, 5, 3, 6, 4`() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        assertEquals(5, maxProfit(prices))
    }

    @Test
    fun `Should return 0 for prices of 7, 6, 4, 3, 1`() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        assertEquals(0, maxProfit(prices))
    }
}