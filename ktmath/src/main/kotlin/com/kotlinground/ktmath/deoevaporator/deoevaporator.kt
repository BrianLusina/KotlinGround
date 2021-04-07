package com.kotlinground.ktmath.deoevaporator

import kotlin.math.ceil
import kotlin.math.ln

fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int =
    ceil(ln(threshold / 100) / ln(1 - (evap_per_day / 100))).toInt()
