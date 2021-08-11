package com.kotlinground.datastructures.arrays.maxlencontiguoussubarray

import kotlin.math.max

/**
 * Finds the maximum length of a contiguous sub array in a binary array. Makes use of a hashmap to store the entries in
 * the form of (count, index). We make an entry for a count in the map whenever the count is encountered first and
 * later on use the corresponding index to find the length of the largest sub array with equal number of zeros and ones
 * when the same count is encountered again.
 * Complexity Analysis:
 * Time complexity : O(n). The entire array is traversed only once.
 * Space complexity : O(n). Maximum size of the HashMap mapmap will be n, if all the elements are either 1 or 0.
 * @param nums: Binary Array
 * @return: Maximum length of contiguous sub array
 */
fun findMaxLength(nums: IntArray): Int {
    // initializing map to (0, -1) is to avoid the edge cases like [0, 1] when you only have one zero and one.
    val hashmap = HashMap<Int, Int>()
    hashmap[0] = -1
    var maxLen = 0
    var count = 0

    for (idx in nums.indices) {
        count += if (nums[idx] == 1) {
            1
        } else {
            -1
        }

        if (hashmap.containsKey(count)) {
            // if the count is already present in the map, then we update the maxLen with the length of the sub array
            maxLen = max(maxLen, idx - hashmap[count]!!)
        } else {
            hashmap[count] = idx
        }
    }

    return maxLen
}
