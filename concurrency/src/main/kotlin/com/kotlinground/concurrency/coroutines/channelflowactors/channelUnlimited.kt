package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    val channel = produce(capacity = Channel.UNLIMITED) {
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
    //  Sent
    //  Sent
    //  Sent
    //  Sent
    //  Sent
    //  0
    //  2
    //  4
    //  6
    //  8
}
