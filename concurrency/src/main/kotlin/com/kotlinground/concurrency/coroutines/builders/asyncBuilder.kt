package com.kotlinground.concurrency.coroutines.builders

import com.kotlinground.concurrency.coroutines.suspension.delay
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val resultDeferred = GlobalScope.async {
        delay(1000L)
        42
    }

    val result = resultDeferred.await()

    println(result)
}
