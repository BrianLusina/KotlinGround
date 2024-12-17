package com.kotlinground.strings.spreadsheetencode
import kotlin.math.pow

/**
 * This encodes a Spreadsheet column ID as an integer and returns it.
 * Here the encoding uses the alphabets A, B, C, etc. and
 * further uses the indexing of the alphabet starting from 1 like: A=1, B=2, C=3,..., Z=26
 * Complexity
 * Where n represents the number of characters in the column_id
 *
 * - Time O(n) as we iterate over each character in the column ID to calculate the encoding
 * - Space O(1) no extra space is required to perform the encoding
 * @param columnID [String] column ID to encode, e.g. A or ZZ
 * @return [Int] the encoded column ID
 */
fun spreadsheetEncodeColumn(columnID: String): Int {
    var num = 0
    var count = columnID.length - 1

    for (char in columnID) {
        val diff = char.code - 'A'.code + 1
        val base = 26.0.pow(count).toInt()
        num += base * diff
        count--
    }

    return num
}
