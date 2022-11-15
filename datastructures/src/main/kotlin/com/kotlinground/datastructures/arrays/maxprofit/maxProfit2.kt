package com.kotlinground.datastructures.arrays.maxprofit

fun maxProfit2(prices: IntArray): Int {
    if (prices.isEmpty() || prices.size < 2) {
        return 0
    }
    var totalProfit = 0
    var left = 0
    var right = 1

    while (right < prices.size) {
        val previousPrice = prices[left]
        val nextPrice = prices[right]
        if (previousPrice < nextPrice) {
            val profit = nextPrice - previousPrice
            totalProfit += profit
        }
        left++
        right++
    }

    return totalProfit
}
