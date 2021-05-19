package com.kotlinground.algorithms.climbstairs

fun climbStairs(n: Int): Int {
    if (n == 1) {
        return 1
    }

    var first = 1
    var second = 2

    for (x in 3..n) {
        val third = first + second
        first = second
        second = third
    }

    return second
}
