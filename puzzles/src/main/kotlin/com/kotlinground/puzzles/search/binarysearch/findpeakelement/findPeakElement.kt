package com.kotlinground.puzzles.search.binarysearch.findpeakelement

/**
 * Finds a peak element's index in the provided list of integers
 *
 * Algorithm:
 * - Initializes left as the start index of the list and right as the end index of the list (len(nums)- 1).
 * - Perform binary search until left becomes equal to right.
 * - Calculate the middle index mid using the formula mid = left + (right - left) // 2. or mid = (left + right) >> 1
 * - Compare nums[mid] with nums[mid + 1] to determine if the peak is on the left side or the right side of mid.
 *     - If nums[mid] is greater than nums[mid + 1], move the right index to mid, indicating that the peak is on the
 *     left side.
 *     - Otherwise, move the left index to mid + 1, indicating that the peak is on the right side.
 * - Repeat steps 3-4 until left becomes equal to right.
 * - Return the value of peak_index, which represents the index of the peak element.
 *
 * Complexity:
 *
 * - Time complexity O(log n): Where n is the number of elements in the nums vector.
 * - Space Complexity O(1): Since it uses a constant amount of extra space.
 *
 * @param nums [IntArray] list of integers with duplicate peaks
 * @return [Int] index of a peak element(i.e. element that is greater than its adjacent neighbours)
 */
fun findPeakElement(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    var peakIndex = -1

    while (left <= right) {
        val mid = (left + right).shr(1)

        val potentialPeak = nums[mid]

        if (mid == nums.size - 1 || potentialPeak > nums[mid + 1]) {
            peakIndex = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return peakIndex
}
