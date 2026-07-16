package com.kotlinground.datastructures.graphs.edge

import com.kotlinground.datastructures.graphs.Vertex

/**
 * Represents a hyperedge in a graph, a specialized type of edge that connects multiple vertices.
 *
 * A hyperedge can associate more than two vertices, and in this implementation, it is treated as
 * a directed hyperedge by default. It extends the behavior of the base Edge class.
 *
 * @property vertices A list of [Vertex] objects that the hyperedge connects.
 */
data class HyperEdge(private val vertices: List<Vertex<Any>>): Edge() {
    override fun toString(): String {
        return "${super.toString()}, type=${EdgeType.HYPER_DIRECTED}, nodes=${vertices.joinToString(", ") { it.toString() }}"
    }
}
