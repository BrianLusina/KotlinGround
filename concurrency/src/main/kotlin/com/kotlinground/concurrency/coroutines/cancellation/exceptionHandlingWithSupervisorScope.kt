package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
            delay(1000)
            throw Error("Some error")
        }
        launch {
            delay(2000)
            println("Will be printed")
        }
    }

    delay(1000)
    println("Done")

    // output
    // Exception in thread "main" java.lang.Error: Some error
    // Will be printed
    // Done
}