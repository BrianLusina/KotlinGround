package com.kotlinground.algorithms.backtracking.partitionstring

import com.kotlinground.strings.palindromes.isPalindrome


fun partition(s: String): List<List<String>> {
    val wordLength = s.length
    val result = arrayListOf<List<String>>()

    fun dfs(start: Int, currentPath: ArrayList<String>) {
        if (start == s.length) {
            val li = ArrayList<String>(currentPath)
            result.add(li)
        }

        for (end in start until wordLength) {
            val prefix = s.substring(start, end + 1)
            if (isPalindrome(prefix)) {
                currentPath.add(prefix)
                dfs(end + 1, currentPath)
                currentPath.removeAt(currentPath.size - 1)
            }
        }
    }

    dfs(0, arrayListOf())
    return result
}
