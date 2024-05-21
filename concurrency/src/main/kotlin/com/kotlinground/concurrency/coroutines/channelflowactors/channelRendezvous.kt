package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    // or
    //    val channel = produce {
    val channel = produce(capacity = Channel.RENDEZVOUS) {
        repeat(5) {
            send(it * 2)
            delay(100)
            println("Sent")
        }
    }

    delay(1000)

    channel.consumeEach {
        println(it)
        delay(1000)
    }

    // output
    //  0
    //  Sent
    //  2
    //  Sent
    //  4
    //  Sent
    //  6
    //  Sent
    //  8
    //  Sent
}
