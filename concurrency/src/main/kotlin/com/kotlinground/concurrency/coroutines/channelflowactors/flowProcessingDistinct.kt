package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.toList

private data class SomeUser(val id: Int, val name: String) {
    override fun toString(): String {
        return "[$id] $name"
    }
}

suspend fun main() {
    flowOf(1, 2, 2, 3, 2, 1, 1, 3)
        .distinctUntilChanged()
        .collect(::print)
    // 123213

    println(".....")

    val users = flowOf(
        SomeUser(1, "Alex"),
        SomeUser(1, "Bob"),
        SomeUser(2, "Bob"),
        SomeUser(2, "Celine"),
    )

    println(users.distinctUntilChangedBy { it.id }.toList()) //[[1] Alex, [2] Bob]
    println(users.distinctUntilChangedBy { it.name }.toList()) // [[1] Alex, [1] Bob, [2] Celine]
    println(users.distinctUntilChanged { prev, next ->
        prev.id == next.id || prev.name == next.name
    }.toList()) //[[1] Alex, [2] Bob] //[2] Bob was emitted, because we compare to the previous emitted
}
