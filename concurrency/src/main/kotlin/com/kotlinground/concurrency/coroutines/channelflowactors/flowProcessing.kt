package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.zip


suspend fun main() {
    val ints = flowOf(1, 2, 3, 4)
    val intsWithDelay = flowOf(1, 2, 3, 4).onEach { delay(1000) }
    val doubles = flowOf(0.1, 0.2, 0.3, 0.4)

    println("Merge with no delay")
    val together = merge(ints, doubles)
    println(together.toList())
    // [1, 2, 3, 4, 0.1, 0.2, 0.3, 0.4]

    println("Merge with a delay")
    val togetherWithDelay = merge(intsWithDelay, doubles)
    togetherWithDelay.collect(::println)
    //  0.1
    //  0.2
    //  0.3
    //  0.4
    //  1
    //  (1 sec)
    //  2
    //  (1 sec)
    //  3
    //  (1 sec)
    //  4

    val flow1 = flowOf("A", "B", "C")
        .onEach { delay(400) }
    val flow2 = flowOf(1, 2, 3, 4)
        .onEach { delay(1000) }

    println("Using Zip")
    flow1.zip(flow2) { f1, f2 -> "${f1}_${f2}" }
        .collect(::println)
    // A_1
    // B_2
    // C_3

    println("Using Combine")
    flow1.combine(flow2) { f1, f2 -> "${f1}_${f2}" }
        .collect(::println)
    //  B_1
    //  C_1
    //  C_2
    //  C_3
    //  C_4
}
