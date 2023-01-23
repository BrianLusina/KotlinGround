package com.kotlinground.design.behavioralpatterns.visitor.shapes

private fun export(vararg shapes: Shape) {
    val exportVisitor = XMLExportVisitor()
    println(exportVisitor.export(*shapes))
}

fun main() {
    val dot = Dot(1, 10, 55)
    val circle = Circle(2, 23, 15, 10)
    val rectangle = Rectangle(3, 10, 17, 20, 30)

    val compoundShape = CompoundShape(4)
    compoundShape.add(dot)
    compoundShape.add(circle)
    compoundShape.add(rectangle)

    val c = CompoundShape(5)
    c.add(dot)
    compoundShape.add(c)

    export(circle, compoundShape)
}