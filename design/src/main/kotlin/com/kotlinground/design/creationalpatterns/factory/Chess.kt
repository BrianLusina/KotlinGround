/**
 * Demonstrates factory method
 */
package com.kotlinground.design.creationalpatterns.factory

interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(override val file: Char, override val rank: Char) : ChessPiece
data class Queen(override val file: Char, override val rank: Char) : ChessPiece
data class King(override val file: Char, override val rank: Char) : ChessPiece

/**
 * Factory function to create a ChessPiece
 */
fun createPiece(notation: String): ChessPiece {
    // destructing declaration
    val (type, file, rank) = notation.toCharArray()

    return when (type) {
        'q' -> Queen(file, rank)
        'p' -> Pawn(file, rank)
        'k' -> King(file, rank)
        else -> throw Exception("Unknown piece $type")
    }
}
