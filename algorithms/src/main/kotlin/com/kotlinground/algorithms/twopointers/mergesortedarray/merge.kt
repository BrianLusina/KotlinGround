package com.kotlinground.algorithms.twopointers.mergesortedarray

/**
 * Uses a 2 pointer approach to merge to sorted arrays.
 * The first pointer i points to the last element of the subarray of size m in the nums1 array,
 * the second pointer j points to the last element of the nums2 array of size n.
 * The pointer k points to the end of the array nums1 of size m + n.
 *
 * Until the pointer j reaches 0 (that is, until we reach the beginning of the nums2 array), we check the following
 * conditions:
 *
 * - If the pointer i < 0 (i.e. we have reached the beginning of the nums1 array) OR nums1[i] < nums2[j] =>
 *     write nums2[j] to nums1[k] and then decrease the value of j and k by 1
 * - In all other cases, write nums1[i] to nums1[k] and then decrease the value of i and k by 1
 *
 * Complexity
 * Time complexity: O(n+m)
 * Space complexity: O(1)
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1

    while (j >= 0) {
        nums1[k--] = if (i < 0 || nums1[i] < nums2[j]) {
            nums2[j--]
        } else {
            nums1[i--]
        }
    }
}
