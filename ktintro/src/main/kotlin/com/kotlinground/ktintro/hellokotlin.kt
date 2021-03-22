package com.kotlinground.kotlinintro

fun main() {
    println("Hello Kotlin")
    println(sum(5, 5))
    println(add(5, 5))
    println(printSum(5, 8))

    // local variables
    val a: Int = 1 // immediate assignment
    val b = 2 //inferred assignment
    val c: Int //type required when no initializer is provided
    c = 3 // deferred assignment
    println("a = $a, b=$b, c=$c")


    // mutable variable
    var x = 6 //Int type is inferred
    x += 1 // deferred assignment

    println("Mutable variable x=$x")

    // string templates
    var n = 1 // inferred type is Int
    val s1 = "n is $n" //inferred type is String

    n = 2
    // arbitrary expression in template
    val s2 = "${s1.replace("is", "was")} but now is $n"
    println(s2)

    // conditional expressions
    println("Conditionals...")
    println("maximum between 5 and 6 is ${maxOf(5, 6)}")
    println("Maximum between 5 and 6 is ${maximum(5, 6)}")
}

/**
 * Function having 2 Int parameters with an Int return type
 * @param a int
 * @param b Int
 * @return {@link Int}*/
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * Function with 2 INt parameters with an inferred return type*/
fun add(a: Int, b: Int) = a + b

/**
 * Function returning no meaningful value
 * */
fun printSum(a: Int, b: Int): Unit {
    println("Sum of $a and $b is ${a + b}")
}

/**
 * Conditionals*/
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

/**
 * Using if as an expression*/
fun maximum(a: Int, b: Int) = if (a > b) a else b

/**
 * marked as Nullable when null values are possible
 * */
fun parseInt(str: String): Int? {
    return null
}
