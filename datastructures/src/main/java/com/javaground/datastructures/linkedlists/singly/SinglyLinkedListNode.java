package com.javaground.datastructures.linkedlists.singly;

import com.javaground.datastructures.linkedlists.LinkedListNode;

/**
 * Represents a node in a singly linked list structure. Each node contains
 * data of a generic type and a reference to the next node in the list.
 *
 * @param <T> the generic type of the data stored in the node, which must
 *            implement the Comparable interface.
 */
public class SinglyLinkedListNode<T extends Comparable<T>> extends LinkedListNode<T> {
    public SinglyLinkedListNode<T> next = null;

    public SinglyLinkedListNode(T data) {
        super(data);
    }

    public SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next) {
        super(data, next);
    }

    public SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next, String key) {
        super(data, next, key);
    }
}
