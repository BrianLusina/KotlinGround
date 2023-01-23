package com.kotlinground.design.behavioralpatterns.visitor.shapes

interface Shape {
    fun move(x: Int, y: Int)
    fun draw()
    fun accept(visitor: Visitor): String
}
