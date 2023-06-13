package com.kotlinground.puzzles.arrays.productofarrayexceptself

fun productExceptSelf(nums: IntArray): IntArray {
    if (nums.size <= 1) {
        return nums
    }

    val result = IntArray(nums.size) { 1 }
    var prefix = 1

    for (i in nums.indices) {
        result[i] *= prefix
        prefix *= nums[i]
    }

    var postfix = 1

    for (i in nums.size - 1 downTo 0) {
        result[i] *= postfix
        postfix *= nums[i]
    }

    return result
}
