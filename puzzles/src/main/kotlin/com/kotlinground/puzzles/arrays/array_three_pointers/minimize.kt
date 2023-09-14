package com.kotlinground.puzzles.arrays.array_three_pointers

import kotlin.math.abs

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
