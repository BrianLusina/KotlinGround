package com.kotlinground.ktmath.kclosest

import java.util.Arrays

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val n: Int = points.size
    val dists = IntArray(n)
    for (i in 0 until n) dists[i] = dist(points[i])

    Arrays.sort(dists)
    val distK = dists[k - 1]

    val ans = Array(k) { IntArray(2) }
    var t = 0
    for (i in 0 until n) if (dist(points[i]) <= distK) ans[t++] = points[i]
    return ans
}

fun dist(point: IntArray): Int {
    return point[0] * point[0] + point[1] * point[1]
}
