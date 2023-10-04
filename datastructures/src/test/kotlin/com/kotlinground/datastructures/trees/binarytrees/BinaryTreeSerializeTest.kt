package com.kotlinground.datastructures.trees.binarytrees

import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryTreeSerializeTest {

    @Test
    fun `should return x for a tree with no root`() {
        val tree = BinaryTree<Int>()

        val actual = tree.serialize()
        val expected = "x"
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 10 86 x x 100 x x for root(10, left(86), right(100)`() {
        val left = BinaryTreeNode(86)
        val right = BinaryTreeNode(100)
        val root = BinaryTreeNode(10, left = left, right = right)

        val tree = BinaryTree(root = root)
        val expected = "10 86 x x 100 x x"
        val actual = tree.serialize()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 2 x x 3 x x for root(1, left(2), right(3)`() {
        val left = BinaryTreeNode(data = 2)
        val right = BinaryTreeNode(data = 3)
        val root = BinaryTreeNode(data = 1, left = left, right = right)

        val tree = BinaryTree(root = root)

        val expected = "1 2 x x 3 x x"
        val actual = tree.serialize()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return 6 4 3 x x 5 x x 8 x x for root(6, left(4, left(3), right(5)), right(8)`() {
        val right = BinaryTreeNode(8)
        val leftLeft = BinaryTreeNode(3)
        val leftRight = BinaryTreeNode(5)
        val left = BinaryTreeNode(4, left = leftLeft, right = leftRight)
        val root = BinaryTreeNode(6, left = left, right = right)

        val tree = BinaryTree(root)

        val actual = tree.serialize()
        val expected = "6 4 3 x x 5 x x 8 x x"
        assertEquals(expected, actual)
    }
}
