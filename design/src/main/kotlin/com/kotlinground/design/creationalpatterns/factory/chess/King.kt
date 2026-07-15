package com.kotlinground.design.creationalpatterns.factory.chess

data class King(override val file: Char, override val rank: Char) : ChessPiece
