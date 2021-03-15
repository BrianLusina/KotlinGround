package com.kotlinground.kotlinintro.functions.namedparams

/**
 * @author lusinabrian on 30/05/17.
 * Named params in functions
 */

fun main() {
    nameme(messenger = "Me", message = "Me is ", loglevel = 25)
}

fun nameme(messenger: String, message: String, loglevel: Int = 5) {
    println("$messenger, $message, $loglevel")
}
