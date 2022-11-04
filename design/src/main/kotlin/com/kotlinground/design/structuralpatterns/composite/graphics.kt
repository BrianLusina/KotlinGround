package com.kotlinground.design.structuralpatterns.composite

interface Graphic {
    fun move(x: Long, y: Long)
    fun draw()
}

open class Dot(open var x: Long, open var y: Long) : Graphic {
    override fun move(x: Long, y: Long) {
        println("Moving dot to x: $x & y: $y")
        this.x += x
        this.y += y
    }

    override fun draw() {
        println("Drawing a dot")
    }
}

class Circle(override var x: Long, override var y: Long, private val radius: Long) : Dot(x, y) {
    override fun draw() {
        println("Drawing a circle of radius $radius")
        super.draw()
    }
}

class CompoundGraphic(private val graphics: List<Graphic>) : Graphic {
    constructor(vararg graphics: Graphic) : this(graphics.toList())

    override fun move(x: Long, y: Long) {
        graphics.forEach { it.move(x, y) }
    }

    override fun draw() {
        graphics.forEach { it.draw() }
    }
}

fun main() {

    val dotOne = Dot(1, 2)
    val dotTwo = Dot(2, 3)
    val dotThree = Dot(3, 4)
    val circleOne = Circle(5, 6, 10)
    val circleTwo = Circle(7, 8, 11)
    val circleThree = Circle(9, 10, 12)

    val compoundGraphicOne = CompoundGraphic(dotOne, dotTwo, dotThree, circleOne, circleTwo, circleThree)
    val compoundGraphicTwo = CompoundGraphic(compoundGraphicOne)

    compoundGraphicOne.draw()
    compoundGraphicTwo.move(10, 21)
}