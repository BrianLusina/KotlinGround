package com.kotlinground.puzzles.arrays.findpivotindex

fun pivotIndex(nums: IntArray): Int {
    val totalSum = nums.sum()
    var leftSum = 0

    for ((index, num) in nums.withIndex()) {
        if (leftSum == (totalSum - leftSum - num)) {
            return index
        }
        leftSum += num
    }
    return -1
}
