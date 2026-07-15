package com.kotlinground.datastructures.sets

class DisjointSetUnion(private val size: Int) {
    init {
        require(size >= 0) { "Expected $size to be greater than or equal to 0" }
    }

    val root = IntArray(size)
}