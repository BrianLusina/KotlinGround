package com.kotlinground.concurrency.coroutines.coroutinescope

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

suspend fun fetchUser(): String {
    // runs forever
    while (true) {
        yield()
    }
}

// withTimeoutOrNull is useful for functions that run forever, this will cancel after 5 seconds
suspend fun getUserOrNull(): String? =
    withTimeoutOrNull(5000) {
        fetchUser()
    }


suspend fun test(): Int = withTimeout(1500) {
    delay(1000)
    println("Still thinking")
    delay(1000)
    println("Done")
    42
}

suspend fun main() = coroutineScope {
    try {
        test()
    } catch (e: TimeoutCancellationException) {
        println("Cancelled")
    }

    launch {// 1
        launch {// 2, cancelled by parent
            delay(2000)
            println("Will not be printed")
        }

        withTimeout(1500) { // will be cancelled after 1500ms which will throw a
            // TimeoutCancellationException which cancels the coroutine 1
            delay(1500)
        }
    }

    launch {// 3 is not affected by the cancellation of 1 as TimeoutCancelationException does not
        // cancel the parent
        delay(2000)
        println("Done")
    }

    delay(1000) // extra timeout does not help, test body was cancelled


    // output
    // Still thinking
    // Cancelled
    // Done
}