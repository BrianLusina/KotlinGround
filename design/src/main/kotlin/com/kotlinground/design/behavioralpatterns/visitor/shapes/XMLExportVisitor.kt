package com.kotlinground.design.behavioralpatterns.visitor.shapes

class XMLExportVisitor : Visitor {

    fun export(vararg args: Shape): String {
        val sb = StringBuilder()
        sb.append("<?xml version='1.0' encoding='utf-8?' \n")
        for (shape in args) {
            sb.append(shape.accept(this)).append("\n")
        }
        return sb.toString()
    }

    override fun visitDot(dot: Dot): String {
        return "<dot>" + "\n" +
                "    <id>" + dot.id + "</id>" + "\n" +
                "    <x>" + dot.x + "</x>" + "\n" +
                "    <y>" + dot.y + "</y>" + "\n" +
                "</dot>";
    }

    override fun visitCircle(circle: Circle): String {
        return "<circle>" + "\n" +
                "    <id>" + circle.id + "</id>" + "\n" +
                "    <x>" + circle.x + "</x>" + "\n" +
                "    <y>" + circle.y + "</y>" + "\n" +
                "    <radius>" + circle.radius + "</radius>" + "\n" +
                "</circle>";
    }

    override fun visitRectangle(rectangle: Rectangle): String {
        return "<rectangle>" + "\n" +
                "    <id>" + rectangle.id + "</id>" + "\n" +
                "    <x>" + rectangle.x + "</x>" + "\n" +
                "    <y>" + rectangle.y + "</y>" + "\n" +
                "    <width>" + rectangle.width + "</width>" + "\n" +
                "    <height>" + rectangle.height + "</height>" + "\n" +
                "</rectangle>";
    }

    override fun visitCompoundGraphic(compoundShape: CompoundShape): String {
        return "<compound_graphic>" + "\n" +
                "   <id>" + compoundShape.id + "</id>" + "\n" +
                visitCompoundShape(compoundShape) +
                "</compound_graphic>";
    }

    private fun visitCompoundShape(compoundShape: CompoundShape): String {
        val sb = StringBuilder()

        sb.append(compoundShape.children.map {
            val obj = it.accept(this)
            // Proper indentation for sub-objects.
            """    ${obj.replace("\n", "\n    ")}"""
        })

        return sb.toString()
    }
}