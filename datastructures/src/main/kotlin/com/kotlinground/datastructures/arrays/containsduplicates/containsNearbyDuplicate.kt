package com.kotlinground.datastructures.arrays.containsduplicates

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val num = nums[i]
        if (map.containsKey(num)) {
            if (i - map[num]!! <= k) {
                return true
            }
        }
        map[num] = i
    }

    return false
}
