package com.kotlinground.datastructures.randomizedset

class RandomizedSet<T> {
    // map is used to store the key value pairs where the key is the value in the set and the value is the index of
    // the value in the data list
    private val map = hashMapOf<T, Int>()
    private val data = arrayListOf<T>()

    /**
     * Inserts an item into the set if not present. Returns true if the item was not present, false otherwise
     */
    fun insert(item: T): Boolean {
        if (map.containsKey(item)) {
            return false
        }

        // add the element to the dictionary. Setting the value as the
        // length of the list will accurately point to the index of the
        // new element. (len(some_list) is equal to the index of the last item +1)
        map[item] = data.size
        data.add(item)
        return true
    }

    /**
     * Removes an item val from the set if present. Returns true if the item was present, false otherwise.
     */
    fun remove(item: T): Boolean {
        if (!map.containsKey(item)) {
            return false
        }

        // essentially, we're going to move the last element in the list into the location of the element we want to
        // remove. This is a significantly more efficient operation than the obvious solution of removing the item and
        // shifting the values of every item in the dictionary to match their new position in the list
        val index = map.getValue(item)
        val lastElement = data.last()

        map[lastElement] = index

        data[index] = lastElement
        data.removeLast()

        map.remove(item)
        return true
    }

    /**
     * Returns a random element from the current set of elements. Each element must have the same probability of being
     * returned.
     *
     */
    fun getRandom(): T {
        if (map.isEmpty()) {
            throw Exception("RandomizedSet is empty")
        }

        return data.random()
    }
}
