package com.kotlinground.algorithms.dynamicprogramming.buyandsell

import kotlin.math.max

fun maxProfitWithFee(prices: IntArray, fee: Int): Int {
    if (prices.isEmpty()) {
        return 0
    }
    var cashWithShares = -prices[0]
    var cashWithoutShares = 0

    for (i in 1 until prices.size) {
        cashWithShares = max(cashWithShares, cashWithoutShares - prices[i])
        cashWithoutShares = maxOf(cashWithoutShares, cashWithShares + prices[i] - fee)
    }

    return cashWithoutShares
}
