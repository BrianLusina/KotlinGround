package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.toPersistentMap
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class MergeableMap<K, V>(
    val map: PersistentMap<K, MergeableValue<V>>,
    val tombstones: PersistentMap<K, Instant>
) : Map<K, V>, Mergeable<MergeableMap<K, V>> {

    fun put(key: K, value: V): MergeableMap<K, V> = copy(
        map = map.put(key, mergeableValueOf(value)),
        tombstones = tombstones.remove(key)
    )

    // remove an entry
    fun remove(key: K): MergeableMap<K, V> = copy(
        map = map.remove(key),
        tombstones = tombstones.put(key, Clock.System.now())
    )

    override fun merge(incoming: MergeableMap<K, V>): MergeableMap<K, V> {
        // first we need all the tombstones and all the keys merged
        val allTombstones = mergeTombstones(incoming.tombstones)
        val allKeys = (map.keys + incoming.map.keys)

        val elements = mutableMapOf<K, MergeableValue<V>>()

        // here we build up the elements map 1-by-1

        allKeys.forEach {
            val (left, right) = map[it] to incoming.map[it]

            // we determine which value should be placed in the map
            val winner = when {
                left != null && right == null -> left
                left == null && right != null -> right
                else -> left!!.merge(right!!) // here we leverage the merge of the MergeableValue
            }

            when {
                // there is no matching tombstone we add the element
                !allTombstones.containsKey(it) -> {
                    elements[it] = winner
                }

                // however if there is a matching tombstone we add it only if the element has a later or equal timestamp
                winner.timestamp >= allTombstones[it]!! -> {
                    allTombstones.remove(it) // in that case we need to remove the tombstone
                    elements[it] = winner
                }

                // else we don't add the element
            }
        }

        return MergeableMap(
            map = elements.toPersistentMap(),
            tombstones = allTombstones.toPersistentMap()
        )
    }

    // this helper function make sure the tombstones are merged according to the last timestamps
    private fun mergeTombstones(other: PersistentMap<K, Instant>) = (tombstones.keys + other.keys)
        .associateWith {
            maxOf(
                tombstones[it] ?: Instant.DISTANT_PAST,
                other[it] ?: Instant.DISTANT_PAST
            )
        }
        .toMutableMap()

    override val entries: Set<Map.Entry<K, V>>
        get() = TODO("Not yet implemented")

    override val keys: Set<K>
        get() = TODO("Not yet implemented")

    override val size: Int
        get() = TODO("Not yet implemented")

    override val values: Collection<V>
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: V): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsKey(key: K): Boolean {
        TODO("Not yet implemented")
    }
}
