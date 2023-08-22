package com.kotlinground.puzzles.arrays.minimizeabsdiff

import java.util.Collections.max
import java.util.Collections.min
import kotlin.math.abs


fun minimizeAbsoluteDifference(a: IntArray, b: IntArray, c: IntArray): Int {
    var i = a.size - 1
    var j = b.size - 1
    var k = c.size - 1

    var minDiff = abs(max(arrayListOf(a[i], b[j], c[k])) - min(arrayListOf(a[i], b[j], c[k])))

    while (i != -1 && j != -1 && k != -1) {
        val currentDiff = abs(max(arrayListOf(a[i], b[j], c[k])) - min(arrayListOf(a[i], b[j], c[k])))

        if (currentDiff < minDiff) {
            minDiff = currentDiff
        }

        val maxTerm = max(arrayListOf(a[i], b[j], c[k]))

        if (a[i] == maxTerm) {
            i -= 1
        } else if (b[j] == maxTerm) {
            j -= 1
        } else {
            k -= 1
        }
    }
    return minDiff
}
