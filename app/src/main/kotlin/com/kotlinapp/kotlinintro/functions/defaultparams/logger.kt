package com.kotlinapp.kotlinintro.functions.defaultparams

/**
 * @author lusinabrian on 30/05/17.
 * demo of default params with kotlin
 */

fun main(args: Array<String>) {
    logger("Hello!!")
    logger("Danger!!", loglevel = 2)
}

/**
 * Logger that logs messages to a 'console'
 * @annotation: @JvmOverloads
 *  Since Java has no concept of default params, this allows the JVM to generate functions
 *  with default parameters
 * */

@JvmOverloads
fun logger(message: String, loglevel: Int = 1) {
    println("Msg: $message, Log Level: $loglevel")
}