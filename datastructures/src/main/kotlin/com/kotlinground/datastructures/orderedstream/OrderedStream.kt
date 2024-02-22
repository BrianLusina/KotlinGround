package com.kotlinground.datastructures.orderedstream

class OrderedStream(n: Int) {
    private var pointer = 0
    private val stream = Array(n) { "0" }

    fun insert(idKey: Int, value: String): List<String> {
        stream[idKey - 1] = value

        val tempList = stream.takeWhile { it != "0" }.toList()
        return tempList.drop(pointer).apply { pointer = tempList.size }
    }
}
