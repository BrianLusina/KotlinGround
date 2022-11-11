/**
 * Demonstrates Static Factory method
 */
package com.kotlinground.design.creationalpatterns.factory

class Server(port: Long) {
    fun init() {
        println("Server started on \$port")
    }

    companion object {
        fun withPort(port: Long): Server = Server(port)
    }
}

fun main() {
    val server = Server.withPort(8080)
    val server2 = Server(8080)
}
