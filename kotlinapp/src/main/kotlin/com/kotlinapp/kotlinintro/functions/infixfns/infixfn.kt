package com.kotlinapp.kotlinintro.functions.infixfns

/**
 * @author lusinabrian on 30/05/17.
 * Demo of infix functions. Used on classes to add a 'new' function to them
 * They take in 1 parameter and can be called like operators
 */

fun main(args: Array<String>) {
    var h1 = Header("H1")
    var h2 = Header("H2")

    println(h1.plus(h2).Name)

    // with infix
    var h3 = h1 plusIfx h2
    println(h3.Name)

    var h4 = h1 + h3
    println(h4.Name)
}

class Header(var Name: String)

// without infix, this is an extension function
// operator overloading
// this allows us to overload an operator and use it as a custom function
operator fun Header.plus(other: Header): Header {
    return Header(this.Name + other.Name)
}

// with infix
infix fun Header.plusIfx(other: Header): Header {
    return Header(this.Name + other.Name)
}
