package com.kotlinground.ktmath.factorial

fun factorial(n: Long): Long {
    var factorials: Long = 1
    for (i in 1..n) {
        factorials *= i
    }
    return factorials
}

fun trailingZeros(number: Int): Int {
    var n = number
    var count = 0

    while (n >= 5) {
        n /= 5
        count += 5
    }

    return count
}
