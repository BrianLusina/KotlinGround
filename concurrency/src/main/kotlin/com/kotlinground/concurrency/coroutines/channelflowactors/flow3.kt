package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

suspend fun main() {
    flow { emit("Message 1") } // Flow builder
        .onEach { println(it) } // intermediate operation
        .onStart { println("Do something before") } // intermediate operation
        .onCompletion { println("Do something after") } // intermediate operation
        .catch { emit("Error") } // intermediate operation
        .collect { println("Collected $it") } // terminal operation

    // Do something before
    //Message 1
    //Collected Message 1
    //Do something after
}
