package com.javaground.datastructures.stack.fixed;

import com.javaground.datastructures.stack.Stack;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * A fixed-size stack implementation that extends the abstract Stack class.
 * This implementation uses a pre-allocated array to store elements, ensuring
 * the stack has a set maximum capacity defined at the time of its creation.
 *
 * <p>Improvements:
 * <ul>
 *   <li>Correct size tracking using a {@code currentSize} counter</li>
 *   <li>Bounds checks for overflow/underflow in {@code push}, {@code pop}, and {@code peek}</li>
 *   <li>Return top element correctly and clear popped slots to help GC</li>
 *   <li>Accurate implementations of {@code size()} and {@code isEmpty()}</li>
 * </ul>
 *
 * @param <T> the type of elements stored in the stack
 */
public class FixedSizedStack<T> extends Stack<T> {
    private int currentSize = 0;
    private final T[] items;

    @SuppressWarnings("unchecked")
    public FixedSizedStack(int maxsize) {
        if (maxsize <= 0) {
            throw new IllegalArgumentException("maxsize must be > 0, was " + maxsize);
        }
        this.items = (T[]) new Object[maxsize];
    }

    @Override
    public void push(T item) {
        if (currentSize == items.length) {
            throw new IllegalStateException("Stack overflow: capacity=" + items.length);
        }
        items[currentSize++] = item;
    }

    @Override
    public T pop() {
        if (currentSize == 0) {
            throw new IllegalStateException("Stack underflow: empty stack");
        }
        T value = items[--currentSize];
        // help GC by preventing loitering of unused items by setting them to null
        items[currentSize] = null;
        return value;
    }

    @Override
    public T peek() {
        if (currentSize == 0) {
            throw new IllegalStateException("Empty stack");
        }
        return items[currentSize - 1];
    }

    @Override
    public Integer size() {
        return currentSize;
    }

    @Override
    public Boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new FixedSizedStackIterator();
    }

    public class FixedSizedStackIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return currentSize > 0;
        }

        @Override
        public T next() {
            return items[--currentSize];
        }
    }
}
