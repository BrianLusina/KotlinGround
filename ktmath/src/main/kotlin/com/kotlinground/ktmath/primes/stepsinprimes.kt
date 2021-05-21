package com.kotlinground.ktmath.primes

// if these g-steps prime numbers don't exist return []
fun step(g: Int, m: Long, n: Long): LongArray {
    if ((n - m) < g) {
        return longArrayOf()
    }

    if ((n - m) == g.toLong() && (isPrime(m.toInt()) && isPrime(n.toInt()))) {
        return longArrayOf(m, n)
    }

    for (x in m..n) {
        val second = x + g

        if (isPrime(x.toInt()) && isPrime(second.toInt())) {
            return longArrayOf(x, second)
        }
    }

    return longArrayOf()
}
