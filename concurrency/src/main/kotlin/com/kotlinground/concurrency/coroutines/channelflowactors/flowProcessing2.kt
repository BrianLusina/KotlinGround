package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan


suspend fun main() {
    val intsList = listOf(1, 2, 3, 4)

    println("Fold operation 1")
    val resIntsListFold = intsList.fold(0) { acc, i -> acc + i }
    println(resIntsListFold) //10

    println("Fold operation 2")
    val res2IntsListFold = intsList.fold(1) { acc, i -> acc * i }
    println(res2IntsListFold) //24

    println("Scan operation")
    val res3IntsListScan = intsList.scan(0) { acc, i -> acc + i }
    println(res3IntsListScan) // [0, 1, 3, 6, 10]

    println("Fold operation with Flow")
    val intsFlow = intsList.asFlow()
        .onEach { delay(1000) }

    val res3IntsFlowFold = intsFlow
        .fold(0) { acc, value -> acc + value }
    println(res3IntsFlowFold)
    // (4 sec)
    // 10

    println("Scan operation with Flow")
    intsList.asFlow()
        .onEach { delay(1000) }
        .scan(0) { accumulator, value -> accumulator + value }
        .collect(::println)
    // 0
    // (1 sec)
    //1
    // (1 sec)
    //3
    // (1 sec)
    //6
    // (1 sec)
    //10

}
