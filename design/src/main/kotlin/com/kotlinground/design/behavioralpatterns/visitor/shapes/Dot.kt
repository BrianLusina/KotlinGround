package com.kotlinground.design.behavioralpatterns.visitor.shapes

class Dot(val id: Int, val x: Int, val y: Int) : Shape {
    override fun move(x: Int, y: Int) {
        TODO("Not yet implemented")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }

    override fun accept(visitor: Visitor): String {
        return visitor.visitDot(this)
    }
}
