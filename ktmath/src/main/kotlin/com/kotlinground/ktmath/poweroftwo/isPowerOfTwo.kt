package com.kotlinground.ktmath.poweroftwo

/**
 * Determines if the given integer is a power of two.
 * An integer is a power of two if there exists an integer x such that n == 2^x.
 *
 * @param n the integer to check
 * @return true if the integer is a power of two, false otherwise
 */
fun isPowerOfTwo(n: Int): Boolean = n > 0 && n and n - 1 == 0
