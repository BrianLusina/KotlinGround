package com.kotlinground.algorithms.dynamicprogramming.dominotrominotiling

import java.util.Arrays


const val MOD = 1000000007

fun numTilings(n: Int): Int {
    if (n < 3) {
        return n
    }

    val dp = Array(n + 1) { LongArray(3) }

    dp.forEach {
        Arrays.fill(it, 0)
    }

    dp[0][0] = 1
    dp[1][0] = 1
    dp[1][1] = 1
    dp[1][2] = 1

    // Traverse the range [2, N]
    for (i in 2..n) {
        // Update the value of dp[i][0]
        dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] +
                dp[i - 2][1] + dp[i - 2][2]) % MOD

        // Update the value of dp[i][1]
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD

        // Update the value of dp[i][2]
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD
    }

    // Return the number of ways as
    // the value of dp[N][0]
    return dp[n][0].toInt()
}
