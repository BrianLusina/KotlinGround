package com.kotlinground.ktmath.factorial

fun trailingZeros(number: Int): Int {
    var n = number
    var count = 0

    while (n >= 5) {
        n /= 5
        count += 5
    }

    return count
}
