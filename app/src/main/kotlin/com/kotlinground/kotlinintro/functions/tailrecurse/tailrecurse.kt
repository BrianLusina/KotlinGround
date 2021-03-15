package com.kotlinground.kotlinintro.functions.tailrecurse

import java.math.BigInteger

/**
 * @author lusinabrian on 30/05/17.
 * Tail recursion is useful when creating functions that ca recurse and cause a StackOverflow
 * error
 * keyword tailrec is used to make a function loop recursively in the compiler
 */

fun main() {
    println(fib(100000, BigInteger("1"), BigInteger("0")))
}

// without the key word tailrec, this function would result in stack over flow error
// for large numbers
tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) b else fib(n - 1, a + b, a)
}