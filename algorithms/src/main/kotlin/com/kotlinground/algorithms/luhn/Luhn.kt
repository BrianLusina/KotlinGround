package com.kotlinground.algorithms.luhn

/**
 * @author lusinabrian on 13/03/18.
 */
object Luhn {

    fun isValid(cardNumber: String): Boolean {
        val newCardNumber = cardNumber.replace(" ", "")

        if (newCardNumber.length <= 1) {
            return false
        }

        val reversed = newCardNumber.reversed()
        val evenlyPositioned = reversed.filterIndexed { index, _ -> index % 2 == 0 }.sumBy { it - '0' }
        val oddlyPositioned = reversed.filterIndexed { index, _ -> index % 2 == 1 }.map { sumDigits((it - '0') * 2) }.sum()

        return (evenlyPositioned + oddlyPositioned) % 10 == 0

    }

    /**
     * Second variation of isValid
     */
    fun isValid2(number: String): Boolean {
        val code = number.replace(" ", "")

        // if not number with 2 or more digits
        if (!code.matches(Regex("^\\d{2,}$"))) {
            return false
        }

        val sum = code.reversed().map { Character.getNumericValue(it) }
                .mapIndexed { index, num ->
                    if (index % 2 == 0) {
                        doubleDigit(num)
                    } else {
                        num
                    }
                }.sum()

        return sum % 10 == 0
    }

    private fun doubleDigit(n: Int): Int {
        val res = n * 2
        return if (res > 9) {
            res - 9
        } else {
            res
        }
    }

    private fun sumDigits(n: Int) = n / 10 + n % 10
}