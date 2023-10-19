package com.kotlinground.puzzles.search.binarysearch.successfulpairsspellspotions

import java.util.TreeMap
import java.util.Arrays

fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    // O(mlogm) operation to sort potions
    Arrays.sort(potions)

    val treeMap = TreeMap<Long, Int>()
    treeMap[Long.MAX_VALUE] = potions.size

    for (i in potions.size - 1 downTo 0) {
        treeMap[potions[i].toLong()] = i
    }

    for (i in spells.indices) {
        val need = (success + spells[i] - 1) / spells[i]
        spells[i] = potions.size - treeMap.ceilingEntry(need).value
    }
    return spells
}

fun successfulPairs2(spells: IntArray, potions: IntArray, success: Long): IntArray {

    /**
     * This retrieves the first position of a potion which if multiplied with a spell returns at least the give strength
     * @param [IntArray] sortedPotions int array of sported potions
     * @param [Long] target the target to find, i.e. success
     * @param [Int] currentSpell, the current spell that we are iterating through
     */
    val validPos = fun(sortedPotions: IntArray, target: Long, currentSpell: Int): Int {
        val potionNeeded = (target + currentSpell - 1) / currentSpell
        var left = 0
        var right = sortedPotions.size

        while (left < right) {
            val middle = left + (right - left) / 2
            if (sortedPotions[middle] >= potionNeeded) {
                right = middle
            } else {
                left = middle + 1
            }
        }

        return left
    }

    Arrays.sort(potions)
    val result = IntArray(spells.size)

    for (i in spells.indices) {
        val count = potions.size - validPos(potions, success, spells[i])
        result[i] = count
    }
    return result
}
