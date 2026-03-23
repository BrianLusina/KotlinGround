package com.kotlinground.algorithms.stack.longestvalidparentheses

fun longestValidParentheses(s: String): Int {
    // Variable to store the maximum length of valid parentheses found so far.
    var maxLength = 0

    // Stack to store indexes. We initialize it with -1 to serve as a
    // sentinel value. This handles the edge case of a valid substring
    // starting from index 0, allowing us to calculate its length correctly.
    val stack = ArrayDeque<Int>()
    stack.add(-1)

    for (currentIndex in 0 until s.length) {
        // If the character is an opening parenthesis, push its index onto the stack.
        // It represents a potential start of a valid sequence.
        if (s[currentIndex] == '(') {
            stack.add(currentIndex)
        } else {
            // Pop the top element from the stack. This is an attempt to match
            // the current ')' with a previously seen '('.
            stack.removeLast()

            // If the stack is now empty, it means the current ')' has no matching '('.
            // We push the current index to act as a new "base" or starting point
            // for the next potential valid substring.
            if (stack.isEmpty()) {
                stack.add(currentIndex)
            } else {
                // The new top of the stack holds the index of the character just *before*
                // the start of the current valid substring. The length is the difference
                // between the current index and that "base" index.
                val currentLength = currentIndex - stack.last()

                // Update the overall maximum length if the current one is greater.
                maxLength = maxOf(maxLength, currentLength)
            }
        }
    }
    return maxLength
}
