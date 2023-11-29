package com.kotlinground.algorithms.backtracking.restoreipaddresses

/**
 * Complexity Analysis
 * Let's assume we need to separate the input string into N integers, each integer is at most M digits.
 *
 * - Time complexity: O(M ^ N * N)
 * There are at most M ^ {N - 1} possibilities, and for each possibility checking whether all parts are valid takes
 * O(M⋅N) time, so the final time complexity is O(M ^ {N - 1}) * O(M*N) = O(M ^ (N) * N)
 *
 * For this question, M = 3, N = 4, so the time complexity is O(1).
 *
 * Space complexity: O(M*N).
 *
 * For each possibility, we save (N - 1) numbers (the number of digits before each dot) which takes O(N) space.
 * And we need temporary space to save a solution before putting it into the answer list. The length of each solution
 * string is M * N + M − 1 = O(M⋅N), so the total space complexity is O(M⋅N) if we don't take the output space into
 * consideration.
 *
 * For this question, M = 3, N = 4, so the space complexity is O(1).
 */
fun restoreIpAddresses(s: String): List<String> {

    /**
     * Checks whether the substring from index start to start+length is a valid number from 0-255.
     * The logic is to check both the conditions(caller guarantees that the length is in the range of [1,3]):
     * 1. If the substring's first character is 0 (s[start] is '0'), then the length must be 1
     * 2. If length is 3, the substring should be no larger than '255 lexically. if the length is 1 or 2 and the first
     * case was not triggered, then it will be in the acceptable range
     */
    fun valid(stringToCheck: String, start: Int, length: Int): Boolean {
        return length == 1 ||
                stringToCheck[start] != '0' &&
                (length < 3 || stringToCheck.substring(
                    start,
                    start + length
                ) <= "255")
    }

    fun helper(candidate: String, startIndex: Int, dots: ArrayList<Int>, ips: ArrayList<String>) {
        // string length we want to process
        val remainingLength = s.length - startIndex

        val remainingNumberOfIntegers = 4 - dots.size // how many integers we have left to form

        // since each integer has 1-3 digits. This catches the case where s.length > 12 since at the beginning
        // remainingLength is s.length and remainingNumberOfIntegers is 4
        if (remainingLength > (remainingNumberOfIntegers * 3) || remainingLength < remainingNumberOfIntegers) {
            return
        }

        /**
         * If remainingNumberOfIntegers = 1,
         * - if the last integer s.substring(startIndex, startIndex + remainingLength) is valid
         *  - Create an empty string to save this answer using the following steps.
         *      - Set last to 0.
         *      - Iterate over all elements dot in the list dots.
         *          - Append s.substring(last, last + dot) and a '.' into the answer string.
         *          - Increase last by dot and repeat these steps for each dot.
         *  - Append s.substring(last, s.length). This is the final integer after the last dot.
         *  - Add the answer string into ans.
         * Return.
         */
        if (dots.size == 3) {
            if (valid(candidate, startIndex, remainingLength)) {
                val sb = StringBuilder()
                var last = 0

                for (dot in dots) {
                    sb.append(candidate.substring(last, last + dot))
                    last += dot
                    sb.append(".")
                }

                sb.append(candidate.substring(startIndex))
                ips.add(sb.toString())
            }
            return
        }

        /**
         * Iterate over curPos from 1 to min(3, remainingLength). curPos is the number of digits we are including before
         * placing a dot.
         * - Place a dot by adding curPos into dots.
         * - If the integer s.substring(startIndex, startIndex + curPos) is valid
         *      - Call helper(s, startIndex + curPos, dots, ans)
         * - Remove the dot that we placed to backtrack.
         */
        var curPos = 1
        while (curPos <= 3 && curPos <= remainingLength) {
            // Append a dot at the current position.
            dots.add(curPos)

            // Try making all combinations with the remaining string.
            if (valid(candidate, startIndex, curPos)) {
                helper(candidate, startIndex + curPos, dots, ips)
            }

            // Backtrack, i.e. remove the dot to try placing it at the next position.
            dots.remove(dots.size - 1)
            ++curPos
        }
    }

    val ipAddresses = arrayListOf<String>()
    val startIndex = 0
    val dots = arrayListOf<Int>()
    helper(s, startIndex, dots, ipAddresses)
    return ipAddresses
}
