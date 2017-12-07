package com.kotlinapp.algorithms.hamming

/**
 * @author lusinabrian on 30/07/17.
 */
object Hamming {
    fun compute(strandA: String, strandB: String): Int {
        var count = 0
        if(strandA.length != strandB.length){
            throw IllegalArgumentException("leftStrand and rightStrand must be of equal length.")
        }
        strandA.forEachIndexed { index, c ->
            if( strandB[index] != c)
                count += 1
        }
        return count
    }
}