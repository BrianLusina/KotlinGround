package com.kotlinground.datastructures.arrays.maxsumsubarray

/**
 * Finds the contiguous sub array within an array (containing at least one number) which has the largest sum.
 * @param nums [IntArray] array of integers
 * @return [Int] sum of contiguous sub array
 */
fun maxSubArray(nums: IntArray): Int {
    var max = nums[0]
    var sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        if (sum > max) {
            max = sum
        }
        if (sum < 0) {
            sum = 0
        }
    }
    return max
}