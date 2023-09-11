package com.kotlinground.puzzles.graph.canvisitallrooms

import java.util.Stack

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    // starting node is 0. Note that this is the index in the rooms. Here it denotes the starting vertex.
    val startingVertex = 0

    // all vertices awaiting processing
    // Space complexity is O(n) where we keep track of vertices awaiting processing, where n is the number of vertices
    // in the graph
    val queue = Stack<Int>()
    queue.push(startingVertex)

    // keep track of all visited nodes.
    // Space complexity is O(n) where is is all the vertices in the graph
    val visitedNodes = hashMapOf(startingVertex to true)

    while (queue.isNotEmpty()) {
        // dequeue the vertex from the queue
        val vertex = queue.pop()

        // get all the vertex adjacent neighbors, i.e. rooms we can visit from current room
        val neighbours = rooms[vertex]

        // for each neighbour
        for (neighbour in neighbours) {
            // check if we haven't visited this room
            if (!visitedNodes.getOrDefault(neighbour, false)) {
                // add that we have visited this node
                visitedNodes[neighbour] = true
                // add it for processing
                queue.push(neighbour)
            }
        }
    }

    // At this point, the length of visited nodes should equal to the initial length of rooms. if the length is not
    // equal it means it is not possible to visit all the rooms from the starting room
    return visitedNodes.size == rooms.size
}