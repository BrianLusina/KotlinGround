package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object MyNonPropagatingException : CancellationException() {
    private fun readResolve(): Any = MyNonPropagatingException
}

// the builder 1 is cancelled by throwing the exception 3 which cancels builder 2. Builder 4 remains uninterrupted &
// continue execution. The exception is not propagated beyond to the parent of builder 1
suspend fun main(): Unit = coroutineScope {
    launch {// 1
        launch { // 2
            delay(2000)
            println("Will not be printed")
        }
        throw MyNonPropagatingException // 3
    }

    launch {// 4
        delay(2000)
        println("Will be printed")
    }

    // output
    // Will be printed
}