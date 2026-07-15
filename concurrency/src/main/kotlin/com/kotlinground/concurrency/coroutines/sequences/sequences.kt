package com.kotlinground.concurrency.coroutines.sequences

import kotlinx.coroutines.runBlocking

val numSeq = sequence {
    yield(1)
    yield(2)
    yield(3)
}

val numSeq2 = sequence {
    println("Generating first")
    yield(1)
    println("Generating second")
    yield(2)
    println("Generating third")
    yield(3)
    println("Done")
}

fun main() = runBlocking {
    for (num in numSeq) {
        println(num)
    }

    for (num in numSeq2) {
        println("The next number is $num")
    }

    println("Using iterator")
    val iterator = numSeq2.iterator()

    val first = iterator.next()
    println("First: $first")

    val second = iterator.next()
    println("Second: $second")
}
