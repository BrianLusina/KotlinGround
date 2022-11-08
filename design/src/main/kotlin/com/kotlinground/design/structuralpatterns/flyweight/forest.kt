package com.kotlinground.design.structuralpatterns.flyweight

// The flyweight class contains a portion of the state of a
// tree. These fields store values that are unique for each
// particular tree. For instance, you won't find here the tree
// coordinates. But the texture and colors shared between many
// trees are here. Since this data is usually BIG, you'd waste a
// lot of memory by keeping it in each tree object. Instead, we
// can extract texture, color and other repeating data into a
// separate object which lots of individual tree objects can
// reference.
data class TreeType(val name: String, val color: String, val texture: String) {
    fun draw(canvas: String, x: Long, y: Long) {}
}

// Flyweight factory decides whether to re-use existing
// flyweight or to create a new object.
object TreeFactory {
    private val treeTypes = arrayListOf<TreeType>()
    fun getTreeType(name: String, color: String, texture: String): TreeType {
        val type = treeTypes.find {
            it.name == name && it.color == color && it.texture == texture
        } ?: TreeType(name, color, texture)
        treeTypes.add(type)
        return type
    }
}

// The contextual object contains the extrinsic part of the tree
// state. An application can create billions of these since they
// are pretty small: just two integer coordinates and one
// reference field.
data class Tree(val x: Long, val y: Long, val type: TreeType) {
    fun draw(canvas: String) {
        type.draw(canvas, x, y)
    }
}

// The Tree and the Forest classes are the flyweight's clients.
// You can merge them if you don't plan to develop the Tree
// class any further.
class Forest {
    private val trees = arrayListOf<Tree>()

    fun plantTree(x: Long, y: Long, name: String, color: String, texture: String) {
        val type = TreeFactory.getTreeType(name, color, texture)
        val tree = Tree(x, y, type)
        trees.add(tree)
    }

    fun draw(canvas: String) {
        trees.forEach { it.draw(canvas) }
    }
}
