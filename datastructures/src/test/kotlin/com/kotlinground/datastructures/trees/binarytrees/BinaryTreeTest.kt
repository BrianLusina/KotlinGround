package com.kotlinground.datastructures.trees.binarytrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeCountGoodNodesTest {

    @Test
    fun `should return 4 for tree=(3,1,4,3,null,1,5)`() {
        val root = BinaryTreeNode(
            3, left = BinaryTreeNode(1, left = BinaryTreeNode(3)),
            right = BinaryTreeNode(4, left = BinaryTreeNode(1), right = BinaryTreeNode(5))
        )
        val tree = BinaryTree(root)

        val actual = tree.countGoodNodes()

        assertEquals(4, actual)
    }

    @Test
    fun `should return 3 for tree=(3,3,null,4,2)`() {
        val root =
            BinaryTreeNode(data = 3, left = BinaryTreeNode(3, right = BinaryTreeNode(2), left = BinaryTreeNode(4)))
        val tree = BinaryTree(root = root)

        val actual = tree.countGoodNodes()
        assertEquals(3, actual)
    }

    @Test
    fun `should return 1 for tree=(1)`() {
        val root = BinaryTreeNode(data = 1)
        val tree = BinaryTree(root = root)

        val actual = tree.countGoodNodes()
        assertEquals(1, actual)
    }
}
