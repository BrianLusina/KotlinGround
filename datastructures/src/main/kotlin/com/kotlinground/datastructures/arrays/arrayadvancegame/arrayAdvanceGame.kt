package com.kotlinground.datastructures.arrays.arrayadvancegame

fun arrayAdvance(a: IntArray): Boolean {
    var furthestReached = 0
    val lastIdx = a.size - 1
    var i = 0

    while (furthestReached in i until lastIdx) {
        furthestReached = maxOf(furthestReached, a[i] + i)
        i++
    }

    return furthestReached >= lastIdx
}