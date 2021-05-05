package com.kotlinground.algorithms.onlinestockspan

class StockSpanner(private val stack: ArrayList<IntArray> = arrayListOf()) {

    fun next(price: Int): Int {
        var weight = 1

        while (stack.isNotEmpty() && stack[stack.size - 1][0] <= price) {
            weight += stack[stack.size - 1][1]
            stack.removeAt(stack.size - 1)
        }

        stack.add(intArrayOf(price, weight))
        return weight
    }
}
