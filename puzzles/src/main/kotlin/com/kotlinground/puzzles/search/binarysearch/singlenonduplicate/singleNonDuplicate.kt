package com.kotlinground.puzzles.search.binarysearch.singlenonduplicate

/**
 * Finds the non-duplicate number in the list of numbers where there is at least one non-duplicate. Each other number
 * has a duplicate element. Which is at most 1. Therefore, duplicates come in pairs
 *
 * Observe that the parity (even or odd) of indices ties closely with where the single element is. We know that the
 *  numbers come in pairs before and after the one single element s. For the pairs that are to the left of s: the first
 *  element takes an even index e (as the array is zero indexed) and the second element takes an odd index e+1. Then the
 *  single element s takes only one position (even), so that the pattern on the right of s is reversed. For the pairs
 *   that are to the right of s: the first element takes an odd index o, and the second element takes an even index o+1
 *
 *  Therefore, for an even index e, nums[e]!=nums[e+1] if the s is to the left of o. Similar for an odd index o,
 *  nums[o]!=nums[o-1] means s has already appeared. We must also keep an eye out for out of bounds, that is, to check
 *  whether idx is the last index in nums.
 *
 * Complexity: where n is the number of elements in the list
 * Time Complexity: O(logn), a binary search is performed to find a single non-duplicate element
 * Space Complexity: O(1), no extra space is used, only constant space is used
 *
 * @param nums [IntArray] list of integers.
 * @return [Int] non-duplicate integer
 */
fun singleNonDuplicate(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    var nonDuplicateIndex = -1

    fun toTheLeft(index: Int): Boolean {
        // check for out of bounds
        if (index == nums.size - 1) {
            return true
        }

        return if (index % 2 == 1) {
            // this means that the non-duplicate element has already been seen, therefore, we compare this element at
            // this index with # the element before it
            nums[index] != nums[index - 1]
        } else {
            // the non-duplicate has not yet been seen, we compare the element at this index with the next element
            nums[index] != nums[index + 1]
        }
    }

    // typical binary search to find the non-duplicate element
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (toTheLeft(mid)) {
            nonDuplicateIndex = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return nums[nonDuplicateIndex]
}
