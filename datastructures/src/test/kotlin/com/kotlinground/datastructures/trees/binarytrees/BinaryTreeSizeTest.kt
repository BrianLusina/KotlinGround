package com.kotlinground.datastructures.trees.binarytrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class BinaryTreeSizeTest {

    @Test
    fun `should return 0 for no root`() {
        val tree = BinaryTree<Int>()
        val actual = tree.size()
        assertEquals(0, actual)
    }

    @Test
    fun `should return 1 if the binary tree has a root, but no left nor right subtrees`() {
        val root = BinaryTreeNode(1)
        val tree = BinaryTree(root)
        val actual = tree.size()
        assertEquals(1, actual)
    }

    @Test
    fun `should return 5 for tree of 3,9,20,null,null,15,7`() {
        val left = BinaryTreeNode(data = 9)
        val rightLeft = BinaryTreeNode(data = 15)
        val rightRight = BinaryTreeNode(data = 7)
        val right = BinaryTreeNode(data = 20, left = rightLeft, right = rightRight)

        val root = BinaryTreeNode(3, left, right)
        val tree = BinaryTree(root)
        val actual = tree.size()
        assertEquals(5, actual)
    }

    @Test
    fun `should return 2 for tree of 1,null,2`() {
        val right = BinaryTreeNode(data = 2)

        val root = BinaryTreeNode(data = 1, right = right)
        val tree = BinaryTree(root = root)

        val actual = tree.size()
        assertEquals(2, actual)
    }
}