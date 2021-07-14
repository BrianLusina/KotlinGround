package com.kotlinground.ktmath.tanktruck

import kotlin.math.acos
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sin

fun tankVol(h: Int, d: Int, vt: Int): Int {
    val radius = d / 2.0
    val cylinderHeight = vt / (Math.PI * (radius.pow(2.0)))
    val triangleHeight = radius - h
    val theta = acos((triangleHeight / radius))

    val base = radius * sin(theta)
//    or
//    val base = sqrt((radius * radius) - (triangleHeight * triangleHeight))

    val triangleArea = (base * triangleHeight) / 2
    val sectorArea = (radius * radius * theta) / 2

    val remainderArea = (sectorArea - triangleArea) * 2
    return floor(cylinderHeight * remainderArea).toInt()
}
