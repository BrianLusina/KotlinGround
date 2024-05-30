package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart

private class MyError : Throwable("my error")

suspend fun main() {
    flowOf(1, 2, 3, 4)
        .onEach { delay(1000) }
        .onStart { println("Before, there was nothing") }
        .onCompletion { println("And then we are done") }
        .collect(::println)
    // Before, there was nothing
    //1
    //2
    //3
    //4
    // And then we are done

    flowOf("A", "B", "C", "D")
        .onEach { delay(1000) }
        .onStart { emit("Z") }
        .onCompletion { println("...done") }
        .collect { print(it) }

    // ZABCD...done

    flow<List<Int>> { delay(1000) }
        .onStart { println("Before, there was nothing...") }
        .onEach { delay(1000) }
        .onCompletion { println("And still nothing...") }
        .onEmpty { emit(emptyList()) }
        .collect(::println)

    // Before, there was nothing...
    //And still nothing...
    //[]

    val myFlow = flow {
        emit(1)
        emit(2)
        throw MyError()
    }

    myFlow
        .onEach { println("Got $it") }
        .catch { println("Caught $it") }
        .collect { println("Collected $it") }

    //Got 1
    //Collected 1
    //Got 2
    //Collected 2
    //Caught com.kotlinground.concurrency.coroutines.channelflowactors.MyError: my error
}