package com.kotlinground.algorithms.arrays.intersection

fun <T> setIntersection(setOne: Set<T>, setTwo: Set<T>): List<T> {
    return setOne.intersect(setTwo).toList()
}

/**
 * Returns the intersection of two arrays. Uses a set to solve the problem in linear time. A set provides in/contains
 * operation in O(1) time in average case. This converts both arrays to sets and iterates over the smallest set
 * checking the presence of each element in the other larger set. The time complexity is O(n+m) where n is the size of
 * the first array and m is the size of the second array.
 */
fun <T> intersectionOne(listOne: Array<T>, listTwo: Array<T>): List<T> {
    val setOne = listOne.toSet()
    val setTwo = listTwo.toSet()

    return if (setOne.size < setTwo.size) {
        setIntersection(setOne, setTwo)
    } else {
        setIntersection(setTwo, setOne)
    }
}

fun <T> intersectionTwo(listOne: Array<T>, listTwo: Array<T>): List<T> {
    val counter = hashMapOf<T, Int>()
    val result = arrayListOf<T>()

    listOne.forEach { counter[it] = counter.getOrDefault(it, 0) + 1 }

    listTwo.forEach {
        if (counter.containsKey(it) && counter[it]!! > 0) {
            result.add(it)
            counter[it] = counter[it]!! - 1
        }
    }

    return result
}
