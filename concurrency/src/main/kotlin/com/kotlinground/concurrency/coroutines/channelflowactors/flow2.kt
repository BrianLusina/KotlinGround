package com.kotlinground.concurrency.coroutines.channelflowactors

import com.kotlinground.concurrency.coroutines.suspension.delay
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private fun usesFlow() = flow {
    println("Flow started")
    repeat(3) {
        delay(1000)
        val ctx = currentCoroutineContext()
        val name = ctx[CoroutineName]?.name
        emit("User$it in $name")
    }
}

suspend fun main() {
    val users = usesFlow()

    withContext(CoroutineName("Name")) {
        val job = launch {
            // collect is suspending
            users.collect { println(it) }
        }

        launch {
            delay(2100)
            println("I got enough")
            job.cancel()
        }
    }

    // Flow started
    //User0 in Name
    //User1 in Name
    //I got enough
}