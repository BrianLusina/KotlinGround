package com.kotlinground.algorithms.backtracking.generateparenthesis

fun generateParenthesis(n: Int): List<String> {
    val stack = mutableListOf<String>()
    val result = mutableListOf<String>()

    fun backtrack(openCount: Int, closedCount: Int) {
        if (openCount == closedCount && openCount == n) {
            result.add(stack.joinToString(""))
            return
        }

        if (openCount < n) {
            stack.add("(")
            backtrack(openCount + 1, closedCount)
            stack.removeLast()
            stack.removeAt(stack.size - 1)
        }

        if (closedCount < openCount) {
            stack.add(")")
            backtrack(openCount, closedCount + 1)
            stack.removeLast()
        }
    }

    backtrack(0, 0)
    return result
}

data class PString(val str: String, val openCount: Int, val closeCount: Int)

fun generateParenthesisV2(n: Int): List<String> {
    val result = arrayListOf<String>()
    val queue = ArrayDeque<PString>()
    queue.add(PString("", 0, 0))

    while (queue.isNotEmpty()) {
        val (str, openCount, closeCount) = queue.removeFirst()

        // If we have max open and close, add result
        if (openCount == n && closeCount == n) {
            result.add(str)
        } else {
            if (openCount < n) queue.add(PString("$str(", openCount + 1, closeCount))
            if (openCount > closeCount) queue.add(PString("$str)", openCount, closeCount + 1))
        }
    }
    return result
}
