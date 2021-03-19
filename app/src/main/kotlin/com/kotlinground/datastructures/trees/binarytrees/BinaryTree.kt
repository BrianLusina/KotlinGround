package com.kotlinground.datastructures.trees.binarytrees

import com.kotlinground.datastructures.trees.BinaryTreeNode
import com.kotlinground.datastructures.trees.Trees

class BinaryTree(private var root: BinaryTreeNode? = null) : Trees<BinaryTreeNode>() {

    private operator fun Any.plusAssign(i: Int) {
        this += i
    }

    private operator fun Any.compareTo(data: Any?): Int {
        return this as Int
    }

    /**
     * Inserts a Tree node into this Binary Search Tree
     */
    override fun insertTreeNode(data: Any): BinaryTreeNode? {
        if (this.root == null) {
            return BinaryTreeNode(data)
        }

        var parent = this.root
        val dummy = this.root

        while (this.root != null) {
            parent = this.root

            if (data < this.root!!.data) {
                this.root = this.root!!.left
            } else {
                this.root = this.root!!.right
            }
        }

        when {
            parent != null -> {
                parent = BinaryTreeNode(data)
            }
            data < parent?.data -> {
                parent?.left = BinaryTreeNode(data)
            }
            else -> {
                parent?.right = BinaryTreeNode(data)
            }
        }
        return dummy
    }

    override fun mergeTree(root: BinaryTreeNode?, otherTree: BinaryTreeNode?): BinaryTreeNode? {
        val thisRoot = root ?: this.root ?: return otherTree

        if (otherTree == null) {
            return this.root
        }

        // assumption is that data is an integer
        thisRoot.data.plusAssign(otherTree.data as Int)
        thisRoot.left = mergeTree(thisRoot.left, otherTree.left)
        thisRoot.right = mergeTree(thisRoot.right, otherTree.right)

        return this.root
    }

    override fun inorderTraversalRecurse(root: BinaryTreeNode): Collection<Any> {
        TODO("Not yet implemented")
    }

    override fun inorderTraversalIteratively(): Collection<Any> {
        val stack = arrayListOf<BinaryTreeNode>()
        val result = arrayListOf<Any>()
        var current = root;

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.add(current)
                current = current.left
            }

            current = stack.removeAt(stack.size - 1)
            result.add(current.data)
            current = current.right
        }

        return result
    }

    override fun inorderMorrisTraversal(): Collection<Any> {
        val result = arrayListOf<Any>()
        var current = root
        var pre: BinaryTreeNode?

        while (current != null) {
            if (current.left == null) {
                result.add(current.data)
                current = current.right
            }

            pre = current?.left

            while (pre?.right != null) {
                pre = pre.right
            }

            pre?.right = current
            val temp = current
            current = current?.left
            temp?.left = null
        }
        return result
    }

    override fun preorderTraversal(): Collection<Any> {
        val result = arrayListOf<Any>()
        val stack = arrayListOf<BinaryTreeNode>()

        if (root == null) {
            return result
        }

        var current = root

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                result.add(current.data)
                stack.add(current)
                current = current.left
            }

            current = stack.removeAt(stack.size - 1)
            current = current.right
        }

        return result
    }

    override fun postorderTraversal(): Collection<Any> {
        val values = arrayListOf<Any>()
        val stackOne = arrayListOf<BinaryTreeNode>()
        val stackTwo = arrayListOf<BinaryTreeNode>()

        if (root == null) {
            return values
        }

        stackOne.add(root!!)

        while (stackOne.size != 0) {
            val node = stackOne.removeAt(stackOne.size - 1)
            stackTwo.add(node)

            if (node.left != null) {
                stackOne.add(node.left!!)
            }

            if (node.right != null) {
                stackOne.add(node.right!!)
            }
        }

        while (stackTwo.size != 0) {
            val node = stackTwo.removeAt(stackTwo.size - 1)
            values.add(node.data)
        }

        return values
    }
}
