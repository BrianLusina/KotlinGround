package com.kotlinground.puzzles.graph.courseschedule

const val WHITE = 1
const val GRAY = 2
const val BLACK = 3

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val adjacencyList = hashMapOf<Int, ArrayList<Int>>()
    val color = hashMapOf<Int, Int>()

    for (prerequisite in prerequisites) {
        val destination = prerequisite[0]
        val source = prerequisite[1]
        if (adjacencyList.containsKey(source)) {
            adjacencyList[source]?.add(destination)
        } else {
            adjacencyList[source] = arrayListOf(destination)
        }
    }

    var isPossible = true

    for (i in 0 until numCourses) {
        color[i] = WHITE
    }

    fun dfs(node: Int) {
        if (!isPossible) {
            return
        }

        color[node] = GRAY

        if (adjacencyList.containsKey(node)) {
            for (neighbour in adjacencyList[node]!!) {
                if (color[neighbour] == WHITE) {
                    dfs(neighbour)
                } else if (color[neighbour] == GRAY) {
                    isPossible = false
                }
            }
        }

        color[node] = BLACK
    }

    for (i in 0 until numCourses) {
        if (color[i] == WHITE) {
            dfs(i)
        }
    }

    return isPossible
}
