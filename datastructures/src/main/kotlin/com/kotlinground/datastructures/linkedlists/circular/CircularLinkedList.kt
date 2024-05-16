package com.kotlinground.datastructures.linkedlists.circular

import com.kotlinground.datastructures.linkedlists.LinkedList

class CircularLinkedList<T>(private var head: CircularLinkedListNode<T>? = null) :
    LinkedList<CircularLinkedListNode<T>, T>(), Iterable<CircularLinkedListNode<T>> {

    override fun iterator(): Iterator<CircularLinkedListNode<T>> {
        return CircularLinkedListIterator(head)
    }

    /**
     * Adds a new node to the end of this linked list. To maintain circular pointers where the last node points back
     * to the head node, the pointer keeping track of the nodes as it traverses through the list checks to see if the
     * next pointer equals the head node. If it is, the pointer exists the loop, otherwise this becomes an infinite
     * loop. Once the pointer is at the end, the last node's next pointer is set to the new node and the new node's
     * next pointer is set to the head node.
     * If there is not head node, then the new node becomes the head node and it's next pointer points to itself.
     * @param data [T]: data to insert in the linked list
     */
    override fun append(data: T) {
        val newNode = CircularLinkedListNode(data)
        if (head == null) {
            head = newNode
            head?.next = head
        } else {
            var current = head
            while (current?.next != head) {
                current = current?.next
            }
            current?.next = newNode
            newNode.next = head
        }
    }

    /**
     * Adds a new data item making it the head of the circular linked list
     */
    override fun prepend(data: T) {
        val newNode = CircularLinkedListNode(data)
        var current = head
        newNode.next = head

        if (head == null) {
            newNode.next = newNode
        } else {
            while (current?.next != head) {
                current = current?.next
            }
            current?.next = newNode
        }
        head = newNode
    }

    override fun headNode(): CircularLinkedListNode<T>? {
        return head
    }

    override fun pop(): T? {
        TODO("Not yet implemented")
    }

    override fun shift(): T? {
        TODO("Not yet implemented")
    }

    override fun deleteNodeAtPosition(position: Int): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun deleteMiddle(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun findMiddleNode(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun getLast(): CircularLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun deleteFirst(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun removeLast(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun removeDuplicates(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun detectNodeWithCycle(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun hasCycle(): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeCycle(): CircularLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun reverse() {
        TODO("Not yet implemented")
    }

    override fun alternateSplit(): Pair<CircularLinkedListNode<T>, CircularLinkedListNode<T>> {
        TODO("Not yet implemented")
    }

    override fun pairwiseSwap(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun swapNodesAtKthAndKPlusOne(k: Int): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun oddEvenList(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun nthToLastNode(n: Int): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun rotate(k: Int): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun isPalindrome(): Boolean {
        TODO("Not yet implemented")
    }

    override fun moveTailToHead() {
        TODO("Not yet implemented")
    }

    override fun swapNodes(dataOne: T, dataTwo: T) {
        TODO("Not yet implemented")
    }

    override fun insertAfter(node: CircularLinkedListNode<T>, data: T) {
        TODO("Not yet implemented")
    }

    override fun insertAfter(
        nodeToInsert: CircularLinkedListNode<T>,
        currentNode: CircularLinkedListNode<T>
    ): CircularLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun insert(node: CircularLinkedListNode<T>, position: Int): CircularLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun countOccurrences(data: T): Int {
        TODO("Not yet implemented")
    }

    override fun search(node: CircularLinkedListNode<T>): CircularLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun deleteNodesByData(data: T): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByData(data: T) {
        TODO("Not yet implemented")
    }

    override fun deleteNode(node: CircularLinkedListNode<T>) {
        TODO("Not yet implemented")
    }


}