package com.kotlinground.puzzles.graph.reorderroutes

/**
 * Reorders the edges of the directed graph represented as an adjacency list in connections such that each vertex
 * is connected and has a path to the first vertex marked with 0. n represents the number of vertices.
 *
 * Complexity:
 * n is the number of vertices/nodes
 *
 * Time Complexity: O(n)
 *     O(n) to initialize the adjacency list
 *     The dfs function visits each node once, which takes O(n) time in total. Because we have undirected edges,
 *     each edge can only be iterated twice (by nodes at the end), resulting in O(e) operations total while
 *     visiting all nodes, where e is the number of edges. Because the given graph is a tree, there are n−1
 *     undirected edges, so O(n+e)=O(n).
 *
 * Space Complexity: O(n)
 *     Building the adjacency list takes O(n) space.
 *     The recursion call stack used by dfs can have no more than n elements in the worst-case scenario.
 *      It would take up O(n) space in that case.

 * @param n [Int] number of vertices or in this case, number of cities
 * @param connections [Array] adjacency matrix for a directed graph or in this case, representation of cities
 * @return [Int] minimum number of edges to re-arrange to ensure that each vertex is directly or indirectly connected to
 * the initial vertex
 */
fun minReorder(n: Int, connections: Array<IntArray>): Int {
    var count = 0

    // Adjacency list that contains list of pairs of nodes such that adj[node] contains all the neighbours of node in the
    // form of [neighbour, sign] where neighbour is the neighbouring node and sign is the direction of the edge. If the
    // sign is 0, it's an 'artificial' edge, meaning it was added by the algorithm in order to get to this vertex, and 1
    // denotes that it's an 'original' edge, meaning that it's the original edge and no need to re-order that connection
    val adj = HashMap<Int, MutableList<List<Int>>>()

    for (connection in connections) {
        adj.computeIfAbsent(connection[0]) { ArrayList() }.add(listOf(connection[1], 1))
        adj.computeIfAbsent(connection[1]) { ArrayList() }.add(listOf(connection[0], 0))
    }

    fun dfs(node: Int, parent: Int, adj: Map<Int, MutableList<List<Int>>>) {
        if (!adj.containsKey(node)) {
            return
        }

        // iterate over all children of node(nodes that share an edge)
        // for every child, sign, check if child is equal to parent. if child is equal to parent, we will not visit it
        // again
        // if child is not equal to parent, we perform count+=sign and recursively call the dfs with node = child and
        // parent = node
        for (nei in adj[node]!!) {
            val child = nei[0]
            val sign = nei[1]
            if (child != parent) {
                count += sign
                dfs(child, node, adj)
            }
        }
    }

    dfs(0, -1, adj)
    return count
}
