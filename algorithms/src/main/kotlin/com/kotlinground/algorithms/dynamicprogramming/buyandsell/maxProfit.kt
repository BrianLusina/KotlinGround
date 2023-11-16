package com.kotlinground.algorithms.dynamicprogramming.buyandsell

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE
    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        }
        if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice
        }
    }
    return maxProfit
}
