package com.kotlinground.concurrency.coroutines.dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private var x = 0

suspend fun main(): Unit = coroutineScope {
    val dispatcher = Dispatchers.Default
        .limitedParallelism(1)

    repeat(10000) {
        launch(dispatcher) {
            x++
        }
    }
    delay(1000)
    println(x) // 10000
}