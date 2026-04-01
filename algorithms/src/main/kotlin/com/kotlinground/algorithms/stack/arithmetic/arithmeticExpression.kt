package com.kotlinground.algorithms.stack.arithmetic

/**
 * Evaluates a mathematical expression represented as a string containing
 * numbers, operators, and parentheses. The function assumes the expression
 * is properly formatted and returns the computed result as a Double.
 *
 * @param expression the mathematical expression to be evaluated, containing digits, operators (+, -, *, /), and parentheses.
 * @return the result of evaluating the given mathematical expression.
 */
fun evaluate(expression: String): Int {
    if (expression.isEmpty()) return 0

    val valuesStack = ArrayDeque<Int>()
    val operatorStack = ArrayDeque<Char>()
    for (char in expression) {
        when (char) {
            '(' -> continue
            '+' -> operatorStack.add(char)
            '-' -> operatorStack.add(char)
            '*' -> operatorStack.add(char)
            '/' -> operatorStack.add(char)
            ')' -> {
                val operator = operatorStack.removeLast()
                var value = valuesStack.removeLast()
                when (operator) {
                    '+' -> value = valuesStack.removeLast() + value
                    '-' -> value = valuesStack.removeLast() - value
                    '*' -> value = valuesStack.removeLast() * value
                    '/' -> value = valuesStack.removeLast() / value
                }
                valuesStack.add(value)
            }
            else -> valuesStack.add(char.toString().toInt())
        }
    }
    return valuesStack.removeLast()
}
