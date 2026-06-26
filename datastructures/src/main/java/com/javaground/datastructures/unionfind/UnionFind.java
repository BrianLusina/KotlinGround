package com.javaground.datastructures.unionfind;

/**
 * Abstract class representing a Union-Find data structure (also known as Disjoint Set Union).
 * This data structure is used to track a set of elements partitioned into a number of disjoint subsets.
 * It supports efficient operations for union, find, and checking connectivity between elements.
 *
 * @param <T> The type of elements handled by this Union-Find implementation.
 */
public abstract class UnionFind<T> {
    /**
     * Merges the sets containing the specified elements, p and q. After the operation, p and q
     * will belong to the same set.
     *
     * @param p the first element to be merged
     * @param q the second element to be merged
     */
    public abstract void union(T p, T q);

    /**
     * Finds the set identifier for the given element. This operation determines
     * which subset the element belongs to, typically used to check component membership
     * or connectivity between elements.
     *
     * @param p the element whose set identifier is to be found
     * @return the set identifier for the specified element
     */
    public abstract T find(T p);

    /**
     * Determines whether the two specified elements are in the same subset
     * within the Union-Find data structure. Returns true if the elements
     * are connected, meaning they belong to the same set, or false otherwise.
     *
     * @param p the first element to check for connectivity
     * @param q the second element to check for connectivity
     * @return true if the elements p and q are connected, false otherwise
     */
    public abstract Boolean connected(T p, T q);

    /**
     * Retrieves the number of disjoint sets currently maintained by the Union-Find data structure.
     * This value decreases with every successful union operation that merges two distinct sets.
     *
     * @return the number of disjoint sets currently managed by the structure
     */
    public abstract int count();
}
