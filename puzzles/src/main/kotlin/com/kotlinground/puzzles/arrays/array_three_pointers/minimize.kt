package com.kotlinground.puzzles.arrays.array_three_pointers

import kotlin.math.abs

/**
 * minimizes the maximum difference
 *     Windowing strategy works here.
 *     Take 3 pointers i, j and k
 *
 *     Initialize them to point to the start of arrays a, b and c
 *     Find min of i, j and k.
 *     Compute max(i, j, k) - min(i, j, k).
 *     If the new result is less than the current result, change it to the new result.
 *     Increment the pointer of the array which contains the minimum.
 *
 *     Note that we increment the pointer of the array which has the minimum, because our goal is to decrease the difference.
 *     Increasing the maximum pointer is definitely going to increase the difference. Increasing the second maximum pointer
 *     can potentially increase the difference (however, it certainly will not decrease the difference).
 */
fun minimize(a: List<Int>, b: List<Int>, c: List<Int>): Int {
    var currentMin = Integer.MAX_VALUE
    var i = 0
    var j = 0
    var k = 0

    while (i < a.size && j < b.size && k < c.size) {
        val aNum = a[i]
        val bNum = b[j]
        val cNum = c[k]

        val current = maxOf(abs(aNum - bNum), abs(bNum - cNum), abs(cNum - aNum))
        currentMin = minOf(currentMin, current)

        val minOfThree = minOf(aNum, bNum, cNum)

        if (aNum == minOfThree) {
            i++
        } else if (bNum == minOfThree) {
            j++
        } else {
            k++
        }
    }

    return currentMin
}
