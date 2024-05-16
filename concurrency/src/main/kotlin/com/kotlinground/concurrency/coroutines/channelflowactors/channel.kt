package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val channel = Channel<Int>()
    launch {
        repeat(5) {
            delay(1000)
            println("Producing next one")
            channel.send(it * 2)
        }
    }
    launch {
        repeat(5) {
            val received = channel.receive()
            println(received)
        }
    }

    // output
    // Producing next one
    //0
    //Producing next one
    //2
    //Producing next one
    //4
    //Producing next one
    //6
    //Producing next one
    //8
}