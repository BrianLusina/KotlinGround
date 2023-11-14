package com.kotlinground.algorithms.backtracking.permutations

import java.util.stream.Collectors

/**
 * Generates permutations of the given letters and returns a list of all permutations.
 * Time Complexity
 *     We have n letters to choose in the first level, n - 1 choices in the second level and so on therefore the number
 *     of strings we generate is n * (n - 1) * (n - 2) * ... * 1, or O(n!). Since each string has length n, generating
 *     all the strings requires O(n * n!) time.
 * Space Complexity
 *     The total space complexity is given by the amount of space required by the strings we're constructing. Like the
 *     time complexity, the space complexity is also O(n * n!).

 * @param letters [String] letters to find permutations for
 * @return [List] of [String] with all the permutations of the letters
 */
fun generatePermutations(letters: String): List<String> {
    fun dfs(startIndex: Int, path: ArrayList<Char>, used: BooleanArray, result: ArrayList<String>) {
        if (startIndex == used.size) {
            // make a deep copy, otherwise we'd be appending the same list over and over
            result.add(path.stream().map { it.toString() }.collect(Collectors.joining()))
            return
        }

        for (i in used.indices) {
            // skip used letters
            if (used[i]) {
                continue
            }

            // add letter to permutation, mark letter as used
            path.add(letters[i])
            used[i] = true
            dfs(startIndex + 1, path, used, result)
            // remove letter from permutation
            path.removeAt(path.size - 1)
            used[i] = false
        }
    }

    val result = arrayListOf<String>()
    val usedLetters = BooleanArray(letters.length)
    val start = 0
    val pathTaken = arrayListOf<Char>()
    dfs(start, pathTaken, usedLetters, result)
    return result
}