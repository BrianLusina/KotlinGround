package com.kotlinground.puzzles.secrethandshake

/**
 * @author lusinabrian on 15/01/18.
 */
object HandshakeCalculator {

    private const val REVERSE_POSITION = 4

    fun calculateHandshake(decimalNumber : Int) : List<Signal>{
        val result = Signal.values().filter { isBitSet(it.ordinal, decimalNumber) }

        return if(isBitSet(REVERSE_POSITION, decimalNumber)) result.reversed() else result
    }

    private fun isBitSet(position : Int, decimalNumber: Int) : Boolean {
        return decimalNumber shr position and 1 == 1
    }

}