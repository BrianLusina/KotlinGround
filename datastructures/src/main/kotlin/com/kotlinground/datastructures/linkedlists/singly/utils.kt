package com.kotlinground.datastructures.linkedlists.singly

import java.util.Stack


/**
 * Returns the maximum twin sum of a node and its twin, where a node's twin is at the index (n-1-i) where n is the
 * number of nodes in the linked list.
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only
 * nodes with twins for n = 4.
 * @return: maximum twin sum of a node and it's twin
 */
fun maximumPairSum(head: SinglyLinkedListNode<Int>?): Int {
    if (head == null) {
        return 0
    }

    var current = head
    val values = arrayListOf<Int>()

    while (current != null) {
        values.add(current.data)
        current = current.next
    }

    var maximumSum = 0
    var left = 0
    var right = values.size - 1

    while (left < right) {
        maximumSum = maxOf(maximumSum, values[left] + values[right])
        left += 1
        right -= 1
    }

    return maximumSum
}

fun maximumPairSumStack(head: SinglyLinkedListNode<Int>?): Int {
    if (head == null) {
        return 0
    }

    var pointer = head
    val stack = Stack<Int>()

    while (pointer != null) {
        stack.add(pointer.data)
        pointer = pointer.next
    }

    var current = head
    var maximumSum = 0
    val size = stack.size
    var count = 1

    while (count < size / 2) {
        maximumSum = maxOf(maximumSum, current?.data!! + stack.pop())
        current = current.next
        count++
    }

    return maximumSum
}

fun maximumPairSumReverseInPlace(head: SinglyLinkedListNode<Int>?): Int {
    if (head == null) {
        return 0
    }

    var slow = head
    var fast = head

    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }

    var nextNode: SinglyLinkedListNode<Int>?
    var prev: SinglyLinkedListNode<Int>? = null

    while (slow != null) {
        nextNode = slow.next
        slow.next = prev
        prev = slow
        slow = nextNode
    }

    var maximumSum = 0
    var start = head

    while (prev != null) {
        maximumSum = maxOf(maximumSum, start?.data!! + prev.data)
        prev = prev.next
        start = start.next
    }

    return maximumSum
}
