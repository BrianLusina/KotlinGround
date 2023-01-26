package com.kotlinground.puzzles.bouncing

fun bouncingBall(h: Double, bounce: Double, window: Double): Int {
    var rebounds = -1
    var newHeight = h

    if (0 < bounce && bounce < 1) {
        while (newHeight > window) {
            newHeight *= bounce
            rebounds += 2
        }
    }

    return rebounds
}
