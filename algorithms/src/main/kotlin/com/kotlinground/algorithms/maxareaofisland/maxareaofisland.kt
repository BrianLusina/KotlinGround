package com.kotlinground.algorithms.maxareaofisland

import kotlin.math.max

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val numberOfRows = grid.size
    val numberOfCols = grid[0].size
    var maxArea = 0

    fun area(row: Int, col: Int): Int {
        if (row < 0 || row >= numberOfRows || col < 0 || col >= numberOfCols || grid[row][col] == 0) {
            return 0
        }

        grid[row][col] = 0
        val up = area(row - 1, col)
        val down = area(row + 1, col)
        val left = area(row, col - 1)
        val right = area(row, col + 1)
        return 1 + up + down + left + right
    }

    for (row in 0 until numberOfRows) {
        for (col in 0 until numberOfCols) {
            maxArea = max(maxArea, area(row, col))
        }
    }

    return maxArea
}
