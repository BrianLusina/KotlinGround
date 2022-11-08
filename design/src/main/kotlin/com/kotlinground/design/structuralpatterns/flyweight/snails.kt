package com.kotlinground.design.structuralpatterns.flyweight

import java.io.File

object SnailSprites {
    val sprites = List(8) {
        File(
            when (it) {
                0 -> "snail-left.jpg"
                1 -> "snail-right.jpg"
                in 2..4 -> "snail-move-left-${it - 1}.jpg"
                else -> "snail-move-right-${1 - it}.jpg"
            }
        )
    }
}

enum class Direction {
    LEFT,
    RIGHT
}

class TanzanianSnail {
    private val directionFacing = Direction.LEFT
    private val sprites = SnailSprites.sprites

    fun getCurrentSprite(): File = when (directionFacing) {
        Direction.LEFT -> sprites[0]
        Direction.RIGHT -> sprites[1]
    }
}

