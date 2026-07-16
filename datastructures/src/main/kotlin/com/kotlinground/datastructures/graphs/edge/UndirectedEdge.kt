package com.kotlinground.datastructures.graphs.edge

import com.kotlinground.datastructures.graphs.Vertex

/**
 * Represents an undirected edge in a graph where the connection between two vertices
 * has no direction. The relationship is bidirectional, meaning both vertices are
 * connected to each other.
 *
 * This class specializes the base behavior of an edge and explicitly defines its type
 * as undirected.
 *
 * @property nodeOne The first vertex connected by this edge.
 * @property nodeTwo The second vertex connected by this edge.
 */
data class UndirectedEdge(private val nodeOne: Vertex<Any>, private val nodeTwo: Vertex<Any>): Edge() {
    override fun toString(): String {
        return "${super.toString()}, type=${EdgeType.UNDIRECTED}, nodeOne=$nodeOne, nodeTwo=$nodeTwo"
    }
}
