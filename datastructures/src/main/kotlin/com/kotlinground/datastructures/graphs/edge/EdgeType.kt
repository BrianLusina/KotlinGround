package com.kotlinground.datastructures.graphs.edge

/**
 * Defines the types of edges that can exist in a graph.
 *
 * UNDIRECTED: Represents a bidirectional edge where the direction between vertices does not matter.
 * DIRECTED: Represents a unidirectional edge where the direction between vertices is significant.
 * SELF: Represents an edge that connects a vertex to itself.
 * HYPER_DIRECTED: Represents a directed hyperedge that can connect multiple vertices.
 * HYPER_UNDIRECTED: Represents an undirected hyperedge that can connect multiple vertices.
 */
enum class EdgeType {
    UNDIRECTED,
    DIRECTED,
    SELF,
    HYPER_DIRECTED,
    HYPER_UNDIRECTED,
}
