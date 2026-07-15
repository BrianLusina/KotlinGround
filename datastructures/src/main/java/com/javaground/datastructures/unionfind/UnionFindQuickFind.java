package com.javaground.datastructures.unionfind;

import java.util.*;

/**
 * Quick-Find implementation of Union-Find that works with generic element types.
 *
 * Elements are provided up-front to the constructor. Internally we map elements
 * to contiguous integer indices [0, n) and maintain the classic Quick-Find
 * id[] array of component identifiers. The public API works with elements of type T
 * and returns a representative element of the component for find().
 */
public class UnionFindQuickFind<T> extends UnionFind<T> {
    private int count;               // number of components
    private final int[] id;          // id[i] = component id of index i
    private final Map<T, Integer> indexOf; // element -> index
    private final List<T> elements;  // index -> element (for representative lookups)

    /**
     * Creates a new Quick-Find structure over the given collection of distinct elements.
     *
     * @throws IllegalArgumentException if elements is null, contains nulls, or has duplicates
     */
    public UnionFindQuickFind(Collection<T> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements must not be null");
        }
        this.elements = new ArrayList<>(elements.size());
        this.indexOf = new HashMap<>(elements.size() * 2);
        int i = 0;
        for (T e : elements) {
            if (e == null) {
                throw new IllegalArgumentException("elements must not contain nulls");
            }
            if (indexOf.putIfAbsent(e, i) != null) {
                throw new IllegalArgumentException("Duplicate element: " + e);
            }
            this.elements.add(e);
            i++;
        }
        this.count = this.elements.size();
        this.id = new int[this.count];
        for (int j = 0; j < this.count; j++) {
            id[j] = j; // each element is its own component initially
        }
    }

    private int indexOfOrThrow(T element) {
        Integer idx = indexOf.get(element);
        if (idx == null) {
            throw new IllegalArgumentException("Unknown element: " + element);
        }
        return idx;
    }

    /**
     * Adds a connection between p and q using Quick-Find
     */
    @Override
    public void union(T p, T q) {
        int pIdx = indexOfOrThrow(p);
        int qIdx = indexOfOrThrow(q);
        int pId = id[pIdx];
        int qId = id[qIdx];
        if (pId == qId) {
            return; // already in the same component
        }
        // Relabel all entries equal to qId to pId
        for (int i2 = 0; i2 < id.length; i2++) {
            if (id[i2] == qId) {
                id[i2] = pId;
            }
        }
        count--;
    }

    /**
     * Component identifier for p using Quick-Find. Returns a representative
     * element for p's component (the element whose index equals the component id).
     */
    @Override
    public T find(T p) {
        int idx = indexOfOrThrow(p);
        int compId = id[idx];
        return elements.get(compId);
    }

    @Override
    public Boolean connected(T p, T q) {
        return Objects.equals(find(p), find(q));
    }

    @Override
    public int count() {
        return count;
    }
}
