package com.kotlinground.puzzles.arrays.longestsubarrayofones

fun longestSubArray(nums: IntArray): Int {
    var longestWindow = 0
    var left = 0
    var lastZero = -1

    for ((right, num) in nums.withIndex()) {
        if (num == 0) {
            left = lastZero + 1
            lastZero = right
        }
        longestWindow = maxOf(longestWindow, right - left)
    }

    return longestWindow
}
