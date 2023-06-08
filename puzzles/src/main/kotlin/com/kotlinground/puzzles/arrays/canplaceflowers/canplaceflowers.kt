package com.kotlinground.puzzles.arrays.canplaceflowers

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var count = 0

    for (i in flowerbed.indices) {
        val flowerPlot = flowerbed[i]
        if (flowerPlot == 0) {
            val emptyLeftPlot = i == 0 || flowerbed[i - 1] == 0
            val emptyRightPlot = i == flowerbed.size - 1 || flowerbed[i + 1] == 0

            if (emptyRightPlot && emptyLeftPlot) {
                flowerbed[i] = 1
                count++
            }
        }
    }

    return count >= n
}

fun canPlaceFlowers2(flowerbed: IntArray, n: Int): Boolean {
    var count = 0

    for (i in flowerbed.indices) {
        val flowerPlot = flowerbed[i]
        if (flowerPlot == 0) {
            val emptyLeftPlot = i == 0 || flowerbed[i - 1] == 0
            val emptyRightPlot = i == flowerbed.size - 1 || flowerbed[i + 1] == 0

            if (emptyRightPlot && emptyLeftPlot) {
                flowerbed[i] = 1
                count++

                if (count >= n) {
                    return true
                }
            }
        }
    }

    return count >= n
}
