package com.kotlinground.datastructures.trees.binarytrees

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class BinaryTreeTraversalTest {

    @Test
    fun `should return F,B,A,D,C,E,G,I,H for pre order traversal`() {
        val expected = arrayOf("F", "B", "A", "D", "C", "E", "G", "I", "H")
        val right = BinaryTreeNode(
            "G",
            right = BinaryTreeNode(
                "I",
                left = BinaryTreeNode("H")
            )
        )
        val left = BinaryTreeNode(
            "B",
            left = BinaryTreeNode("A"),
            right = BinaryTreeNode(
                "D",
                left = BinaryTreeNode("C"),
                right = BinaryTreeNode("E")
            )
        )
        val root = BinaryTreeNode("F", left = left, right = right)

        val tree = BinaryTree(root = root)
        val actual = tree.preorderTraversal()
        assertContentEquals(expected, actual.toTypedArray())
    }

    @Test
    fun `should return A, B, C, D, E, F, G, H, I for in order traversal iteratively`() {
        val expected = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        val right = BinaryTreeNode(
            "G",
            right = BinaryTreeNode(
                "I",
                left = BinaryTreeNode("H")
            )
        )
        val left = BinaryTreeNode(
            "B",
            left = BinaryTreeNode("A"),
            right = BinaryTreeNode(
                "D",
                left = BinaryTreeNode("C"),
                right = BinaryTreeNode("E")
            )
        )
        val root = BinaryTreeNode("F", left = left, right = right)

        val tree = BinaryTree(root = root)
        val actual = tree.inorderTraversalIteratively()
        assertContentEquals(expected, actual.toTypedArray())
    }

    @Test
    @Disabled("Morris Traversal algorithm is returning a single value instead of the whole list. Needs investigation")
    fun `should return A, B, C, D, E, F, G, H, I for in order traversal with Morris Algorithm`() {
        val expected = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        val right = BinaryTreeNode(
            "G",
            right = BinaryTreeNode(
                "I",
                left = BinaryTreeNode("H")
            )
        )
        val left = BinaryTreeNode(
            "B",
            left = BinaryTreeNode("A"),
            right = BinaryTreeNode(
                "D",
                left = BinaryTreeNode("C"),
                right = BinaryTreeNode("E")
            )
        )
        val root = BinaryTreeNode("F", left = left, right = right)

        val tree = BinaryTree(root = root)
        val actual = tree.inorderMorrisTraversal()
        assertContentEquals(expected, actual.toTypedArray())
    }

    @Test
    fun `should return A, C, E, D, B, H, I, G, F for in post traversal`() {
        val expected = arrayOf("A", "C", "E", "D", "B", "H", "I", "G", "F")
        val right = BinaryTreeNode(
            "G",
            right = BinaryTreeNode(
                "I",
                left = BinaryTreeNode("H")
            )
        )
        val left = BinaryTreeNode(
            "B",
            left = BinaryTreeNode("A"),
            right = BinaryTreeNode(
                "D",
                left = BinaryTreeNode("C"),
                right = BinaryTreeNode("E")
            )
        )
        val root = BinaryTreeNode("F", left = left, right = right)

        val tree = BinaryTree(root = root)
        val actual = tree.postorderTraversal()
        assertContentEquals(expected, actual.toTypedArray())
    }

    @Test
    fun `should return 1, 2, 3, 4, 5 for in level order traversal`() {
        val expected = arrayOf(1, 2, 3, 4, 5)
        val right = BinaryTreeNode(3)
        val left = BinaryTreeNode(
            2,
            left = BinaryTreeNode(4),
            right = BinaryTreeNode(5)
        )
        val root = BinaryTreeNode(1, left = left, right = right)

        val tree = BinaryTree(root = root)
        val actual = tree.levelOrderTraversal()
        assertContentEquals(expected, actual.toTypedArray())
    }

    @Test
    fun `should return 4, 5, 2, 3, 1 for in reverse level order traversal`() {
        val expected = arrayListOf(4, 5, 2, 3, 1)
        val right = BinaryTreeNode(3)
        val left = BinaryTreeNode(
            2,
            left = BinaryTreeNode(4),
            right = BinaryTreeNode(5)
        )
        val root = BinaryTreeNode(1, left = left, right = right)

        val tree = BinaryTree(root = root)
        val actual = tree.reverseLevelOrderTraversal()
        assertContentEquals(expected, actual)
    }
}
