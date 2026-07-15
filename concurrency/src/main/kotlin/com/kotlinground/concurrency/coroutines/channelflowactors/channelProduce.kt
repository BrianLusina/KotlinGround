package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    val channel = produce {
        repeat(5) {
            delay(1000)
            println("Producing next one")
            send(it * 2)
        }
    }

    channel.consumeEach(::println)

    /**
     * Or
     * ```kotlin
     * for (element in channel) {
     *    println(element)
     * }
     * ```
     *
     * or
     * ```kotlin
     * channel.consumeEach { element ->
     *  println(element)
     * }
     * ```
     */

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