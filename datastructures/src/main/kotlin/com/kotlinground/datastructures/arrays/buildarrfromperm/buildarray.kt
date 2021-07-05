package com.kotlinground.datastructures.arrays.buildarrfromperm

fun buildArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)

    nums.forEachIndexed { idx: Int, _: Int ->
     ans[idx] = nums[nums[idx]]
    }

    return ans
}
