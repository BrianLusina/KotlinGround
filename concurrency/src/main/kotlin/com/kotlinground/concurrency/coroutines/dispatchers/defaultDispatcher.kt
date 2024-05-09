package com.kotlinground.concurrency.coroutines.dispatchers

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() = coroutineScope {
    repeat(1000) {
        launch {// or launch(Dispatchers.Default)
            // make it busy
            List(1000) { Random.nextLong() }
                .maxOrNull()

            val threadName = Thread.currentThread().name
            println("Running on thread: $threadName")
        }
    }

    // output
    // Running on thread: DefaultDispatcher-worker-8
    //Running on thread: DefaultDispatcher-worker-11
    //Running on thread: DefaultDispatcher-worker-2
    //Running on thread: DefaultDispatcher-worker-6
    //Running on thread: DefaultDispatcher-worker-1
    //Running on thread: DefaultDispatcher-worker-9
    //Running on thread: DefaultDispatcher-worker-3
    //Running on thread: DefaultDispatcher-worker-12
    //Running on thread: DefaultDispatcher-worker-5
    //Running on thread: DefaultDispatcher-worker-10
    //Running on thread: DefaultDispatcher-worker-4
    //Running on thread: DefaultDispatcher-worker-7
    //Running on thread: DefaultDispatcher-worker-6
    //Running on thread: DefaultDispatcher-worker-11
    //Running on thread: DefaultDispatcher-worker-8
    //Running on thread: DefaultDispatcher-worker-10
    // ...
}