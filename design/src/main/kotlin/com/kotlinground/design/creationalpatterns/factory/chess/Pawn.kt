package com.kotlinground.design.creationalpatterns.factory.chess

data class Pawn(override val file: Char, override val rank: Char) : ChessPiece
