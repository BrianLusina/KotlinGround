package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class MessagesRepositoryV2 {
    private val messages = mutableListOf<String>()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = Dispatchers.IO.limitedParallelism(1)

    suspend fun add(message: String) = withContext(dispatcher) {
        delay(1000) //simulate a network call
        messages.add(message)
    }
}

/**
 * This takes slightly over 1 seconds to execute because of the use of a dispatcher with limited parallelism set to 1,
 * so, when a coroutine suspends, other coroutines can use the thread, increasing performance & utilization of the single
 * thread
 */
suspend fun main() {
    val repo = MessagesRepositoryV2()
    val timeMillis = measureTimeMillis {
        coroutineScope {
            repeat(5) {
                launch {
                    repo.add("Message$it")
                }
            }
        }
    }

    println(timeMillis) // ~1081
}
