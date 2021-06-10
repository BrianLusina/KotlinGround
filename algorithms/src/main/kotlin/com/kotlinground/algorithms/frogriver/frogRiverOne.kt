package com.kotlinground.algorithms.frogJumps.frogriver

/**
 * Returns the earliest time that a frog can jump to the other side of the river.
 * Uses a Set to store unique values from leafPositions[].
 * When the size equals to endPosition, means the leaves have covered all positions from 1 to endPosition.
 * So the frog can get to the position endPosition + 1.
 * @param endPosition [Int] ]The position of the other side of the bank
 * @param leafPositions [Array] Array of the leaf positions
 * @return [Int] Earliest time that a frog can jump to the other side of the river
 */
fun timeFrogJump(endPosition: Int, leafPositions: IntArray): Int {
    val values = HashSet<Int>()

    for (time in leafPositions) {
        values.add(leafPositions[time])
        if (values.size == endPosition) {
            return time;
        }
    }

    return -1
}
