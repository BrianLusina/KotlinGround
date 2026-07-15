package com.kotlinground.algorithms.fastandslow.circulararrayloop

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CircularArrayLoopTest: FunSpec({

    context("Circular Array Loop") {
        val inputs = listOf(
            intArrayOf(3, 1, 2) to true,
            intArrayOf(2, 1, -1, -2) to false,
            intArrayOf(-2, -1, -3) to true,
            intArrayOf(2, 1, -1, -2) to false,
            intArrayOf(3, -3, 1, 1) to true,
            intArrayOf(1, 3, -2, -4, 1) to true,
            intArrayOf(5, 4, -2, -1, 3) to false,
            intArrayOf(1, 2, -3, 3, 4, 7, 1) to true,
            intArrayOf(3, 3, 1, -1, 2) to true,
            intArrayOf(2, -1, 1, 2, 2) to true,
            intArrayOf(-1, 2) to false,
        )

        withData(inputs) { (nums, expected) ->
            val actual = circularArrayLoop(nums)
            actual shouldBe expected
        }
    }
})
