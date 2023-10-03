package com.kotlinground.puzzles.graph.rottingoranges

/**
 * Returns the minimum time it will take to make all oranges rotten in a grid. If this is not possible, -1 is returned
 *
 * Since we must track time, a breadth-first search approach makes the most sense, as we can track each iteration of
 * our bfs loop, and update the time before moving on to the next.
 *
 * First, we need to iterate our grid looking for rotten oranges to add to our queue. Note, if we also take the time
 * during this iteration to count the number of fresh oranges, we can save a little time in the end.
 *
 * Once we have a queue of oranges, we just need to run our BFS and update our time after we exhaust all current cells
 * in each iteration of it, and finally return the time as long as we have successfully converted all fresh oranges to
 * rotten ones.
 *
 * Time Complexity: O(m*n)
 * where m is the number of rows, and n is the number of columns. We must traverse the graph once to find all our
 * fresh/rotten oranges, and then potentially again during our BFS.
 *
 * Space Complexity: O(m*n). In the worst case, all oranges will be rotten, and our queue will be of size m*n.
 *
 * @param grid [Array] grid of oranges
 * @return [Int]  minimum number of minutes it will take to make all oranges rotten or -1 if not possible
 */
fun orangesRotting(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size

    // keep track of rotten oranges
    val queue = ArrayDeque<Pair<Int, Int>>()

    // keep track of the minimum time
    var time = 0

    // number of fresh oranges left
    var fresh = 0

    // directions in the form of x,y
    val directions = setOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            // count the number of fresh oranges
            if (grid[r][c] == 1) {
                fresh++
            }

            // add rotten orange position to queue
            if (grid[r][c] == 2) {
                queue.add(r to c)
            }
        }
    }

    // while we have a queue of rotten oranges, and there are still fresh oranges.
    while (queue.isNotEmpty() && fresh > 0) {
        for (i in 0 until queue.size) {
            // retrieve a position of a rotten orange
            val (row, col) = queue.removeFirst()

            // check the 4 adjacent oranges of this rotten orange
            for ((dr, dc) in directions) {
                val r = row + dr
                val c = col + dc

                // check the adjacent orange is in bounds and fresh
                if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1) {
                    continue
                }

                // they are fresh, therefore, it becomes rotten
                fresh--
                grid[r][c] = 2

                // add new rotten orange to the queue, we won't reach it on this iteration, as we are only iterating
                // through the rotten from the last iteration
                queue.add(r to c)
            }
        }
        // since we only looped through the rotten oranges inside the queue, and not the adjacent ones, we can increment
        // the time now, and on the next iteration we will check those adjacent ones
        time++
    }

    return if (fresh == 0) time else -1
}