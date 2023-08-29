package com.kotlinground.puzzles.arrays.trappedrainwater

fun trap(height: IntArray): Int {
    if (height.isEmpty() || height.size == 1) {
        return 0
    }
    var left = 0
    var right = height.size - 1
    var mx = 0
    var mi: Int
    var trappedRain = 0

    while (left <= right) {
        mi = minOf(height[left], height[right])
        mx = maxOf(mx, mi)

        trappedRain += mx - mi

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }


    return trappedRain
}
