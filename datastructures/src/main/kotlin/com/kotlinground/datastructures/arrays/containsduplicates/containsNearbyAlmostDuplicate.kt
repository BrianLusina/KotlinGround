package com.kotlinground.datastructures.arrays.containsduplicates

fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    if (k < 1 || t < 0) {
        return false
    }
    val map = HashMap<Long, Long>()

    for (i in nums.indices) {
        val num = nums[i].toLong()
        val remappedNum = num - Int.MIN_VALUE
        // why t+1 ? because, if t not plus 1, when t == 0, num divide by 0 will cause crash.
        val bucket = remappedNum / (t.toLong() + 1)
        // means the key in the map duplicated, it means the must be exist two numbers that the different value between them are less than t
        if (map.containsKey(bucket)
            // if the two different numbers are located in two adjacent bucket, the value still might be less than t
            || map.containsKey(bucket - 1) && remappedNum - map[bucket - 1]!! <= t
            || map.containsKey(bucket + 1) && map[bucket + 1]!! - remappedNum <= t
        ) {
            // the same reason for -1
            return true
        }
        if (map.entries.size >= k) {
            val lastBucket = (nums[i - k].toLong() - Int.MIN_VALUE) / (t.toLong() + 1)
            map.remove(lastBucket)
        }
        // replace the duplicated key
        map[bucket] = remappedNum
    }

    return false
}
