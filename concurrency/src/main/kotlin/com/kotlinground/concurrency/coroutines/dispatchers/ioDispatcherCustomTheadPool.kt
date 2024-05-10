package com.kotlinground.concurrency.coroutines.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main() = coroutineScope {
    launch {
        printCoroutineTime(Dispatchers.IO)
        //Dispatchers.IO took: 2024
    }

    launch {
        printCoroutineTime(
            Dispatchers.IO
                .limitedParallelism(100)
        )
        //LimitedDispatcher@538c82e8 took: 1043

    }

    println("Done")
    // Done
    // Done
    //LimitedDispatcher@538c82e8 took: 1043
    //Dispatchers.IO took: 2024
}

suspend fun printCoroutineTime(dispatcher: CoroutineDispatcher) {
    val time = measureTimeMillis {
        coroutineScope {
            repeat(100) {
                launch(dispatcher) { Thread.sleep(1000) }
            }
        }
    }
    println("$dispatcher took: $time")
}
