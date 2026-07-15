package com.kotlinground.concurrency.coroutines.sharedstate

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun massiveRun(
    count: Int = 1000,
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    action: suspend () -> Unit
) =
    withContext(dispatcher) {
        repeat(count) {
            launch {
                repeat(count) {
                    action()
                }
            }
        }
    }