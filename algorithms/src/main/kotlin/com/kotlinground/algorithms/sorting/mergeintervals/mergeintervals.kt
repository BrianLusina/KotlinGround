package com.kotlinground.algorithms.sorting.mergeintervals

import kotlin.math.max

fun mergeintervals(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    val merged = arrayListOf<IntArray>()

    for (interval in intervals) {
        if (merged.size == 0 || merged.last()[1] < interval[0]) {
            merged.add(interval)
        } else {
            merged.last()[1] = max(merged.last()[1], interval[1])
        }
    }

    return merged.toTypedArray()
}
