package com.javaground.datastructures.stack.dynamic;

import com.javaground.datastructures.stack.Stack;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class DynamicSizedStack<T> extends Stack<T> {
    private int currentSize = 0;
    @SuppressWarnings("unchecked")
    private T[] items = (T[]) new Object[1];

    @Override
    public void push(T item) {
        if (currentSize == items.length) {
            resize(2 * items.length);
        }
        items[currentSize++] = item;
    }

    @Override
    public T pop() {
        if (currentSize == 0) {
            throw new IllegalStateException("Stack underflow: empty stack");
        }
        T item = items[--currentSize];
        // Avoid loitering to help GC clear unused objects
        items[currentSize] = null;
        if (currentSize > 0 && currentSize == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public T peek() {
        if (currentSize == 0) {
            throw new IllegalStateException("Empty stack");
        }
        return items[currentSize-1];
    }

    @Override
    public Integer size() {
        return currentSize;
    }

    @Override
    public Boolean isEmpty() {
        return currentSize == 0;
    }

    private void resize(int max) {
        // Move stack to a new array of size max
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[max];
        if (currentSize >= 0) System.arraycopy(items, 0, temp, 0, currentSize);
        items = temp;
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return new DynamicSizedStackIterator();
    }

    public class DynamicSizedStackIterator implements Iterator<T> {
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
