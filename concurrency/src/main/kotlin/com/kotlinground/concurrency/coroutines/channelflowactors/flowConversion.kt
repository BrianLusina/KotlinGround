package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow

private suspend fun getUsername(): String {
    delay(1000)
    return "userName"
}

suspend fun main() {
    val function = suspend {
        delay(1000)
        "username"
    }

    function.asFlow().collect(::println)

    ::getUsername.asFlow().collect(::println)

    // username
    //userName
}