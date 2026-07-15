package com.kotlinground.datastructures.arrays.arbitraryprecisionincrement

import com.kotlinground.utils.range.downUntil

fun arbitraryPrecisionIncrement(a: ArrayList<Int>): IntArray {
    a[a.size - 1] += 1

    // OR
//    for (i in  (1 until a.size).reversed()) {
    for (i in a.size - 1 downUntil 0) {
        if (a[i] != 10) {
            break
        }
        a[i] = 0
        a[i - 1] += 1
    }

    if (a[0] == 10) {
        a[0] = 1
        a.add(0)
    }

    return a.toIntArray()
}