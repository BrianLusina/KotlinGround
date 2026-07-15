package com.kotlinground.concurrency.coroutines.suspension

import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class MyException : Throwable("Just an exception")

data class User(val name: String)

fun requestUser(callback: (User) -> Unit) {
    thread {
        Thread.sleep(1000)
        callback(User("Testing"))
    }
}

suspend fun main() {
    val i = suspendCoroutine {
        it.resume(80)
    }
    println(i)

    val s = suspendCoroutine {
        it.resume("Hey")
    }
    println(s)

    val b = suspendCoroutine {
        it.resume(true)
    }
    println(b)

    println("Before Getting our user, there was nothing")
    val user = suspendCoroutine {
        requestUser { user ->
            it.resume(user)
        }
    }

    println(user)
    println("Then we got our user & we were happy")

    println("But what happened if we didn't get the user & instead got an exception?")
    try {
        suspendCoroutine<Unit> { cont ->
            cont.resumeWithException(MyException())
        }
    } catch (e: MyException) {
        println("Caught that little rascal!")
    }
}
