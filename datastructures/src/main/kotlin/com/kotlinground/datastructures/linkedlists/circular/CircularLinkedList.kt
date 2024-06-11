package com.kotlinground.datastructures.linkedlists.circular

import com.kotlinground.datastructures.linkedlists.LinkedList

class CircularLinkedList<T>(private var head: CircularLinkedListNode<T>? = null) :
    LinkedList<CircularLinkedListNode<T>, T>(), Iterable<CircularLinkedListNode<T>> {

    override fun headNode(): CircularLinkedListNode<T>? {
        return head
    }

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

    override fun pop(): T? {
        TODO("Not yet implemented")
    }

    override fun shift(): T? {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByKey(key: String) {
        if (head != null) {
            // if the head node's key matches the key we are looking for
            if (head?.key == key) {
                // set the current pointer to the head node. This will be used to track the last node as the pointer
                // moves through the list
                var current = head
                // move through the list until we reach the pointer that points back to the head node.
                while (current?.next != head) {
                    current = current?.next
                }
                // if the head node equals the next node, that means that this linked list has a length of 1, i.e. just 1
                // node. The head node can be set to None
                if (head == head?.next) {
                    head = null
                } else {
                    // set the current pointer's next to point to the head's next
                    current?.next = head?.next
                    // set the head to now become the next node
                    head = head?.next
                }
            } else {
                // we have a situation where the head node's key is not equal to the key, therefore, we need to
                // traverse the list to find the first node whose key matches the given key. Setting current to the head
                // node acts as the pointer that we keep track of
                var current = head
                // previous pointer helps to keep track of the previous node as we traverse, it is initially set to null
                var previous: CircularLinkedListNode<T>? = null

                // we iterate through the linked list as long as the next pointer of the current is not equal to
                // the head node. This is to avoid an infinite loop as this is a circular linked list.
                while (current?.next != head) {
                    // we set the previous pointer to the current node to keep track of the node before we reset the
                    // current pointer to the next node
                    previous = current
                    // move the current pointer to the next node
                    current = current?.next
                }
                // if the current node's key is equal to the key we are searching for
                if (current?.key == key) {
                    // we set the previous node's next pointer to point to the current node's next pointer.
                    // Essentially removing the current node from the list
                    previous?.next = current.next
                    // set the current node to the current's next node
                    current = current.next
                }
            }
        }
    }

    override fun deleteNodesByKey(key: String): Collection<CircularLinkedListNode<T>> {
        TODO("Not yet implemented")
    }

    override fun deleteNode(node: CircularLinkedListNode<T>) {
        if (head != null) {
            // if the head node matches the node we are looking for
            if (head == node) {
                // set the current pointer to the head node. This will be used to track the last node as the pointer
                // moves through the list
                var current = head
                // move through the list until we reach the pointer that points back to the head node.
                while (current?.next != head) {
                    current = current?.next
                }
                // if the head node equals the next node, that means that this linked list has a length of 1, i.e. just 1
                // node. The head node can be set to None
                if (head == head?.next) {
                    head = null
                } else {
                    // set the current pointer's next to point to the head's next
                    current?.next = head?.next
                    // set the head to now become the next node
                    head = head?.next
                }
            } else {
                // we have a situation where the head node's key is not equal to the key, therefore, we need to
                // traverse the list to find the first node whose key matches the given key. Setting current to the head
                // node acts as the pointer that we keep track of
                var current = head
                // previous pointer helps to keep track of the previous node as we traverse, it is initially set to null
                var previous: CircularLinkedListNode<T>? = null

                // we iterate through the linked list as long as the next pointer of the current is not equal to
                // the head node. This is to avoid an infinite loop as this is a circular linked list.
                while (current?.next != head) {
                    // we set the previous pointer to the current node to keep track of the node before we reset the
                    // current pointer to the next node
                    previous = current
                    // move the current pointer to the next node
                    current = current?.next
                }
                // if the current node's key is equal to the key we are searching for
                if (current == node) {
                    // we set the previous node's next pointer to point to the current node's next pointer.
                    // Essentially removing the current node from the list
                    previous?.next = current.next
                    // set the current node to the current's next node
                    current = current.next
                }
            }
        }
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

    /**
     * Splits a circular linked list into two halves and returns the two halves in a tuple. If the size is 0, i.e. no
     * nodes are in this linked list, then it returns None. If the size is 1, then the first portion of the tuple, at
     * index 0 will be the head of this circular linked list, while the second portion will be None.
     */
    fun splitList(): Pair<CircularLinkedList<T>, CircularLinkedList<T>?>? {
        val size = size()
        if (size == 0) {
            return null
        }

        if (size == 1) {
            return Pair(this, null)
        }

        val mid = size / 2
        var count = 0

        var previous: CircularLinkedListNode<T>? = null
        var current = head

        while (current != null && count < mid) {
            count += 1
            previous = current
            current = current.next
        }

        previous?.next = head

        val secondList = CircularLinkedList<T>()
        while (current?.next != head) {
            secondList.append(current?.data!!)
            current = current.next
        }

        secondList.append(current?.data!!)
        return Pair(this, secondList)
    }

    override fun pairwiseSwap(): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun swapNodesAtKthAndKPlusOne(k: Int): CircularLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        var current = head
        var count = 0
        while (current != null) {
            count += 1
            current = current.next

            if (current == head) {
                break
            }
        }
        return count
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

    override fun insertAfter(
        data: T,
        key: Any
    ) {
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

    override fun pairsWithSum(target: T): Collection<Pair<CircularLinkedListNode<T>, CircularLinkedListNode<T>>> {
        TODO("Not yet implemented")
    }
}
