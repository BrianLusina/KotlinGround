package com.kotlinground.design.structuralpatterns.adapter

import kotlin.math.sqrt

data class RoundHole(val radius: Int) {
    fun fits(peg: RoundPeg): Boolean = radius >= peg.radius
}

open class RoundPeg(val radius: Int) {
    open fun getPegRadius(): Int = radius
}

data class SquarePeg(val width: Int)

class SquarePegAdapter(private val peg: SquarePeg) : RoundPeg(peg.width) {
    override fun getPegRadius(): Int {
        return (peg.width * sqrt(2.0) / 2).toInt()
    }
}

fun main() {
    val roundHole = RoundHole(5)
    val roundPeg = RoundPeg(5)
    roundHole.fits(roundPeg)

    val smallSquarePeg = SquarePeg(5)
    val largeSquarePeg = SquarePeg(10)

    val smallSquarePegAdapter = SquarePegAdapter(smallSquarePeg)
    val largeSquarePegAdapter = SquarePegAdapter(largeSquarePeg)

    println(roundHole.fits(smallSquarePegAdapter))
    println(roundHole.fits(largeSquarePegAdapter))
}
