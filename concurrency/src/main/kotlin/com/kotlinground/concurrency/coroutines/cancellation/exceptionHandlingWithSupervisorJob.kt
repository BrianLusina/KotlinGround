package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val scope = CoroutineScope(SupervisorJob())
    scope.launch {
        delay(1000)
        throw Error("Some error")
    }
    scope.launch {
        delay(2000)
        println("Will be printed")
    }

    delay(3000)

    // output
    // Exception in thread "DefaultDispatcher-worker-2" java.lang.Error: Some error
    // Will be printed
}