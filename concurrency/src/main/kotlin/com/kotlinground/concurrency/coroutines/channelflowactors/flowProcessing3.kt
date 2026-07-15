package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retryWhen


private fun flowFrom(elem: String) = flowOf(1, 2, 3)
    .onEach { delay(1000) }
    .map { "${it}_$elem" }

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main() {
    flowOf("A", "B", "C")
        .flatMapConcat { flowFrom(it) }
        .collect(::println)

    // 1_A
    // (1 sec)
    //2_A
    // (1 sec)
    //3_A
    // (1 sec)
    //1_B
    // (1 sec)
    //2_B
    // (1 sec)
    //3_B
    // (1 sec)
    //1_C
    // (1 sec)
    //2_C
    // (1 sec)
    //3_C

    println("flatMapMerge...")

    flowOf("A", "B", "C")
        .flatMapMerge { flowFrom(it) }
        .collect(::println)

    // 1_A
    //1_B
    //1_C
    // (1 sec)
    //2_B
    //2_C
    //2_A
    // (1 sec)
    //3_C
    //3_A
    //3_B
    // (1 sec)

    println("flatMapMerge with concurrency of 2...")

    flowOf("A", "B", "C")
        .flatMapMerge(concurrency = 2) { flowFrom(it) }
        .collect(::println)

    // 1_A
    //1_B
    // (1 sec)
    //2_B
    //2_A
    // (1 sec)
    //3_A
    //3_B
    // (1 sec)
    //1_C
    // (1 sec)
    //2_C
    // (1 sec)
    //3_C

    println("flatMapLatest ...")

    flowOf("A", "B", "C")
        .flatMapLatest { flowFrom(it) }
        .collect(::println)

    // (1 sec)
    //1_C
    // (1 sec)
    //2_C
    // (1 sec)
    //3_C

    println("flatMapLatest with delay ...")

    flowOf("A", "B", "C")
        .onEach { delay(1200) }
        .flatMapLatest { flowFrom(it) }
        .collect(::println)


    // (2.2 sec)
    // 1_A
    // (1.2 sec)
    // 1_B
    // (1.2 sec)
    //1_C
    // (1 sec)
    //2_C
    // (1 sec)
    //3_C
}
