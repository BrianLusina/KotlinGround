package com.kotlinapp.kotlinintro.functions.extensionfns

/**
 * @author lusinabrian on 30/05/17.
 * Creating extension functions with Kotlin
 * this adds functionality to a class that was not previously there before
 *
 */

fun main(args: Array<String>) {
    var string = "Me  You \t Them"
    println(replaceWhiteSpace(string))
    println(string.replaceWhiteSpaceEx())
}

/*without using extenstion functions*/
fun replaceWhiteSpace(text: String): String {
    var regex = Regex("\\s+")
    return regex.replace(text, " ")
}

// with an extension function
// this is the receiver of this function
fun String.replaceWhiteSpaceEx(): String {
    var regex = Regex("\\s+")
    return regex.replace(this, " ")
}