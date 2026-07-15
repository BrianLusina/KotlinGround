package com.kotlinground.concurrency.coroutines.sequences

import kotlin.random.Random

fun randomUniqueStrings(length: Int, seed: Long = System.currentTimeMillis()): Sequence<String> = sequence {
    val random = Random(seed)
    val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    while (true) {
        val randomString = (1..length)
            .map { i -> random.nextInt(charPool.size) }
            .map(charPool::get)
            .joinToString("")

        yield(randomString)
    }
}
    .distinct()

fun main() {
    val num = randomUniqueStrings(10).iterator().next()
    println("Next random string is $num")
    // Next random string is qNzEjgywgj <- will always be a random string
}