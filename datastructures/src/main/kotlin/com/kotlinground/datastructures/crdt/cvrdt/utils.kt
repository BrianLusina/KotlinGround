package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.collections.immutable.persistentMapOf
import kotlinx.collections.immutable.toPersistentMap
import kotlinx.datetime.Clock

fun <T : Mergeable<T>> merge(mergables: Iterable<T>): T = mergables.reduce { left, right -> left.merge(right) }
fun <T : Mergeable<T>> merge(vararg mergeables: T): T = merge(mergeables.asIterable())

fun <T> mergeableValueOf(value: T) = MergeableValue(value, Clock.System.now())

fun <K, V> mergeableMapOf(map: Map<K, V>): MergeableMap<K, V> = MergeableMap(
    map.mapValues { (_, v) -> mergeableValueOf(v) }.toPersistentMap(),
    persistentMapOf()
)

fun <K, V> mergeableMapOf(pairs: Iterable<Pair<K, V>>): MergeableMap<K, V> = mergeableMapOf(pairs.toMap())
fun <K, V> mergeableMapOf(vararg pairs: Pair<K, V>): MergeableMap<K, V> = mergeableMapOf(pairs.asIterable())
fun <K, V> mergeableMapOf(): MergeableMap<K, V> = mergeableMapOf(mapOf())
