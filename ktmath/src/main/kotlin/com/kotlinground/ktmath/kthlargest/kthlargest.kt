package com.kotlinground.ktmath.kthlargest

import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sortDescending()
    return nums[k - 1]
}

fun findKthLargestWithPq(nums: IntArray, k: Int): Int {
    val heap = PriorityQueue<Int>()
    nums.forEach {
        heap.offer(it)
        if (heap.size > k)
            heap.poll()
    }
    return heap.poll()
}
