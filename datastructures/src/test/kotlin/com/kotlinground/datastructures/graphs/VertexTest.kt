package com.kotlinground.datastructures.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class VertexTest {
    @Test
    fun `should add adjacent vertex for a vertex`() {
        val vertexId = UUID.randomUUID().toString()
        val vertex = Vertex(1, id = vertexId)

        val otherVertexId = UUID.randomUUID().toString()
        val otherVertex = Vertex(2, id = otherVertexId)

        vertex.addAdjacentVertex(otherVertex)

        val vertexNeighbour = vertex.adjacentVertices[otherVertexId]
        assertNotNull(vertexNeighbour)
        assertEquals(otherVertex, vertexNeighbour)

        val otherVertexNeighbour = otherVertex.adjacentVertices[vertexId]
        assertNotNull(otherVertexNeighbour)
        assertEquals(vertex, otherVertexNeighbour)
    }
}
