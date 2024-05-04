package com.kotlinground.concurrency.coroutines.jobs

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job1 = launch {
        delay(1000)
        println("Test 1")
    }

    val job2 = launch {
        delay(2000)
        println("Test 2")
    }

    job1.join()
    job2.join()
    println("All tests done")
}
