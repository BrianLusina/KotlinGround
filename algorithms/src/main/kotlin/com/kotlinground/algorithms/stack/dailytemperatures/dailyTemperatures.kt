package com.kotlinground.algorithms.stack.dailytemperatures

import java.util.Stack

/**
 * To solve this problem, we will use a Monotonic Decreasing Stack. That is a stack, where all the values inside the
 * stack, are ordered from largest, to smallest. Meaning, we only add to the stack when the stack is either:
 *
 * 1. Empty, or
 * 2. If the incoming value is smaller or equal to the value on top of the stack.
 *
 * That means that if any incoming value is larger, we must pop values off the top of the stack, until it satisfies
 * rules 1 or 2 before we can add it to our stack.
 *
 * It is during the popping phase, that we will do the majority of our work in solving our problem. By also adding the
 * indexes with the temperature to the stack, we know where they exist in our output array, and can also use the
 * indexes to gauge the relative distance in terms of days from other temperatures. So while popping them, we can
 * calculate the incoming index, i minus the popped items index, i2 and overwrite the values in our output array at
 * i2 with the difference, that is i-i2.
 *
 * Complexity Constraints:
 *
 * Time Complexity: O(n) where n is the length of the input, temperatures.
 * Space Complexity: O(n) which will be the size of our output array, and our stack in the worst case.
 */
fun dailyTemperatures(temperatures: IntArray): IntArray {
    // Here we will utilize a monotonic decreasing stack, meaning everything in the stack will be ordered from
    // 'hottest' to 'coldest', and any incoming element, 'warmer' than the top of the stack, will force us  to remove
    // the 'colder' days from the top of our stack, and calculate the difference in how many days apart they were for
    // our output array. Initialize output array of 0's the size of temperatures array. We use 0's as default, as if we
    // don't find a warmer day going forward, we are to return 0 in that position instead.
    val result = IntArray(temperatures.size) { 0 }
    val stack = Stack<Pair<Int, Int>>()

    // Loop through temperatures, tracking index, i and temperature, temp.
    for ((i, temperature) in temperatures.withIndex()) {
        // While the incoming temperature is 'warmer' than the temperature on top of the stack: We can start popping.
        // Note our stack values are formatted with tuples in the form (index, temperature).
        while (stack.size != 0 && stack.peek().second < temperature) {
            // Pop temperature, tracking its index in temperatures, idx and the temperature itself.
            val (idx, temp) = stack.pop()

            // Add to out output at the index of the popped value, the difference of the current temperature index,
            // minus popped value difference. This will be the number of days in between them.
            result[idx] = i - idx
        }

        // Once the top of the stack is either empty or no longer has days colder than the incoming temperature, we can
        // add our temperature to the stack. Again note that we are tracking index, i, and temperature, temp inside our
        // stack.
        stack.add(i to temperature)
    }

    return result
}
