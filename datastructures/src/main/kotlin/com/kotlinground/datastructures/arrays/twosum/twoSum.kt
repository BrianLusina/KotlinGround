package com.kotlinground.datastructures.arrays.twosum

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (index in nums.indices) {
        val complement = target - nums[index]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, index)
        }
        map[nums[index]] = index
    }
    return intArrayOf()
}
