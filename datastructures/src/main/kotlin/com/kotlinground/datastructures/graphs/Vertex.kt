package com.kotlinground.datastructures.graphs

import com.kotlinground.datastructures.graphs.edge.DirectedEdge
import com.kotlinground.datastructures.graphs.edge.Edge
import com.kotlinground.datastructures.graphs.edge.EdgeType
import com.kotlinground.datastructures.graphs.edge.SelfEdge
import com.kotlinground.datastructures.graphs.edge.UndirectedEdge
import java.util.UUID

/**
 * Represents a vertex in a graph with generic data and various associated properties.
 *
 * @param T The type of data stored in the vertex.
 * @property data The data associated with the vertex.
 * @property id The unique identifier for the vertex. Defaults to a randomly generated UUID.
 * @property adjacentVertices A map of adjacent vertices, where the key is the ID of the vertex, and the value is the vertex itself.
 * @property properties A set of properties associated with the vertex, stored as key-value pairs.
 * @property edges The set of edges associated with this vertex.
 */
data class Vertex<T>(
    val data: T,
    val id: String = UUID.randomUUID().toString(),
    val adjacentVertices: HashMap<String, Vertex<T>> = hashMapOf(),
    val properties: HashMap<String, Any> = hashMapOf(),
    val edges: MutableSet<Edge> = mutableSetOf()
) {

    /**
     * Adds an adjacent vertex
     * @param vertex [Vertex] vertex to add as a neighbour
     */
    fun addAdjacentVertex(vertex: Vertex<T>) {
        if (!adjacentVertices.containsKey(vertex.id)) {
            // add vertex to adjacent vertices if not available
            adjacentVertices[vertex.id] = vertex

            // add this as an adjacent vertex to this vertex
            vertex.addAdjacentVertex(this)
        }
    }

    /**
     * Adds an edge to this vertex.
     * @param edge [Edge] edge to add
     */
    fun addEdge(edge: Edge) {
        edges.add(edge)
    }

    /**
     * Retrieves a list of all vertices directly connected to this vertex.
     *
     * @return A list of adjacent vertices of type [Vertex] connected to this vertex.
     */
    fun neighbors(): List<Vertex<T>> {
        return adjacentVertices.values.toList()
    }

    /**
     * Returns the incoming edges to this vertex (directed edges where this vertex is the destination).
     *
     * @return A set of incoming [DirectedEdge] edges.
     */
    fun incomingEdges(): Set<Edge> {
        return edges.filterIsInstance<DirectedEdge>()
            .filter { it.destination == this }
            .toSet()
    }

    /**
     * Returns the outgoing edges from this vertex (directed edges where this vertex is the source).
     *
     * @return A set of outgoing [DirectedEdge] edges.
     */
    fun outgoingEdges(): Set<Edge> {
        return edges.filterIsInstance<DirectedEdge>()
            .filter { it.source == this }
            .toSet()
    }

    /**
     * Returns the self-loop edges (edges that point back to this vertex).
     *
     * @return A set of [SelfEdge] edges.
     */
    fun selfEdges(): Set<Edge> {
        return edges.filterIsInstance<SelfEdge>().toSet()
    }

    /**
     * Returns the undirected edges associated with this vertex.
     *
     * @return A set of [UndirectedEdge] edges.
     */
    fun undirectedEdges(): Set<Edge> {
        return edges.filterIsInstance<UndirectedEdge>().toSet()
    }

    /**
     * Returns the in-degree of this vertex (number of incoming directed edges).
     *
     * @return The in-degree count.
     */
    fun inDegree(): Int {
        return incomingEdges().size
    }

    /**
     * Returns the out-degree of this vertex (number of outgoing directed edges).
     *
     * @return The out-degree count.
     */
    fun outDegree(): Int {
        return outgoingEdges().size
    }

    /**
     * Returns the set of edge types present on this vertex.
     *
     * @return A set of [EdgeType] values representing the types of edges associated with this vertex.
     */
    fun edgeTypes(): Set<EdgeType> {
        return edges.map { edge ->
            when (edge) {
                is DirectedEdge -> EdgeType.DIRECTED
                is UndirectedEdge -> EdgeType.UNDIRECTED
                is SelfEdge -> EdgeType.SELF
                else -> EdgeType.HYPER_DIRECTED
            }
        }.toSet()
    }

    /**
     * Returns whether this vertex has any self-loop edges.
     *
     * @return true if there is at least one self-loop edge.
     */
    fun hasSelfLoop(): Boolean {
        return selfEdges().isNotEmpty()
    }
}
