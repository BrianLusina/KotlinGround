package com.kotlinground.ktmath.utils

object Utils {
    fun reverseNumber(number: Int) = reverseInt(number)

    fun reverseNumber(number: Long) = reverseLong(number)

    fun reverseNumber(number: Double) = number.toString().reversed().toDouble()

    /**
     * Reverse an integer
     * @param number
     * @return [number]
     */
    fun reverseInt(number: Int): Int {
        var num = number
        var reversed = 0
        while (num != 0) {
            val digit = num % 10
            reversed = reversed * 10 + digit
            num /= 10
        }
        return reversed
    }

    fun reverseLong(number: Long) = number.toString().reversed().toLong()
}

fun gcd(x: Int, y: Int): Int {
    return if (y == 0) {
        x
    } else {
        gcd(y, x % y)
    }
}

/**
 * Calculates the least common multiple (LCM) of two integers.
 *
 * @param x The first integer.
 * @param y The second integer.
 * @return The least common multiple of the two integers.
 */
fun lcm(x: Int, y: Int): Int {
    return (x * y) / gcd(x, y)
}

/**
 * Calculates the sum of the squares of the digits of a given integer.
 *
 * @param n the integer whose digits will be squared and summed
 * @return the sum of the squared digits of the input integer
 */
fun sumOfSquaredDigits(n: Int): Int {
    var sum = 0
    var number = n
    while (number > 0) {
        val digit = number % 10
        sum += digit * digit
        number /= 10
    }
    return sum
}
