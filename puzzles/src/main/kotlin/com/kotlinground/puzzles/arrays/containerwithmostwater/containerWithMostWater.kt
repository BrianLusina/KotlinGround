package com.kotlinground.puzzles.arrays.containerwithmostwater

fun maxArea(height: IntArray): Int {
    var maxPossibleArea = 0
    var left = 0
    var right = height.size - 1

    while (left < right) {
        val width = right - left
        val area = width * minOf(height[left], height[right])
        maxPossibleArea = maxOf(maxPossibleArea, area)

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxPossibleArea
}
