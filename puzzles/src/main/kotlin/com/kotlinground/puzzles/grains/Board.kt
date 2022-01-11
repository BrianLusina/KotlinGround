package com.kotlinground.puzzles.grains

import java.math.BigInteger

/**
 * @author lusinabrian on 12/04/18.
 */
object Board {

    fun getGrainCountForSquare(square: Int): BigInteger {
        if (square !in IntRange(1, 64)) {
            throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
        }
        return BigInteger.valueOf(2).pow(square - 1)
    }

    fun getTotalGrainCount() = (1..64).map { getGrainCountForSquare(it) }.reduce { acc, bigInteger -> acc + bigInteger }
}