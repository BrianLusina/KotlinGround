package com.kotlinground.algorithms.dynamicprogramming.longestcommonsubsequence

import kotlin.math.max

/**
 * LCS is a classic problem. Let dp[i][j] be the LCS for string text1 ends at index i and string text2 ends at index j.
 * If text1[i]==text2[j], then dp[i][j] would be 1+dp[i−1][j−1]. Otherwise, we target the largest LCS if we skip one
 * character from either text1 or text2, i.e. dp[i][j]=max(dp[i−1][j],dp[i][j−1]).
 *
 * Complexity:
 * Where m is the length of text1 and n is the length of text2
 * - Time complexity: O(m*n)
 * - Space complexity: O(m*n)
 */
fun longestCommonSubsequence(text1: String, text2: String): Int {
    val text1Length = text1.length
    val text2Length = text2.length

    val dp = Array(text1Length + 1) { IntArray(text2Length + 1) }

    for (i in 0 until text1Length + 1) {
        for (j in 0 until text2Length + 1) {
            if (i == 0 || j == 0) {
                //  setting first row and first column to be zero(initial readings)
                dp[i][j] = 0
            } else if (text1[i - 1] == text2[j - 1]) {
                /* if match found, then store value of previous diagonal element(dp[i - 1][j - 1]) and increase the
                value by 1 i.e. a new character match is found
                */
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                /*
                otherwise, choose maximum of either previous element, either in row(dp[i][j -1]) or column(dp[i][j - 1])
                */
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
            }
        }
    }

    // dp[text1Length][text2Length] would hold the value of the LCS obtained
    return dp[text1Length][text2Length]
}
