package com.kotlinground.algorithms.backtracking.lettercombination

import java.util.stream.Collectors

fun letterCombination(n: Int): List<String> {
    val result = arrayListOf<String>()
    if (n == 0) {
        return result
    }

    fun dfs(startIndex: Int, path: ArrayList<Char>) {
        if (startIndex == n) {
            result.add(
                path.stream()
                    .map { it.toString() }
                    .collect(Collectors.joining())
            )
            return
        }

        for (char in charArrayOf('a', 'b')) {
            path.add(char)
            dfs(startIndex + 1, path)
            path.removeAt(startIndex)
        }
    }

    dfs(0, arrayListOf())

    return result
}
