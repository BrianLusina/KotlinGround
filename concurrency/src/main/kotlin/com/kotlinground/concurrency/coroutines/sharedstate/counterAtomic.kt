package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger

var counterAtomic = AtomicInteger()

fun main() = runBlocking {
    massiveRun {
        counterAtomic.incrementAndGet()
    }
    println(counterAtomic.get()) // 1000000
}
