package com.kotlinground.datastructures.sparsevector

/**
 * Represents a sparse vector, an optimization for vectors with many zero elements.
 *
 * A sparse vector is implemented via a hash map that stores only the non-zero elements,
 * with their indices specified as keys and non-zero values as values.
 *
 * @constructor Creates a SparseVector from a given integer array.
 * The input array should not be empty. Non-zero elements are stored in an internal map.
 *
 * @param values The integer array from which to construct the SparseVector.
 * Each index in the array corresponds to the index of the vector, and non-zero values
 * are recorded in the internal storage.
 *
 * @throws IllegalStateException if the values are empty
 * */
class SparseVector(private val values: IntArray) {
    // Hash map to store non-zero elements: key=index, value=element value
    val nonZeroIndexToValueMap = hashMapOf<Int, Int>()

    init {
        require(values.isNotEmpty()) { "Expected nums to be non-empty" }
        for (i in values.indices) {
            if (values[i] != 0) {
                nonZeroIndexToValueMap[i] = values[i]
            }
        }
    }

    /**
     * Calculates the dot product of this sparse vector with another sparse vector.
     *
     * @param vec The other sparse vector to compute the dot product with.
     * @return The dot product as an integer.
     */
    fun dotProduct(vec: SparseVector): Int {
        // Get references to both maps for easier manipulation
        var currentVecElements = nonZeroIndexToValueMap
        var otherVecElements = vec.nonZeroIndexToValueMap

        // Optimization: iterate through the smaller map to reduce iterations
        if (currentVecElements.size > otherVecElements.size) {
            currentVecElements = vec.nonZeroIndexToValueMap
            otherVecElements = nonZeroIndexToValueMap
        }

        // Calculate dot product by iterating through the smaller map
        return currentVecElements
            .map { it.value * otherVecElements.getOrDefault(it.key, 0) }
            .sum()
    }
}
