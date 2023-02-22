package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.random.Random


@Serializable
class MergeableValue<T>(
    val value: T,
    val timestamp: Instant,
    val discriminant: Int = Random.nextInt()
) : Mergeable<MergeableValue<T>> {

    override fun merge(incoming: MergeableValue<T>): MergeableValue<T> = when {
        timestamp < incoming.timestamp -> incoming
        timestamp >= incoming.timestamp -> this

        // breaking the ties based on discriminant
        discriminant < incoming.discriminant -> incoming
        else -> this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class || javaClass != other.javaClass) return false

        other as MergeableValue<*>

        if (value != other.value) return false
        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
