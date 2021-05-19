package com.kotlinground.ktmath.fibonacci

fun nthTribonacci(n: Int): Int {
    if (n == 0 || n == 1) {
        return n
    }

    var first = 0
    var second = 1
    var third = 1

    for (x in 3..n) {
        val fourth = first + second + third
        first = second
        second = third
        third = fourth
    }

    return third
}

fun nthTribonacciWithHash(n: Int): Int {
    val hash = HashMap<Int, Int>()

    return when (n) {
        0 -> 0
        1 -> 1
        2 -> 1
        else -> {
            val cached = hash[n]
            if (cached != null) cached else {
                val calculated =
                    nthTribonacciWithHash(n - 3) + nthTribonacciWithHash(n - 2) + nthTribonacciWithHash(n - 1)
                hash[n] = calculated
                calculated
            }
        }
    }
}