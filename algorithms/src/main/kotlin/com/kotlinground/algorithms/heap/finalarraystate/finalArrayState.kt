package com.kotlinground.algorithms.heap.finalarraystate

import java.util.*


fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
    if (k == 0 || multiplier == 0) {
        return nums
    }
    val heap = PriorityQueue(Comparator { a: IntArray, b: IntArray ->
        val valueComparison = a[0].compareTo(b[0])
        if (valueComparison == 0) {
            return@Comparator a[1].compareTo(b[1])
        }
        valueComparison
    })

    for ((i, element) in nums.withIndex()) {
        heap.offer(intArrayOf(element, i))
    }

    var operations = k
    while (operations-- > 0) {
        val smallest = heap.poll()
        val index = smallest[1]

        nums[index] *= multiplier
        heap.offer(intArrayOf(nums[index], index))
    }

    return nums
}

fun getFinalStateScan(nums: IntArray, k: Int, multiplier: Int): IntArray {
    if (k == 0 || multiplier == 0) {
        return nums
    }

    val n: Int = nums.size

    for (j in 0..<k) {
        // Find the index of the smallest element in the array
        var minIndex = 0
        for (i in 0..<n) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i
            }
        }

        // Multiply the smallest element by the multiplier
        nums[minIndex] *= multiplier
    }

    return nums
}