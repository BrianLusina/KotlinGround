package com.kotlinground.datastructures.trees.binarytrees.bst

import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchTreeHeightTest {

    @Test
    fun `should return 0 for no root`() {
        val tree = BinarySearchTree<Int>()
        val actual = tree.height()
        assertEquals(0, actual)
    }

    @Test
    fun `should return 1 if the binary tree has a root, but no left nor right subtrees`() {
        val root = BinaryTreeNode(1)
        val tree = BinarySearchTree(root)
        val actual = tree.height()
        assertEquals(1, actual)
    }

    @Test
    fun `should return 3 for tree of 3,9,20,null,null,15,7`() {
        val left = BinaryTreeNode(data = 9)
        val rightLeft = BinaryTreeNode(data = 15)
        val rightRight = BinaryTreeNode(data = 7)
        val right = BinaryTreeNode(data = 20, left = rightLeft, right = rightRight)

        val root = BinaryTreeNode(3, left, right)
        val tree = BinarySearchTree(root)
        val actual = tree.height()
        assertEquals(3, actual)
    }

    @Test
    fun `should return 1 for tree of 1,null,2`() {
        val right = BinaryTreeNode(data = 2)

        val root = BinaryTreeNode(data = 1, right = right)
        val tree = BinarySearchTree(root = root)

        val actual = tree.height()
        assertEquals(2, actual)
    }
}