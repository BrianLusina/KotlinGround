package com.kotlinground.algorithms.dynamicprogramming.buyandsell

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxProfitWithFeeTest {
    @Test
    fun `should return 0 for empty array`() {
        val prices = intArrayOf()
        val fee = 0
        val expected = 0
        assert(prices, fee, expected)
    }

    @Test
    fun `should return 0 for same prices`() {
        val prices = intArrayOf(1, 1, 1, 1)
        val fee = 1
        val expected = 0
        assert(prices, fee, expected)
    }

    @Test
    fun `should return 0 for only 1 price`() {
        val prices = intArrayOf(1)
        val fee = 1
        val expected = 0
        assert(prices, fee, expected)
    }

    @Test
    fun `should return 8 for prices=1,3,2,8,4,9 and fee of 2`() {
        val prices = intArrayOf(1, 3, 2, 8, 4, 9)
        val fee = 2
        val expected = 8
        assert(prices, fee, expected)
    }

    @Test
    fun `should return 6 for prices=1,3,7,5,10,3 and fee of 3`() {
        val prices = intArrayOf(1, 3, 7, 5, 10, 3)
        val fee = 3
        val expected = 6
        assert(prices, fee, expected)
    }

    @Test
    fun `should return 13 for prices=1,4,6,2,8,3,10,14 and fee of 3`() {
        val prices = intArrayOf(1, 4, 6, 2, 8, 3, 10, 14)
        val fee = 3
        val expected = 13
        assert(prices, fee, expected)
    }

    private fun assert(prices: IntArray, fee: Int, expected: Int) {
        val actual = maxProfitWithFee(prices, fee)
        assertEquals(expected, actual)
    }
}
