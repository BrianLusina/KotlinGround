/**
 * Demonstrates Static Factory method
 */
package com.kotlinground.design.creationalpatterns.factory.server

class Server(private val port: Long) {
    fun init() {
        println("Server started on $port")
    }

    companion object {
        fun withPort(port: Long): Server = Server(port)

        fun withPort(port: String): Server {
            return runCatching { port.toLong() }
                .map { Server(it) }
                .getOrThrow()
        }
    }
}

fun main() {
    val server = Server.withPort(8080)
    val server2 = Server.withPort("8081")
    val server3 = Server(8082)
}
