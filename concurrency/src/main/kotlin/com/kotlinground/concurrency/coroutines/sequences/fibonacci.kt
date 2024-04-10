package com.kotlinground.concurrency.coroutines.sequences

import java.math.BigInteger

val fibonacci: Sequence<BigInteger> = sequence {
    var first = 0.toBigInteger()
    var second = 1.toBigInteger()

    while (true) {
        yield(first)
        val temp = first
        first += second
        second = temp
    }
}

fun main() {
    println("First 10 numbers in the Fibonacci sequence: ${fibonacci.take(10).toList()}")
    // First 10 numbers in the Fibonacci sequence: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
}