package com.kotlinground.design.behavioralpatterns.visitor.shapes

class CompoundShape(val id: Int) : Shape {
    val children = arrayListOf<Shape>()

    override fun move(x: Int, y: Int) {
        TODO("Not yet implemented")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }

    override fun accept(visitor: Visitor): String {
        return visitor.visitCompoundGraphic(this)
    }

    fun add(shape: Shape) {
        children.add(shape)
    }
}
