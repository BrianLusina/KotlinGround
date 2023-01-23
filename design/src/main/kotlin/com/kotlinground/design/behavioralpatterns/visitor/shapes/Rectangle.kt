package com.kotlinground.design.behavioralpatterns.visitor.shapes

class Rectangle(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int) : Shape {
    override fun move(x: Int, y: Int) {
        TODO("Not yet implemented")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }

    override fun accept(visitor: Visitor): String {
        return visitor.visitRectangle(this)
    }
}
