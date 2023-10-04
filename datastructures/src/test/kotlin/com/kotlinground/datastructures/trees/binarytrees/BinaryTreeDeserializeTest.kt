package com.kotlinground.datastructures.trees.binarytrees

import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryTreeDeserializeTest {

    @Test
    fun `should return null for x`() {
        val tree = "x"

        val actual = BinaryTree<Int>().deserialize(tree)
        val expected = null
        assertEquals(expected, actual)
    }

    @Test
    fun `should return  root(10, left(86), right(100) for 10 86 x x 100 x x`() {
        val left = BinaryTreeNode("86")
        val right = BinaryTreeNode("100")
        val expected = BinaryTreeNode("10", left = left, right = right)

        val tree = "10 86 x x 100 x x"
        val actual = BinaryTree<String>().deserialize(tree)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return root(1, left(2), right(3) for 1 2 x x 3 x x`() {
        val left = BinaryTreeNode(data = "2")
        val right = BinaryTreeNode(data = "3")
        val expected = BinaryTreeNode(data = "1", left = left, right = right)

        val tree = "1 2 x x 3 x x"
        val actual = BinaryTree<String>().deserialize(tree)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return root(6, left(4, left(3), right(5)), right(8) for 6 4 3 x x 5 x x 8 x x`() {
        val right = BinaryTreeNode("8")
        val leftLeft = BinaryTreeNode("3")
        val leftRight = BinaryTreeNode("5")
        val left = BinaryTreeNode("4", left = leftLeft, right = leftRight)
        val expected = BinaryTreeNode("6", left = left, right = right)

        val tree = "6 4 3 x x 5 x x 8 x x"
        val actual = BinaryTree<String>().deserialize(tree)

        assertEquals(expected, actual)
    }
}
