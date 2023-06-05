package com.kotlinground.ktmath.primes.backwardsreadprimes

import com.kotlinground.ktmath.primes.isPrime
import com.kotlinground.ktmath.sieveoferastothenes.SieveOfErastothenes
import com.kotlinground.ktmath.utils.Utils

fun backwardsPrime(start: Long, end: Long): String {
    val primes = SieveOfErastothenes.primesUpTo(end.toInt(), start.toInt())
    val result = arrayListOf<Int>()

    for (prime in primes) {
        val reversedPrime = Utils.reverseInt(prime)

        if (isPrime(reversedPrime) && reversedPrime != prime) {
            result.add(prime)
        }
    }

    return result.joinToString(" ")
}

fun backwardsPrime(start: Int, end: Int): Collection<Int> {
    val reversed = (start..end).map { Utils.reverseNumber(it) }

    return (start..end).filterIndexed { i, n -> isPrime(n) && reversed[i] != n && isPrime(reversed[i]) }
}
