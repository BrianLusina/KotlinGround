package com.kotlinground.design.creationalpatterns.factory.chess

data class Rook(override val file: Char, override val rank: Char) : ChessPiece
