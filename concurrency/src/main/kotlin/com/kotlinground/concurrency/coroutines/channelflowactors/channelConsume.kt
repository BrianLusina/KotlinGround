package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
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
        for (element in channel) {
            println(element)
        }

        /**
         * Or
         * ```kotlin
         * channel.consumeEach(::println)
         * ```
         *
         * or
         * ```kotlin
         * channel.consumeEach { element ->
         *  println(element)
         * }
         * ```
         */
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