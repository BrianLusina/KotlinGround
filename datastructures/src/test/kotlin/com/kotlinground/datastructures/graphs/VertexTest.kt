package com.kotlinground.datastructures.graphs

import com.kotlinground.datastructures.graphs.edge.DirectedEdge
import com.kotlinground.datastructures.graphs.edge.EdgeType
import com.kotlinground.datastructures.graphs.edge.SelfEdge
import com.kotlinground.datastructures.graphs.edge.UndirectedEdge
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

    @Test
    fun `should not recurse when connected vertices with edges are used in a HashSet`() {
        val a = Vertex(1)
        val b = Vertex(2)
        a.addAdjacentVertex(b)

        val edge = DirectedEdge(a, b)
        a.addEdge(edge)
        b.addEdge(edge)

        // Prior to id-based equality this threw StackOverflowError via the vertex<->edge cycle.
        val set = hashSetOf(a, b)
        assertEquals(2, set.size)
        assertTrue(set.contains(a))
        assertTrue(set.contains(b))
    }

    @Test
    fun `vertices are equal when they share the same id regardless of data or edges`() {
        val id = UUID.randomUUID().toString()
        val one = Vertex(1, id = id)
        val two = Vertex(999, id = id)
        two.addEdge(SelfEdge(two))

        assertEquals(one, two)
        assertEquals(one.hashCode(), two.hashCode())

        val different = Vertex(1)
        assertNotEquals(one, different)
    }

    @Test
    fun `should report incoming and outgoing edges with in and out degrees`() {
        val a = Vertex(1)
        val b = Vertex(2)
        val c = Vertex(3)

        val aToB = DirectedEdge(a, b)
        val cToB = DirectedEdge(c, b)
        val bToC = DirectedEdge(b, c)

        listOf(aToB, cToB, bToC).forEach { edge ->
            edge.source.addEdge(edge)
            edge.destination.addEdge(edge)
        }

        assertEquals(setOf(aToB, cToB), b.incomingEdges())
        assertEquals(setOf(bToC), b.outgoingEdges())
        assertEquals(2, b.inDegree())
        assertEquals(1, b.outDegree())

        assertTrue(a.isSource())
        assertEquals(setOf(bToC), c.incomingEdges())
        assertFalse(b.isSource())
        assertFalse(b.isSink())
    }

    @Test
    fun `self loop counts twice towards degree`() {
        val a = Vertex(1)
        a.addEdge(SelfEdge(a))

        assertTrue(a.hasSelfLoop())
        assertEquals(1, a.selfEdges().size)
        assertEquals(2, a.degree())
    }

    @Test
    fun `degree combines undirected directed and self edges`() {
        val a = Vertex(1)
        val b = Vertex(2)
        val c = Vertex(3)

        val undirected = UndirectedEdge(a, b)
        val directedOut = DirectedEdge(a, c)
        val directedIn = DirectedEdge(c, a)
        val self = SelfEdge(a)

        listOf(undirected, directedOut, directedIn, self).forEach { a.addEdge(it) }

        // 1 undirected + 1 out + 1 in + (2 * 1 self) = 5
        assertEquals(5, a.degree())
    }

    @Test
    fun `should report the set of edge types present`() {
        val a = Vertex(1)
        val b = Vertex(2)

        a.addEdge(DirectedEdge(a, b))
        a.addEdge(UndirectedEdge(a, b))
        a.addEdge(SelfEdge(a))

        assertEquals(setOf(EdgeType.DIRECTED, EdgeType.UNDIRECTED, EdgeType.SELF), a.edgeTypes())
    }

    @Test
    fun `hasEdgeTo detects directed and undirected connectivity`() {
        val a = Vertex(1)
        val b = Vertex(2)
        val c = Vertex(3)

        a.addEdge(DirectedEdge(a, b))
        a.addEdge(UndirectedEdge(a, c))

        assertTrue(a.hasEdgeTo(b))
        assertTrue(a.hasEdgeTo(c))
        assertFalse(a.hasEdgeTo(Vertex(4)))
    }
}
