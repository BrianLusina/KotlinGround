package com.kotlinground.puzzles.stack.asteroidcollision

import java.util.*
import kotlin.math.abs

fun asteroidCollision(asteroids: IntArray): IntArray {
    // used to store the final asteroid list, this results in a space complexity of O(N), where it is possible that no
    // collisions ever happens
    val stack = Stack<Int>()

    // time complexity incurred here is O(N) as we iterate over all the asteroids
    for (asteroid in asteroids) {
        var flag = true

        while (stack.isNotEmpty() && (stack.peek() > 0 && asteroid < 0)) {
            // If the top asteroid in the stack is smaller, then it will explode.
            // Hence pop it from the stack, also continue with the next asteroid in the stack.
            if (abs(stack.peek()) < abs(asteroid)) {
                stack.pop()
                continue
            } else if (abs(stack.peek()) == abs(asteroid)) {
                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                stack.pop()
            }

            // If we reach here, the current asteroid will be destroyed
            // Hence, we should not add it to the stack
            flag = false
            break
        }

        if (flag) {
            stack.push(asteroid)
        }
    }

    return stack.toIntArray()
}
