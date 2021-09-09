package com.kotlinground.ktmath.sieveoferastothenes

import com.kotlinground.ktmath.primes.isPrime

/**
 * @author lusinabrian on 16/04/18.
 */
object SieveOfErastothenes {

    fun primesUpTo(ceil: Int, start: Int = 2): List<Int> {
        if (ceil == 1) {
            return emptyList()
        }

        val possiblePrimes = (start..ceil).toList()

        return possiblePrimes.filter(::isPrime)
    }
}
