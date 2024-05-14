package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

suspend fun main() = coroutineScope {
    val mutex = Mutex()
    println("Started")
    // coroutine can not obtain a lock twice, i.e. use the same key to obtain another mutex
    mutex.withLock {
        mutex.withLock {
            println("Will never be printed")
        }
    }
    println("")

    // Output
    // Started
    // (Runs forever)
}
