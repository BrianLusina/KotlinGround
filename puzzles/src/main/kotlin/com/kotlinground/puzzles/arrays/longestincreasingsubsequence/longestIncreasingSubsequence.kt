package com.kotlinground.puzzles.arrays.longestincreasingsubsequence

import kotlin.math.max

fun longestIncreasingSubsequence(nums: IntArray): Int {
    val dp = IntArray(nums.size) { 1 }
    var res = 1
    for (i in 1 until nums.size) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = max(dp[j] + 1, dp[i])
            }
        }
        res = max(res, dp[i])
    }
    return res
}
