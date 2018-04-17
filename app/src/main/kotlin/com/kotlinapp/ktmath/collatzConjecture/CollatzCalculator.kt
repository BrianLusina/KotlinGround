package com.kotlinapp.ktmath.collatzConjecture

/**
 * @author lusinabrian on 17/04/18.
 */
object CollatzCalculator{

    fun computeStepCount(n : Int) : Int{
        require(n > 0, { "Only natural numbers are allowed" })

        var steps = 0
        var number = n

        while (number > 1){
            if(number % 2 == 0) {
                number /= 2
                steps += 1
            } else{
                number = (3 * number) + 1
                steps += 1
            }
        }

        return steps
    }

    private fun Int.isOdd(): Boolean {
        return this % 2 != 0
    }

    private fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    // another variation to computeStepCount
    fun computeStepCount(n: Int, steps: Int = 0): Int {
        return when {
            n <= 0 -> throw IllegalArgumentException("Only natural numbers are allowed")
            n == 1 -> steps
            n.isOdd() -> computeStepCount(3 * n + 1, steps + 1)
            n.isEven() -> computeStepCount(n / 2, steps + 1)
            else -> throw IllegalArgumentException("Only natural numbers are allowed")
        }
    }
}