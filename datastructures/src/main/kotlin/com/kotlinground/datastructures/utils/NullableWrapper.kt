package com.kotlinground.datastructures.utils

/**
 * A wrapper class that makes nullable values comparable.
 * Null values are considered smaller than any non-null value.
 */
data class NullableWrapper<T : Comparable<T>>(val value: T?) : Comparable<NullableWrapper<T>> {
    override fun compareTo(other: NullableWrapper<T>): Int {
        return when {
            this.value == null && other.value == null -> 0
            this.value == null -> -1
            other.value == null -> 1
            else -> this.value.compareTo(other.value)
        }
    }

    override fun toString(): String {
        return "NullableWrapper(value=$value)"
    }
}
