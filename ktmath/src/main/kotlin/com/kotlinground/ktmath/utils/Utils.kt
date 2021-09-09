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
