package com.kotlinground.puzzles.search.binarysearch.kokoeatingbananas

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    var right = piles.max()

    while (left < right) {
        val mid = left + (right - left) / 2
        val hours = piles.sumOf { (it - 1) / mid + 1 }

        if (hours > h) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    return left
}
