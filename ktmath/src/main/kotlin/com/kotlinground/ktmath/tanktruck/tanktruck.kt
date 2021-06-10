package com.kotlinground.ktmath.tanktruck

import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sin

fun tankVol(h: Int, d: Int, vt: Int): Int {
    val radius = d / 2
    val cylinderHeight = vt / (Math.PI * radius.toDouble().pow(2.0))
    val triangleHeight = radius - h
    val theta = acos((triangleHeight / radius).toDouble())

    val base = radius * sin(theta)

    val triangleArea = (base * triangleHeight) / 2
    val sectorArea = (radius * radius * theta) / 2

    val remainderArea = (sectorArea - triangleArea) * 2
    return (cylinderHeight * remainderArea).toInt()
}
