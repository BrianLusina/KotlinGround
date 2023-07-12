package com.kotlinground.puzzles.prefixsum.highestaltitude

fun largestAltitude(gain: IntArray): Int {
    var highestAltitude = 0
    var currentAltitude = 0

    for (altitudeGain in gain) {
        currentAltitude += altitudeGain
        highestAltitude = maxOf(currentAltitude, highestAltitude)
    }

    return highestAltitude
}
