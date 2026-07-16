package com.kotlinground.datastructures.graphs

import com.kotlinground.datastructures.graphs.edge.DirectedEdge
import com.kotlinground.datastructures.graphs.edge.Edge
import com.kotlinground.datastructures.graphs.edge.EdgeType
import com.kotlinground.datastructures.graphs.edge.HyperEdge
import com.kotlinground.datastructures.graphs.edge.SelfEdge
import com.kotlinground.datastructures.graphs.edge.UndirectedEdge
import java.util.UUID

/**
 * Represents a vertex in a graph with generic data and various associated properties.
 *
 * A vertex is an *identity* object: two vertices are considered equal if and only if they share
 * the same [id]. Equality is deliberately **not** derived from the associated edges or adjacent
 * vertices — those collections form reference cycles (a vertex points at its edges, an edge
 * points back at its vertices, and adjacent vertices point at each other), so a structural
 * equals/hashCode/toString would recurse until the stack overflows.
 *
 * @param T The type of data stored in the vertex.
 * @property data The data associated with the vertex.
 * @property id The unique identifier for the vertex. Defaults to a randomly generated UUID.
 * @property adjacentVertices A map of adjacent vertices, where the key is the ID of the vertex, and the value is the vertex itself.
 * @property properties A set of properties associated with the vertex, stored as key-value pairs.
 * @property edges The set of edges associated with this vertex.
 */
class Vertex<T>(
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
     * Removes an adjacent vertex, detaching the bidirectional link between the two vertices.
     * @param vertex [Vertex] vertex to detach as a neighbour
     */
    fun removeAdjacentVertex(vertex: Vertex<T>) {
        if (adjacentVertices.containsKey(vertex.id)) {
            adjacentVertices.remove(vertex.id)
            vertex.removeAdjacentVertex(this)
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
     * Removes an edge from this vertex.
     * @param edge [Edge] edge to remove
     */
    fun removeEdge(edge: Edge) {
        edges.remove(edge)
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
        return edges.filterIsInstance<DirectedEdge<*>>()
            .filter { it.destination == this }
            .toSet()
    }

    /**
     * Returns the outgoing edges from this vertex (directed edges where this vertex is the source).
     *
     * @return A set of outgoing [DirectedEdge] edges.
     */
    fun outgoingEdges(): Set<Edge> {
        return edges.filterIsInstance<DirectedEdge<*>>()
            .filter { it.source == this }
            .toSet()
    }

    /**
     * Returns the self-loop edges (edges that point back to this vertex).
     *
     * @return A set of [SelfEdge] edges.
     */
    fun selfEdges(): Set<Edge> {
        return edges.filterIsInstance<SelfEdge<*>>().toSet()
    }

    /**
     * Returns the undirected edges associated with this vertex.
     *
     * @return A set of [UndirectedEdge] edges.
     */
    fun undirectedEdges(): Set<Edge> {
        return edges.filterIsInstance<UndirectedEdge<*>>().toSet()
    }

    /**
     * Returns the hyperedges associated with this vertex.
     *
     * @return A set of [HyperEdge] edges.
     */
    fun hyperEdges(): Set<Edge> {
        return edges.filterIsInstance<HyperEdge<*>>().toSet()
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
     * Returns the total degree of this vertex: the number of undirected edges plus the directed
     * edges incident to it, with each self-loop counted twice (the standard graph-theory
     * convention, since a self-loop contributes both an outgoing and an incoming end).
     *
     * @return The total degree count.
     */
    fun degree(): Int {
        return undirectedEdges().size + inDegree() + outDegree() + (2 * selfEdges().size)
    }

    /**
     * Returns whether this vertex is a source, i.e. it has outgoing directed edges but no
     * incoming directed edges.
     *
     * @return true if the vertex is a source.
     */
    fun isSource(): Boolean {
        return inDegree() == 0 && outDegree() > 0
    }

    /**
     * Returns whether this vertex is a sink, i.e. it has incoming directed edges but no
     * outgoing directed edges.
     *
     * @return true if the vertex is a sink.
     */
    fun isSink(): Boolean {
        return outDegree() == 0 && inDegree() > 0
    }

    /**
     * Returns whether this vertex is connected to [other] via a directed edge originating here
     * or via an undirected edge between the two vertices.
     *
     * @param other The vertex to check connectivity to.
     * @return true if such an edge exists.
     */
    fun hasEdgeTo(other: Vertex<T>): Boolean {
        val hasDirectedEdge = edges.filterIsInstance<DirectedEdge<*>>()
            .any { it.source == this && it.destination == other }
        val hasUndirectedEdge = edges.filterIsInstance<UndirectedEdge<*>>()
            .any {
                (it.nodeOne == this && it.nodeTwo == other) ||
                    (it.nodeOne == other && it.nodeTwo == this)
            }
        return hasDirectedEdge || hasUndirectedEdge
    }

    /**
     * Returns the set of edge types present on this vertex.
     *
     * @return A set of [EdgeType] values representing the types of edges associated with this vertex.
     */
    fun edgeTypes(): Set<EdgeType> {
        return edges.map { edge ->
            when (edge) {
                is DirectedEdge<*> -> EdgeType.DIRECTED
                is UndirectedEdge<*> -> EdgeType.UNDIRECTED
                is SelfEdge<*> -> EdgeType.SELF
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Vertex<*>) return false
        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String =
        "Vertex(id='$id', data=$data, properties=$properties, inDegree=${inDegree()}, outDegree=${outDegree()})"
}
