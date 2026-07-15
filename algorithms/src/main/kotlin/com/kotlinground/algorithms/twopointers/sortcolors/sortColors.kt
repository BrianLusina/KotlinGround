package com.kotlinground.algorithms.twopointers.sortcolors

fun sortColors(colors: IntArray): IntArray {
    var low = 0
    var mid = 0
    var high = colors.size - 1

    while (mid <= high) {
        if (colors[mid] == 0) {
            val m = colors[mid]
            colors[mid] = colors[low];
            colors[low] = m;
            low += 1;
            mid += 1;
        } else if (colors[mid] == 1) {
            mid += 1;
        } else {
            val m = colors[mid]
            colors[mid] = colors[high]
            colors[high] = m
            high -= 1;
        }
    }

    return colors;
}
