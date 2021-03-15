package com.kotlinground.kotlinintro.spektesting

/**
 * @author lusinabrian on 28/05/17.
 */

class Calculator(val output: Result) {
    var total = 0

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun accumulate(n: Int) {
        total += n
        output.write(total)
    }
}

interface Result {
    fun write(answer: Int)
}

class NullResult() : Result {
    override fun write(answer: Int) {

    }
}