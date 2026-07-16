package com.kotlinground.datastructures.graphs.edge

import com.kotlinground.datastructures.graphs.Vertex

/**
 * Represents a directed edge in a graph where the connection between two vertices has a direction.
 *
 * A directed edge points from a source vertex to a destination vertex. It inherits the base
 * properties and behavior of an edge, and explicitly defines its type as directed.
 *
 * @property source The source vertex where the directed edge originates.
 * @property destination The destination vertex where the directed edge points to.
 */
data class DirectedEdge<T>(val source: Vertex<T>, val destination: Vertex<T>): Edge() {
    override fun toString(): String {
        return "${super.toString()}, type=${EdgeType.DIRECTED}, source=$source, destination=$destination"
    }
}
