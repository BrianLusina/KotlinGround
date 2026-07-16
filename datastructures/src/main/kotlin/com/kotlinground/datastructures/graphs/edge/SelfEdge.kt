package com.kotlinground.datastructures.graphs.edge

import com.kotlinground.datastructures.graphs.Vertex

/**
 * Represents an edge in a graph where a vertex is connected to itself.
 * Inherits the base properties and behavior of an edge.
 *
 * @constructor Creates a self-edge for the specified vertex.
 * @param node The vertex to which this edge connects itself.
 */
data class SelfEdge(val node: Vertex<Any>): Edge() {
    override fun toString(): String {
        return "${super.toString()}, type=${EdgeType.SELF} node=$node"
    }
}
