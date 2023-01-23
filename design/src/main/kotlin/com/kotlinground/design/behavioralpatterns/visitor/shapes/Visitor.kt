package com.kotlinground.design.behavioralpatterns.visitor.shapes

interface Visitor {
    fun visitDot(dot: Dot): String
    fun visitCircle(circle: Circle): String
    fun visitRectangle(rectangle: Rectangle): String
    fun visitCompoundGraphic(compoundShape: CompoundShape): String
}
