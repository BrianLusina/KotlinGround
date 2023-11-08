package com.kotlinground.algorithms.dynamicprogramming.uniquepaths

import kotlin.math.min

/**
 * Uses a math formula to determine the number of unique paths.
 * We need to make n-1 + m-1 steps in total. How many ways to choose from m-1 right steps and n-1 down steps out of the
 * total steps?
 */
fun uniquePathsMath(m: Int, n: Int): Int {
    var ans = 1L
    var x = m + n - 2
    val k = min(n - 1, m - 1)

    for (i in 1..k) {
        ans *= x
        x -= 1
        ans /= i
    }
    return ans.toInt()
}

/**
 * Uses top-down approach with memoization. We begin with the position (0,0). At any position (i,j), we make a recursive
 * call to (i+1,j) and (i,j+1) to get the number of paths to the right and below the current node. If (i,j) goes out of
 * bounds, there can exist no path from it, so we simply return 0. If we reach (n-1,m-1), we have found a path and so
 * in this case we return 1.
 *
 * We are using memoization to store already computed value so it will reduce runtime by just accessing the already
 * computed value
 *
 * We are going to traverse all the unique paths, and store the values of the number of unique paths of each cell
 * in our cache. Slight difference, we can start at m,n and traverse towards 0,0 to get the same result, which allows
 * us to reuse the function as our recursive function.
 *
 * Complexity Analysis:
 * - Time Complexity: O(m*n)
 * - Space Complexity: O(m*n)
 */
fun uniquePathsTopDown(m: Int, n: Int): Int {

    val cache = hashMapOf<String, Int>()

    fun uniquePathsHelper(row: Int, col: Int): Int {
        val search = "$row#$col"

        return if (cache.containsKey(search)) {
            cache.getOrDefault(search, 0)
        } else if (row == 1 || col == 1) {
            1
        } else if (row == 0 && col == 0) {
            0
        } else {
            cache[search] = uniquePathsHelper(row - 1, col) + uniquePathsHelper(row, col - 1)
            cache.getOrDefault(search, 1)
        }
    }

    return uniquePathsHelper(m, n)
}

fun uniquePathsBottomUp(m: Int, n: Int): Int {
    var row = IntArray(n) { 1 }

    for (i in 0 until m) {
        val newRow = IntArray(n) { 1 }

        for (j in n - 2 downTo  0) {
            newRow[j] = newRow[j + 1] + row[j]
        }

        row = newRow
    }

    return row[0]
}
