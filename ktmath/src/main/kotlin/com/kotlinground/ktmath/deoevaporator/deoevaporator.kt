package com.kotlinground.ktmath.deoevaporator

import kotlin.math.ceil
import kotlin.math.ln

const val PERCENTAGE = 100
const val ONE = 1

fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int =
    ceil(ln(threshold / PERCENTAGE) / ln(ONE - (evap_per_day / PERCENTAGE))).toInt()
