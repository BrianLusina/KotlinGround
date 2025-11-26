package com.kotlinground.datastructures.trees.binarytrees

import com.kotlinground.datastructures.queues.fifo.FifoQueue
import com.kotlinground.datastructures.trees.Tree
import com.kotlinground.datastructures.trees.TreeNode
import com.kotlinground.datastructures.trees.compareTo
import java.util.*

open class BinaryTree<T : Comparable<T>>(private var root: BinaryTreeNode<T>? = null) : Tree<T>() {

    override fun height(): Int {
        if (root == null) {
            return 0
        }

        fun heightHelper(node: BinaryTreeNode<T>?): Int {
            if (node == null) {
                return -1
            }

            val leftHeight = heightHelper(node.left)
            val rightHeight = heightHelper(node.right)
            return maxOf(leftHeight, rightHeight) + 1
        }

        return heightHelper(root)
    }

    override fun size(): Int {
        if (root == null) {
            return 0
        }

        var counter = 1
        val stack = Stack<BinaryTreeNode<T>>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val node = stack.pop()

            if (node.left != null) {
                counter += 1
                stack.push(node.left)
            }

            if (node.right != null) {
                counter += 1
                stack.push(node.right)
            }
        }

        return counter
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

    override fun delete(data: T): BinaryTreeNode<T>? {
        TODO()
    }

    override fun mergeTree(otherTree: TreeNode<T>?): TreeNode<T>? {

        operator fun <T> T.plus(data: T) {
            when (data) {
                is Int -> this as Int + data
                is Float -> this as Float + data
            }
        }

        operator fun <T> T.plusAssign(data: T) {
            this + data
        }

        fun mergeTreeHelper(root: BinaryTreeNode<T>?, otherTreeRoot: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
            val thisRoot = root ?: this.root ?: return otherTreeRoot

            if (otherTreeRoot == null) {
                return root
            }

            // assumption is that data is an integer
            thisRoot.data += otherTreeRoot.data
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

    override fun levelOrderTraversal(): Collection<T> {
        if (root == null) {
            return emptyList()
        }

        val queue = FifoQueue<BinaryTreeNode<T>>()
        queue.enqueue(root!!)

        val result = arrayListOf<T>()

        while (!queue.isEmpty) {
            val peekedNode = queue.peek()
            result.add(peekedNode.data)

            val node = queue.dequeue()

            if (node.left != null) {
                queue.enqueue(node.left!!)
            }
            if (node.right != null) {
                queue.enqueue(node.right!!)
            }
        }

        return result
    }

    override fun reverseLevelOrderTraversal(): Collection<T> {
        if (root == null) {
            return emptyList()
        }

        val fifoQueue = FifoQueue<BinaryTreeNode<T>>()
        val stack = Stack<BinaryTreeNode<T>>()

        fifoQueue.enqueue(root!!)

        val traversed = arrayListOf<T>()
        while (!fifoQueue.isEmpty) {
            val node = fifoQueue.dequeue()
            stack.push(node)

            node.right?.let {
                fifoQueue.enqueue(it)
            }

            node.left?.let {
                fifoQueue.enqueue(it)
            }
        }

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            traversed.add(node.data)
        }

        return traversed
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
            root = if (root!!.data > nodeOne.data && root!!.data > nodeTwo.data) {
                root!!.left
            } else if (root!!.data < nodeOne.data && root!!.data < nodeTwo.data) {
                root!!.right
            } else {
                break
            }
        }

        return root
    }

    override fun leafSimilar(other: Tree<T>): Boolean {
        other as BinaryTree<T>
        if ((root == null && other.root != null) || (other.root == null && root != null)) {
            return false
        }

        val leaves1 = arrayListOf<T>()
        val leaves2 = arrayListOf<T>()

        fun dfs(node: BinaryTreeNode<T>?, leafValues: ArrayList<T>) {
            if (node != null) {
                if (node.left == null && node.right == null) {
                    leafValues.add(node.data)
                }
                dfs(node.left, leafValues)
                dfs(node.right, leafValues)
            }
        }

        dfs(root, leaves1)
        dfs(other.root, leaves2)

        return leaves1.equals(leaves2)
    }

    override fun countGoodNodes(): Int {
        if (root == null) {
            return 0
        }

        // root is regarded as good
        if (root?.left == null && root?.right == null) {
            return 1
        }

        fun goodNodesHelper(node: BinaryTreeNode<T>?, data: T): Int {
            if (node != null) {
                var nodeCount = goodNodesHelper(node.left, maxOf(data, node.data)) +
                        goodNodesHelper(node.right, maxOf(data, node.data))
                if (node.data >= data) {
                    nodeCount += 1
                }
                return nodeCount
            }
            return 0
        }

        return goodNodesHelper(root, root?.data!!)
    }

    override fun pathSum(target: Int): Int {
        if (root == null) {
            return 0
        }

        var count = 0
        val sumHashMap = hashMapOf(0L to 1)

        fun countPaths(node: BinaryTreeNode<T>?, prefixSum: Long = 0L) {
            if (node == null) {
                return
            }

            val nextSum = prefixSum + node.data as Int
            count += sumHashMap[nextSum - target] ?: 0

            sumHashMap[nextSum] = (sumHashMap[nextSum] ?: 0) + 1

            countPaths(node.left, nextSum)
            countPaths(node.right, nextSum)

            sumHashMap[nextSum] = (sumHashMap[nextSum] ?: 0) - 1
        }

        countPaths(root)
        return count
    }

    override fun maxLevelSum(): Int {
        if (root == null) {
            return 0
        }

        if (root?.left == null && root?.right == null) {
            return 1
        }

        var maximumSum = Int.MIN_VALUE
        var level = 0
        var smallestLevel = 0

        val levels = LinkedList<BinaryTreeNode<T>>()
        levels.offer(root)

        while (!levels.isEmpty()) {
            level++

            var sumAtCurrentLevel = 0

            for (i in levels.size downTo 1) {
                val node = levels.poll()
                sumAtCurrentLevel += node.data as Int

                if (node.left != null) {
                    levels.offer(node.left)
                }

                if (node.right != null) {
                    levels.offer(node.right)
                }
            }

            if (sumAtCurrentLevel > maximumSum) {
                maximumSum = sumAtCurrentLevel
                smallestLevel = level
            }
        }
        return smallestLevel
    }

    override fun serialize(): String {
        val result = StringJoiner(" ")

        fun dfs(node: BinaryTreeNode<T>?) {
            if (node == null) {
                result.add("x")
                return
            }
            result.add(node.data.toString())
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        return result.toString()
    }

    override fun deserialize(tree: String): BinaryTreeNode<T>? {
        fun dfs(nodes: Iterator<String>): BinaryTreeNode<T>? {
            val data = nodes.next()
            if (data == "x") {
                return null
            }

            @Suppress("UNCHECKED_CAST")
            val current = BinaryTreeNode(data as T)
            current.left = dfs(nodes)
            current.right = dfs(nodes)
            return current
        }

        val nodeData = tree.split(" ")

        return dfs(nodeData.iterator())
    }

    override fun findKthLargest(k: Int): TreeNode<T>? {
        TODO("Not yet implemented")
    }
}

