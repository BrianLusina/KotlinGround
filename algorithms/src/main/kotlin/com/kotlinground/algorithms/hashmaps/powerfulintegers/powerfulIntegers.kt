package com.kotlinground.algorithms.hashmaps.powerfulintegers

import kotlin.math.ln
import kotlin.math.pow

// Function to find all powerful integers <= bound
fun powerfulIntegers(x: Int, y: Int, bound: Int): MutableList<Int> {
    // Use a set to store unique powerful integers
    val resultSet: MutableSet<Int> = HashSet()

    // Compute powers of x up to bound
    // If x == 1, x^i is always 1, so only need i=0
    var powX: Long = 1 // x^0 = 1
    while (powX <= bound) {
        // For each power of x, iterate over powers of y
        var powY: Long = 1 // y^0 = 1
        while (powX + powY <= bound) {
            // Add the powerful integer to the set
            resultSet.add((powX + powY).toInt())
            // If y is 1, y^j is always 1, so break after first iteration
            if (y == 1) break
            // Move to next power of y
            powY *= y.toLong()
        }
        // If x is 1, x^i is always 1, so break after first iteration
        if (x == 1) break
        // Move to next power of x
        powX *= x.toLong()
    }

    // Convert set to list and return
    return ArrayList(resultSet)
}

fun powerfulIntegersLogarithmicBounds(x: Int, y: Int, bound: Int): MutableList<Int> {
    val a = if (x == 1) bound else (ln(bound.toDouble()) / ln(x.toDouble())).toInt()
    val b = if (y == 1) bound else (ln(bound.toDouble()) / ln(y.toDouble())).toInt()

    val resultSet = hashSetOf<Int>()

    for (i in 0..a) {
        for (j in 0..b) {
            val value = x.toDouble().pow(i.toDouble()).toInt() + y.toDouble().pow(j.toDouble()).toInt()

            if (value <= bound) {
                resultSet.add(value)
            }

            // No point in considering other powers of "1".
            if (y == 1) {
                break
            }
        }

        if (x == 1) {
            break
        }
    }

    return ArrayList(resultSet)
}
