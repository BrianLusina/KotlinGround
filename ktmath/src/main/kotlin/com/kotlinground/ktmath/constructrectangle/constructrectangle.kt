package com.kotlinground.ktmath.constructrectangle

import kotlin.math.sqrt

fun constructRectangle(area: Int): IntArray {
    var w = sqrt(area.toFloat()).toInt()

    while (area % w != 0) {
        w -= 1
    }

    return intArrayOf(area / w, w)
}
