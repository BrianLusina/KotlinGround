package com.kotlinground.algorithms.intervals.minintervalsforqueries

import java.util.*


fun minIntervals(intervals: Array<IntArray>, queries: IntArray): IntArray {

    // Sort intervals by their start (left endpoint) so we can sweep them in order
    intervals.sortBy { it[0] }
    val queryLen = queries.size
    val intervalLen = intervals.size

    // Pair each query with its original index, then sort queries by value
    // so we can process queries from smallest to largest
    val qs = Array(queryLen) { IntArray(2) }  // {queryValue, originalIndex}
    for (i in 0..< queryLen) {
        qs[i][0] = queries[i]
        qs[i][1] = i
    }

    qs.sortBy { it[0] }

    // Default answer is -1 for each query (means: no covering interval found)
    val result = IntArray(queryLen) { -1 }

    // Min-heap will store candidate intervals that could cover current query:
    // (interval_size, interval_right_endpoint)
    val heap = PriorityQueue(
        Comparator { a: IntArray, b: IntArray ->
            if (a[0] != b[0]) a[0].compareTo(b[0]) else a[1].compareTo(b[1])
        }
    )

    var i = 0

    // Process queries in increasing order
    for (pair in qs) {
        val query = pair[0]
        val queryIdx = pair[1]

        // Push all intervals that start at or before q into the heap
        // (they are "eligible" to cover q, but might end before q)
        while (i < intervalLen && intervals[i][0] <= query) {
            val intervalStart = intervals[i][0]
            val intervalEnd = intervals[i][1]
            val intervalSize = intervalEnd - intervalStart + 1
            heap.offer(intArrayOf(intervalSize, intervalEnd))
            i++
        }

        // Remove intervals that end before q (they can't cover q anymore)
        while (!heap.isEmpty() && heap.peek()[1] < query) {
            heap.poll()
        }

        // If heap is not empty, top has the smallest size among intervals that cover q
        if (!heap.isEmpty()) {
            result[queryIdx] = heap.peek()[0]
        }
    }

    return result
}
