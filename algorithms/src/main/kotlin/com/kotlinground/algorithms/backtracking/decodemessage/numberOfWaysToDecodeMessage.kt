package com.kotlinground.algorithms.backtracking.decodemessage

fun numberOfWaysToDecodeMessage(digits: String): Int {
    val memo = hashMapOf<Int, Int>()

    fun dfs(startIndex: Int): Int {
        if (memo.containsKey(startIndex)) {
            return memo[startIndex]!!
        }

        if (startIndex == digits.length) {
            return 1
        }

        var ways = 0

        // can't decode string with leading 0
        if (digits[startIndex] == '0') {
            return ways
        }

        // decode 1 digit
        ways += dfs(startIndex + 1)

        // decode 2 digits
        if (startIndex + 2 <= digits.length && Integer.parseInt(digits.substring(startIndex, startIndex + 2)) <= 26) {
            ways += dfs(startIndex + 2)
        }

        memo[startIndex] = ways
        return ways
    }

    return dfs(0)
}
