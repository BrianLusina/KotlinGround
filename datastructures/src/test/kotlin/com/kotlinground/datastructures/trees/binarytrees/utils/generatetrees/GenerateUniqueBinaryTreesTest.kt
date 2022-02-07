package com.kotlinground.datastructures.trees.binarytrees.utils.generatetrees

import com.kotlinground.datastructures.trees.BinaryTreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenerateUniqueBinaryTreesTest {

    @Test
    fun `Should return tree with root node only for input of 1`() {
        val n = 1
        val actual = generateTrees(n)
        val expected = listOf(BinaryTreeNode(1))
        assertEquals(1, actual.size)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should return 5 trees with input of 3`() {
        val n = 3
        val actual = generateTrees(n)
        val expected = listOf(
            BinaryTreeNode(
                data = 1,
                left = null,
                right = BinaryTreeNode(
                    data = 2,
                    left = null,
                    right = BinaryTreeNode(data = 3, left = null, right = null)
                )
            ),
            BinaryTreeNode(
                data = 1,
                left = null,
                right = BinaryTreeNode(
                    data = 3,
                    left = BinaryTreeNode(data = 2, left = null, right = null),
                    right = null
                )
            ),
            BinaryTreeNode(
                data = 2,
                left = BinaryTreeNode(data = 1, left = null, right = null),
                right = BinaryTreeNode(data = 3, left = null, right = null)
            ),
            BinaryTreeNode(
                data = 3,
                left = BinaryTreeNode(data = 1, left = null, right = BinaryTreeNode(2, left = null, right = null)),
                right = null
            ),
            BinaryTreeNode(
                data = 3,
                left = BinaryTreeNode(
                    data = 2,
                    left = BinaryTreeNode(data = 1, left = null, right = null),
                    right = null
                ),
                right = null
            )
        )
        assertEquals(5, actual.size)
        assertEquals(expected, actual)
    }
}