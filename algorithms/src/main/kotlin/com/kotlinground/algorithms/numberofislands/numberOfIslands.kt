package com.kotlinground.algorithms.numberofislands

fun numIslands(grid: Array<CharArray>): Int {
    var islands = 0

    if (grid.isEmpty() || grid[0].isEmpty()) {
        return 0
    }

    val numberOfRows = grid.size
    val numberOfCols = grid[0].size

    fun dfs(r: Int, c: Int) {
        if (r < 0 || r >= numberOfRows || c < 0 || c >= numberOfCols || grid[r][c] == '0') {
            return
        }

        grid[r][c] = '0'
        val directions = listOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        directions.forEach {
            dfs(r + it[0], c + it[1])
        }
    }

    for (row in 0 until numberOfRows) {
        for (col in 0 until numberOfCols) {
            if (grid[row][col] == '1' && grid[row][col] == '1') {
                islands++
                dfs(row, col)
            }
        }
    }

    return islands
}
