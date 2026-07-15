package com.kotlinground.datastructures.linkedlists.singly

import java.util.ArrayList
import java.util.Stack

/**
 * This merges an arbitrary length of singly linked lists
 */
fun <T : Comparable<T>> mergeKLists(lists: ArrayList<SinglyLinkedListNode<T>?>): SinglyLinkedListNode<T>? {
    val length = lists.size

    if (lists.isEmpty()) {
        return null
    }

    if (length == 1) {
        return lists[0]
    }

    var interval = 1

    while (interval < length) {
        var index = 0

        while (index + interval < length) {
            lists[index] = mergeTwoSortedLists(lists[index], lists[index + interval])
            index += interval * 2
        }
        interval *= 2
    }

    return lists[0]
}

/**
 * Merges two sorted linked list into 1 sorted linked list. Note that the assumption here is that the 2 linked lists
 * are already sorted. If either of the heads of the linked list that is provided is None, the other head node is
 * returned instead. If both are None, then none is returned.
 *
 * Complexity:
 * Time O(n+m) where n is the number of nodes in 1 linked list while m is the number of nodes in the other linked list.
 * This is because both linked lists have to be traversed to merge into a single linked list
 *
 * Space O(n+m) where n & m are the number of nodes in the respective linked list. This is because a new linked list
 * is created from both linked lists and the nodes from each are merged into a single linke list.
 *
 * @param headOne [SinglyLinkedListNode]: optional head node of linked list one
 * @param headTwo [SinglyLinkedListNode]: optional head node of linked list two
 * @return [SinglyLinkedListNode] optional head node of merged linked list
 */
fun <T : Comparable<T>> mergeTwoSortedLists(
    headOne: SinglyLinkedListNode<T>?,
    headTwo: SinglyLinkedListNode<T>?
): SinglyLinkedListNode<T>? {
    if (headOne == null && headTwo == null) {
        return null
    }

    if (headOne == null) {
        return headTwo
    }

    if (headTwo == null) {
        return headOne
    }

    var pointerOne = headOne
    var pointerTwo = headTwo
    val mergedList: SinglyLinkedListNode<T>?

    if (pointerOne.data < pointerTwo.data) {
        mergedList = pointerOne
        pointerOne = pointerOne.next
    } else {
        mergedList = pointerTwo
        pointerTwo = pointerTwo.next
    }

    var current = mergedList

    while (pointerOne != null && pointerTwo != null) {
        if (pointerOne.data > pointerTwo.data) {
            current?.next = pointerTwo
            pointerTwo = pointerTwo.next
        } else {
            current?.next = pointerOne
            pointerOne = pointerOne.next
        }
        current = current?.next
    }

    if (pointerOne != null) {
        current?.next = pointerOne
    }

    if (pointerTwo != null) {
        current?.next = pointerTwo
    }

    return mergedList
}

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
