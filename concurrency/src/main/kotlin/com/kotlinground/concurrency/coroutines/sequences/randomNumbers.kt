package com.kotlinground.concurrency.coroutines.sequences

import kotlin.random.Random

fun randomNumbers(seed: Long = System.currentTimeMillis()): Sequence<Int> = sequence {
    val random = Random(seed)
    while (true) {
        yield(random.nextInt())
    }
}

fun main() {
    val num = randomNumbers().iterator().next()
    println("Next random number is $num")
    // Next random number is 1977035790 <- will always be a random number
}