package com.kotlinground.algorithms.search.binary.search2dmatrix

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val nColumns = matrix[0].size

    for (row in matrix) {
        var left = 0
        var right = nColumns - 1
        var firstTrueIndex = -1

        while (left <= right) {
            val mid = (left + right) / 2
            if (row[mid] >= target) {
                firstTrueIndex = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        if (firstTrueIndex != -1 && row[firstTrueIndex] == target) {
            return true
        }
    }

    return false
}
