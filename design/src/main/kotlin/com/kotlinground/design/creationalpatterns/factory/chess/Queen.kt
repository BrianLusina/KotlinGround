package com.kotlinground.design.creationalpatterns.factory.chess

data class Queen(override val file: Char, override val rank: Char) : ChessPiece
