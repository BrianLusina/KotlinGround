package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

private data class User(val name: String)

private interface UserApi {
    suspend fun takePage(pageNumber: Int): List<User>
}

private class FakeUserApi : UserApi {
    private val users = List(20) { User("User$it") }
    private val pageSize = 3

    override suspend fun takePage(pageNumber: Int): List<User> {
        delay(1000)
        return users
            .drop(pageSize * pageNumber)
            .take(pageSize)
    }
}

private fun allUsersFlow(api: UserApi): Flow<User> = flow {
    var page = 0
    do {
        println("Fetching page $page")
        val users = api.takePage(page++)
        emitAll(users.asFlow())
    } while (users.isNotEmpty())
}

private fun allUsersChannelFlow(api: UserApi): Flow<User> = channelFlow {
    var page = 0
    do {
        println("Fetching page $page")
        val users = api.takePage(page++)
        users.forEach {
            send(it)
        }
    } while (users.isNotEmpty())
}

suspend fun main() {
    val api = FakeUserApi()
    val users = allUsersFlow(api)

    val user = users.first {
        println("Checking $it")
        delay(1000)
        it.name == "User3"
    }

    println(user)
    // Fetching page 0
    //Checking User(name=User0)
    //Checking User(name=User1)
    //Checking User(name=User2)
    //Fetching page 1
    //Checking User(name=User3)
    //User(name=User3)

    val usersChannelFlow = allUsersChannelFlow(api)

    val user2 = usersChannelFlow.first {
        println("Checking $it")
        delay(1000)
        it.name == "User3"
    }

    println(user2)
    //Fetching page 0
    //Checking User(name=User0)
    //Fetching page 1
    //Checking User(name=User1)
    //Fetching page 2
    //Checking User(name=User2)
    //Fetching page 3
    //Checking User(name=User3)
    //Fetching page 4
    //User(name=User3)
}