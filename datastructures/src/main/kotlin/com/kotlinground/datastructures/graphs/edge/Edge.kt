package com.kotlinground.datastructures.graphs.edge

import java.util.UUID

/**
 * Represents an edge in a graph connecting two vertices.
 * @param identifier The unique identifier of the edge.
 * @param weight The weight of the edge. If null, the edge is considered unweighted.
 * @param properties The properties of the edge.
 */
abstract class Edge(
    val identifier: String = UUID.randomUUID().toString(),
    val weight: Long? = null,
    val properties: Map<String, Any?> = hashMapOf(),
) {
    override fun toString(): String {
        return "Edge(identifier='$identifier', weight=$weight, properties=$properties)"
    }

    fun isUnweighted(): Boolean {
        return weight == null
    }

    fun hasProperties(): Boolean {
        return properties.isNotEmpty()
    }

    fun hasIdentifier(): Boolean {
        return identifier.isNotEmpty()
    }
}
