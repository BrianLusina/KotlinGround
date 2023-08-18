package com.kotlinground.datastructures.trees.binarytrees.bst

import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinarySearchTreeLeafSimilarTest {

    @Test
    fun `should return true for tree1=3,5,1,6,2,9,8,null,null,7,4 and tree2=3,5,1,6,7,4,2,null,null,null,null,null,null,9,8`() {
        val left1 = BinaryTreeNode(
            5, left = BinaryTreeNode(6),
            right = BinaryTreeNode(2, left = BinaryTreeNode(7), right = BinaryTreeNode(4))
        )
        val right1 = BinaryTreeNode(1, left = BinaryTreeNode(9), right = BinaryTreeNode(8))

        val root1 = BinaryTreeNode(3, left = left1, right = right1)
        val tree1 = BinarySearchTree(root1)

        val left2 = BinaryTreeNode(5, left = BinaryTreeNode(6), right = BinaryTreeNode(7))
        val right2 = BinaryTreeNode(
            1, left = BinaryTreeNode(4),
            right = BinaryTreeNode(2, left = BinaryTreeNode(9), right = BinaryTreeNode(8))
        )

        val root2 = BinaryTreeNode(3, left = left2, right = right2)
        val tree2 = BinarySearchTree(root2)

        val actual = tree1.leafSimilar(tree2)
        assertTrue(actual)
    }

    @Test
    fun `should return false for tree1=1,2,3 and tree2=1,3,2`() {
        val root1 = BinaryTreeNode(data = 1, left = BinaryTreeNode(2), right = BinaryTreeNode(3))
        val tree1 = BinarySearchTree(root = root1)

        val root2 = BinaryTreeNode(data = 1, left = BinaryTreeNode(3), right = BinaryTreeNode(2))
        val tree2 = BinarySearchTree(root = root2)

        val actual = tree1.leafSimilar(tree2)
        assertFalse(actual)
    }
}
