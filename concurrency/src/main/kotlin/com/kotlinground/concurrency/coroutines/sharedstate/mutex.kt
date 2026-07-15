package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex

suspend fun main() = coroutineScope {
    repeat(55) {
        launch {
            delayAndPrint()
        }
    }
    // Output:
    // Done
    // Done
    // Done
    // Done
    // Done
    // ...
}

val mutex = Mutex()

suspend fun delayAndPrint() {
    mutex.lock()
    delay(1000)
    println("Done")
    mutex.unlock()
}