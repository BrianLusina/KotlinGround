package com.kotlinground.bitmanipulation.countbits

fun countBits(n: Int): IntArray {
    val counter = IntArray(n + 1) { 0 }
    for (i in 1 until n + 1) {
        counter[i] = counter[i.shr(1)] + i % 2
    }
    return counter
}
