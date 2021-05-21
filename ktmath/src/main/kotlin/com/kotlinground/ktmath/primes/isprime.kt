package com.kotlinground.ktmath.primes

import kotlin.math.sqrt

fun isPrime(number: Int): Boolean {
    when {
        number == 2 -> {
            return true
        }
        number % 2 == 0 || number < 2 -> {
            return false
        }
    }

    for (i in 3..sqrt(number.toDouble()).toInt() step 2) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}