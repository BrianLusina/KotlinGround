package com.kotlinground.datastructures.trees.binarytrees

import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryTreeMaxLevelSumTest {

    @Test
    fun `should return 2 for tree (1,7,0,7,-8,null,null)`() {
        val left = BinaryTreeNode(7, left = BinaryTreeNode(7), right = BinaryTreeNode(-8))
        val right = BinaryTreeNode(0)

        val root = BinaryTreeNode(1, left = left, right = right)
        val tree = BinaryTree(root)

        val actual = tree.maxLevelSum()

        assertEquals(4, actual)
    }

    @Test
    fun `should return 3 for tree (-100,-200,-300,-20,-5,-10,null)`() {
        val left = BinaryTreeNode(-200, left = BinaryTreeNode(-20), right = BinaryTreeNode(-5))
        val right = BinaryTreeNode(-300, left = BinaryTreeNode(-10))
        val root = BinaryTreeNode(-100, left = left, right = right)

        val tree = BinaryTree(root = root)

        val actual = tree.maxLevelSum()
        assertEquals(3, actual)
    }

    @Test
    fun `should return 1 for tree=(1)`() {
        val root = BinaryTreeNode(data = 1)
        val tree = BinaryTree(root = root)

        val actual = tree.maxLevelSum()
        assertEquals(1, actual)
    }

    @Test
    fun `should return 0 for tree=(null)`() {
        val tree = BinaryTree<Int>()

        val actual = tree.maxLevelSum()
        assertEquals(0, actual)
    }
}
