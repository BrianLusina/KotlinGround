package com.kotlinground.datastructures.trees.binarytrees

import com.kotlinground.datastructures.trees.TreeNode
import com.kotlinground.datastructures.trees.Trees
import com.kotlinground.datastructures.trees.compareTo

class BinarySearchTree<T : Comparator<T>>(private var root: BinaryTreeNode<T>? = null) : Trees<T>() {

    private operator fun Any.plusAssign(i: Int) {
        this += i
    }

    override fun height(): Int {
        if (root == null) {
            return 0
        }

        if (root!!.left == null && root!!.right == null) {
            return 0
        }

        var height = 0
        val queue = arrayListOf<BinaryTreeNode<T>>()

        while (true) {
            var currentLevelNodes = queue.size

            if (currentLevelNodes == 0) {
                return height
            }

            height++

            while (currentLevelNodes > 0) {
                val node = queue.removeAt(1)

                if (node.left != null) {
                    queue.add(node.left!!)
                }

                if (node.right != null) {
                    queue.add(node.right!!)
                }

                currentLevelNodes--
            }
        }
    }


    /**
     * Inserts a Tree node into this Binary Search Tree
     */
    override fun insertTreeNode(data: T): BinaryTreeNode<T>? {
        if (this.root == null) {
            return BinaryTreeNode(data)
        }

        var parent = this.root
        val dummy = this.root

        while (this.root != null) {
            parent = this.root

            if (data != null) {
                if (data < this.root!!.data) {
                    this.root = this.root!!.left
                } else {
                    this.root = this.root!!.right
                }
            }
        }

        when {
            parent != null -> {
                parent = BinaryTreeNode<T>(data)
            }

            data < parent?.data -> {
                parent?.left = BinaryTreeNode<T>(data)
            }

            else -> {
                parent?.right = BinaryTreeNode<T>(data)
            }
        }
        return dummy
    }

    override fun mergeTree(otherTree: TreeNode<T>?): TreeNode<T>? {

        fun mergeTreeHelper(root: BinaryTreeNode<T>?, otherTreeRoot: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
            val thisRoot = root ?: this.root ?: return otherTreeRoot

            if (otherTreeRoot == null) {
                return root
            }

            // assumption is that data is an integer
            thisRoot.data.plusAssign(otherTreeRoot.data as Int)
            thisRoot.left = mergeTreeHelper(thisRoot.left, otherTreeRoot.left)
            thisRoot.right = mergeTreeHelper(thisRoot.right, otherTreeRoot.right)

            return root
        }

        return mergeTreeHelper(this.root, otherTree as BinaryTreeNode<T>)
    }

    override fun inorderTraversalIteratively(): Collection<T> {
        val stack = arrayListOf<BinaryTreeNode<T>>()
        val result = arrayListOf<T>()
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

    override fun inorderMorrisTraversal(): Collection<T> {
        val result = arrayListOf<T>()
        var current = root
        var pre: BinaryTreeNode<T>?

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

    override fun preorderTraversal(): Collection<T> {
        val result = arrayListOf<T>()
        val stack = arrayListOf<BinaryTreeNode<T>>()

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

    override fun postorderTraversal(): Collection<T> {
        val values = arrayListOf<T>()
        val stackOne = arrayListOf<BinaryTreeNode<T>>()
        val stackTwo = arrayListOf<BinaryTreeNode<T>>()

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

    /**
     * LowestCommonAncestor returns the LCA of 2 nodes
     * Considering it is a BST, we can assume that this tree is a valid BST, we could also check for this
     * If both of the values in the 2 nodes provided are greater than the root node, then we move to the right.
     * if the nodes are less than the root node, we move to the left.
     * If there is no root node, then we exit and return Null, as no common ancestor could exist in such a case with
     * no root node.
     * Assumptions:
     * - assumes that the node itself can also be an ancestor/descendant of itself
     * Complexity Analysis:
     * Time Complexity: O(h).
     * The Time Complexity of the above solution is O(h), where h is the height of the tree.
     * Space Complexity: O(1).
     * The space complexity of the above solution is constant.
     */
    override fun lowestCommonAncestor(nodeOne: TreeNode<T>, nodeTwo: TreeNode<T>): TreeNode<T>? {
        if (root == null) {
            return null
        }

        if (root!!.data == nodeOne.data || root!!.data == nodeTwo.data) {
            return root
        }

        while (root != null) {
            root = if (root!!.data!! > nodeOne.data && root!!.data!! > nodeTwo.data) {
                root!!.left
            } else if (root!!.data!! < nodeOne.data && root!!.data!! < nodeTwo.data) {
                root!!.right
            } else {
                break
            }
        }

        return root
    }
}
