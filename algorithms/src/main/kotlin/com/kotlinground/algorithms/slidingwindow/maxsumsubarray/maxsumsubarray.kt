package com.kotlinground.algorithms.slidingwindow.maxsumsubarray

fun maxSumSubArray(nums: IntArray, k: Int): Int {
    val size = nums.size
    if (nums.isEmpty() || size < k) return 0

    var start = 0
    var state = 0
    var maxSum = 0

    for (end in 0 until size) {
        state += nums[end]
        if (end - start + 1 == k) {
            maxSum = maxOf(maxSum, state)
            state -= nums[start]
            start += 1
        }
    }

    return maxSum
}
