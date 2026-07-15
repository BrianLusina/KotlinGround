package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

val mutex2 = Mutex()
var counter3 = 0

suspend fun main() = coroutineScope {
    massiveRun {
        mutex2.withLock {
            counter3++
        }
    }
    println(counter3) // 1000000
}
