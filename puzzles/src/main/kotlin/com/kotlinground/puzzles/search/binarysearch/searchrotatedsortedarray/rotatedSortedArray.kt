package com.kotlinground.puzzles.search.binarysearch.searchrotatedsortedarray

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val middle = (left + right) / 2

        if (nums[middle] == target) {
            return middle
        }

        // we search the left sorted portion
        if (nums[left] <= nums[middle]) {
            // if our target is greater than our middle value or less than the left most value, then we need to move our
            // left pointer to the middle plus 1, this means our target is in the right sorted portion
            if (target > nums[middle] || target < nums[left]) {
                left = middle + 1
            } else {
                // if not, we move our right pointer to the middle. Meaning our target is in the left sorted portion
                right = middle - 1
            }
        }
        // right sorted portion
        else {
            // else our target is in the right sorted portion. We check if the target is less than our middle or our
            // target is greater than our right most value. Then we move to the left portion by moving our right pointer
            // to the middle value
            if (target < nums[middle] || target > nums[right]) {
                right = middle - 1
            } else {
                // Move our left to the middle position if our target is greater than middle value or less than right
                // most value
                left = middle + 1

            }
        }
    }
    return -1
}

/**
 * Performs a search of target in the nums list that is already sorted in non-decreasing order(that is increasing)
 * & does not contain distinct values. Nums has been rotated at an unknown pivot index
 * @param nums [IntArray] list of integers sorted in non-decreasing order with non-distinct values rotated at an unknown
 * pivot
 * @param target [Int]: number being sought for in nums.
 * @return [Boolean] True if the target can be found in the nums list, False otherwise
 */
fun searchWithDuplicates(nums: IntArray, target: Int): Boolean {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val middle = (left + right) / 2

        // we have found the target in the middle
        if (nums[middle] == target) {
            return true
        }

        // we search the left sorted portion
        else if (nums[left] < nums[middle]) {
            // if our target is greater than a left value and less than the middle value then we need to move our
            // right pointer to the middle - 1(right before the midpoint) else we move left pointer to the middle plus 1,
            if (nums[left] <= target && target < nums[middle]) {
                // this means our target is in the left sorted portion
                right = middle - 1
            } else {
                // this means our target is in the right sorted portion
                left = middle + 1
            }
        }
        // right sorted portion
        else if (nums[left] > nums[middle]) {
            // if the target greater than the middle value and less than or equal to a right value. Then the left pointer
            // is moved to the middle +1(right after the middle), denoting that the search should be happening on the
            // right. Else we move the right pointer to the left i.e. middle - 1(right before the middle) e
            if (nums[middle] < target && target <= nums[right]) {
                // search the right section
                left = middle + 1
            } else {
                // search the left section
                right = middle - 1
            }
        } else {
            // if neither a left value is greater than the middle value nor less than the middle value, we move the
            // pointer to the right by 1 step.
            left += 1
        }
    }

    return false
}
