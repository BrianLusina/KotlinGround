package com.kotlinground.puzzles.search.binarysearch.searchrange

/**
 * Searches for the left and right positions of a target in nums
 *
 * For the first_pos, we want to find the leftmost target. So we will do binary search on nums, and whenever we find
 * a target, we search for its left side to see whether there is another target on the left while keeping track of the
 * leftmost seen first_pos.
 *
 * Similarly, we want to find the rightmost target in nums to be last_pos. So when we see a target, we search for its
 * right side and record the last_pos = current index. If the current element is not target, then ordinary binary
 * search will lead us to the correct searching side.
 *
 * @param nums [IntArray]  numbers to search
 * @param target [Int] target number
 * @return [IntArray] array of length 2 with 1st index as the left position and last index as the right position
 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    var left = 0
    var right = nums.size - 1
    var firstPos = -1
    var lastPos = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            firstPos = mid
            right = mid - 1
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    left = 0
    right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            lastPos = mid
            left = mid + 1
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return intArrayOf(firstPos, lastPos)
}
