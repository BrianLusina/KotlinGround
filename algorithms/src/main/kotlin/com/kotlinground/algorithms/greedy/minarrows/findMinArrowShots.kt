package com.kotlinground.algorithms.greedy.minarrows

/**
 * The answer is at least 1. First we sort the balloons by the end coordinate. Set the first end coordinate as current.
 * Iterate over all balloons to check if the balloon starts after current. If so, increase answer by 1 and set
 * current = right.
 */
fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortBy { it[1] }

    var result = 1
    var current = points[0][1]

    for (point in points) {
        val left = point[0]
        val right = point[1]

        if (current < left) {
            result += 1
            current = right
        }
    }

    return result
}
