package com.kotlinground.ktmath.pascalstriangle

/**
 * Gets Pascal's Triangle Nth row and returns it
 * This is much faster than calculating the whole triangle and then fetching by its index.
 * We instead use the formula:
 *   NCr = (NCr - 1 * (N - r + 1)) / r where 1 ≤ r ≤ N
 *   as the nth row consists of the following sequence:
 *   NC0, NC1, ......, NCN - 1, NCN
 */
fun pascalsNthRow(nth: Int): ArrayList<Int> {
    var ncr1 = 1
    var row = arrayListOf<Int>(ncr1)

    for (i in 1 until nth + 1) {
        val ncr = (ncr1 * (nth - i + 1)) / i
        row.add(ncr)
        ncr1 = ncr
    }
    return row
}
