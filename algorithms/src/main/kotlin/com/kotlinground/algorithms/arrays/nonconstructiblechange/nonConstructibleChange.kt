package com.kotlinground.algorithms.arrays.nonconstructiblechange

/**
 * Calculates the minimum amount of change that cannot be created with a given list of coin denominations.
 *
 * The function takes an unsorted list of coin denominations, sorts it, and iteratively calculates the cumulative
 * change that can be created. It determines the smallest amount of money that cannot be formed with the given coins.
 *
 * @param coins A list of positive integers representing the denominations of coins available.
 * @return The minimum amount of change that cannot be created using the given coins.
 */
fun nonConstructibleChange(coins: MutableList<Int>): Int {
    // Sort a copy to avoid mutating the input list
    val sortedCoins = coins.sorted()
    var currentChange = 0
    for (coin in sortedCoins) {
        if (coin > currentChange + 1) {
            return currentChange + 1
        }
        currentChange += coin
    }
    return currentChange + 1
}
