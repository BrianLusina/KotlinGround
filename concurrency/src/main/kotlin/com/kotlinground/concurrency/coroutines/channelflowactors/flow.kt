package com.kotlinground.concurrency.coroutines.channelflowactors

import com.kotlinground.concurrency.coroutines.suspension.delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow

@OptIn(ExperimentalCoroutinesApi::class)
private fun CoroutineScope.makeChannel() = produce {
    println("Channel started")
    for (i in 1..3) {
        delay(1000)
        send(i)
    }
}

private fun makeFlow() = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}

suspend fun main() = coroutineScope {
    val flow = makeFlow()
    val channel = makeChannel()

    delay(1000)
    println("Calling flow...")
    flow.collect { println(it) }

    println("Consuming again from flow...")
    flow.collect { println(it) }

    println("Calling channel...")
    for (value in channel) {
        println(value)
    }

    println("Consuming again from channel...")
    for (value in channel) {
        println(value)
    }

    // Calling flow...
    //Flow started
    //1
    //2
    //3
    //Consuming again from flow...
    //Flow started
    //1
    //2
    //3
    // Calling channel...
    //1
    //2
    //3
    //Consuming again from channel...
}