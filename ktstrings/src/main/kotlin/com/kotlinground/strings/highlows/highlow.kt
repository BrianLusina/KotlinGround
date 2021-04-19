package com.kotlinground.strings.highlows

import java.util.Collections.max
import java.util.Collections.min

fun highAndLow(numbers: String): String {
    val nums = numbers.split(" ").map { it.toInt() }

    val max = max(nums)
    val min = min(nums)

    return "$max $min"
}
