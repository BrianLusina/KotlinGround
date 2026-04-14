package com.javaground.datastructures.linkedlists.singly;

import com.javaground.datastructures.linkedlists.LinkedList;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Represents a singly linked list data structure that extends the functionality
 * of the abstract {@code LinkedList} class. A singly linked list is a sequence
 * of nodes where each node points to the next node in the list, and the last node
 * points to null.
 *
 * This implementation supports generic types that must implement the {@code Comparable}
 * interface to enable comparison operations.
 *
 * @param <T> the type of elements stored in the linked list, which must extend
 *            {@code Comparable}.
 */
public class SinglyLinkedList<T extends Comparable<T>> extends LinkedList<T, SinglyLinkedListNode<T>> {
    private SinglyLinkedListNode<T> head;

    /**
     * Constructs an empty singly linked list. The list will have no initial elements
     * and the head pointer will be set to null.
     */
    public SinglyLinkedList() {}

    /**
     * Constructs a singly linked list with the specified head node. The linked list
     * will use the given node as its starting point, from which subsequent nodes
     * can be traversed.
     *
     * @param head the head node of the singly linked list, which represents the
     *             starting node of the list
     */
    public SinglyLinkedList(SinglyLinkedListNode<T> head) {
        this.head = head;
    }

    @Override
    public SinglyLinkedListNode<T> headNode() {
        return head;
    }

    @Override
    public void append(T data) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(data);
        if (this.head == null) {
            this.head = node;
            return;
        }

        var lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = node;
    }

    @Override
    public SinglyLinkedListNode<T> pop() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            SinglyLinkedListNode<T> node = head;
            head = null;
            return node;
        }

        SinglyLinkedListNode<T> prev = head;
        SinglyLinkedListNode<T> current = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        return current;
    }

    @Override
    public @NotNull Iterator<SinglyLinkedListNode<T>> iterator() {
        return null;
    }
}
