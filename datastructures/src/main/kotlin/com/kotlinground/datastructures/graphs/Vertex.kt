package com.kotlinground.datastructures.graphs

import java.util.UUID

/**
 * Vertex represents a node in a Graph
 * @param data [T] Data contained in a vertex
 * @param id [UUID] ID of the vertex
 * @param properties [HashMap] Key-value pair of meta information or properties of a vertex
 */
data class Vertex<T>(
    val data: T,
    val id: String = UUID.randomUUID().toString(),
    val adjacentVertices: HashMap<String, Vertex<T>> = hashMapOf(),
    val properties: HashMap<String, Any> = hashMapOf(),
) {

    /**
     * Adds an adjacent vertex
     * @param vertex [Vertex] vertex to add as a neighbour
     */
    fun addAdjacentVertex(vertex: Vertex<T>) {
        if (!adjacentVertices.containsKey(vertex.id.toString())) {
            // add vertex to adjacent vertices if not available
            adjacentVertices[vertex.id.toString()] = vertex

            // add this as an adjacent vertex to this vertex
            vertex.addAdjacentVertex(this)
        }
    }
}
