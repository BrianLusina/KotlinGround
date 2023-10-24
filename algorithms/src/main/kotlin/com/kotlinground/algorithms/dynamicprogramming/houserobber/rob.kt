package com.kotlinground.algorithms.dynamicprogramming.houserobber

/**
 * Uses a top-down approach using Rolling Window technique where the idea is to only remember what is the maximum
 *     gain at the next three houses from the current position.
 */
fun rob(nums: IntArray): Int {
    var current = 0
    var previous = 0

    for (num in nums) {
        val temp = maxOf(current + num, previous)
        current = previous
        previous = temp
    }
    return previous
}
