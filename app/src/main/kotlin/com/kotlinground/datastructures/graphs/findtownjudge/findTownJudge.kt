package com.kotlinground.datastructures.graphs.findtownjudge

/**
 * Consider trust as a graph, all pairs are directed edge.
 * The point with in-degree - out-degree = N - 1 become the judge.
 *
 * Explanation:
 *
 * Count the degree, and check at the end.
 *
 * Time Complexity:
 * Time O(T + N), space O(N)
 * @param n Number of people in the town
 * @param trust Directed graph representation
 * @return The town judge
 */
fun findTownJudge(n: Int, trust: Array<IntArray>): Int {
    val count = Array(n + 1) { 0 }

    for (t in trust) {
        count[t[0]]--
        count[t[1]]++
    }

    for (i in 1 until count.size) {
        if (count[i] == n - 1) {
            return i
        }
    }
    return -1
}