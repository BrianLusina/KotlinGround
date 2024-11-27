/**
 * Demonstrates factory method
 */
package com.kotlinground.design.creationalpatterns.factory.chess

/**
 * Factory function to create a ChessPiece
 */
fun createPiece(notation: String): ChessPiece {
    require(notation.isNotEmpty() || notation.length >= 3) {
        error("Notation $notation provided must have at least a length of 3")
    }

    // destructing declaration
    // Since we assume that all of our notations are three characters long, the element at the 0 position will
    // represent the type of the chess piece,
    // the element at the 1 position will represent its vertical column – also known as file—
    // and the last element will represent its horizontal column—also known as rank.
    val (type, file, rank) = notation.toCharArray()

    return when (type) {
        'q' -> Queen(file, rank)
        'p' -> Pawn(file, rank)
        'k' -> King(file, rank)
        'r' -> Rook(file, rank)
        'n' -> Knight(file, rank)
        'b' -> Bishop(file, rank)
        else -> throw Exception("Unknown piece $type")
    }
}
