package com.kotlinground.datastructures.crdt.cvrdt

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class MergeableMapTest {
    @Test
    fun fuzzing() {
        val keysAndValues = (0 until 1000).toList()

        val added = mutableSetOf<Int>()
        val removed = mutableSetOf<Int>()

        fun generate() = keysAndValues.fold(mergeableMapOf<Int, String>()) { acc, i ->
            when {
                Random.nextFloat() < .7 -> {
                    added.add(i)
                    acc.put(i, i.toString())
                }

                else -> acc
            }
        }

        fun remove(map: MergeableMap<Int, String>) = keysAndValues.fold(map) { acc, i ->
            when {
                Random.nextFloat() < .1 -> {
                    removed.add(i)
                    acc.remove(i)
                }

                else -> acc
            }
        }

        val merged = merge(listOf(generate(), generate(), generate()).map { remove(it) })
        val totals = added - removed
        assertEquals(totals.size, merged.keys.size)
    }
}
