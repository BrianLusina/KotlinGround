package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis

class MessagesRepository {
    private val messages = mutableListOf<String>()
    private val mutex = Mutex()

    suspend fun add(message: String) = mutex.withLock {
        delay(1000) //simulate a network call
        messages.add(message)
    }
}

/**
 * This takes over 5 seconds to execute because a mutex does not unlock when a coroutine is suspended, essentially
 * blocking the thread not allowing other coroutines to use the thread until the coroutine with the lock has completed
 */
suspend fun main() {
    val repo = MessagesRepository()
    val timeMillis = measureTimeMillis {
        coroutineScope {
            repeat(5) {
                launch {
                    repo.add("Message$it")
                }
            }
        }
    }

    println(timeMillis) // ~5115
}
