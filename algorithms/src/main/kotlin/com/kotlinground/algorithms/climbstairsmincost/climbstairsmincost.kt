package com.kotlinground.algorithms.climbstairsmincost

import java.lang.Integer.min

fun minCostClimbingStairs(cost: IntArray): Int {
    /**
    Initialize two variables, downOne and downTwo, that represent the minimum cost to reach one step and two steps
    below the current step, respectively.
    We will start iteration from step 2, which means these variables will initially represent the minimum cost to
    reach steps 0 and 1 so we will initialize each of them to 0.
     */
    var downOne = 0
    var downTwo = 0

    /**
    Iterate over the array, again with 1 extra iteration at the end to treat the top floor as the final "step".
    At each iteration, simulate moving 1 step up. This means downOne will now refer to the current step, so apply our
    recurrence relation to update downOne. downTwo will be whatever downOne was prior to the update, so let's use a
    temporary variable to help with the update.
     **/
    for (i in 2..cost.size) {
        val temp = downOne
        downOne = min(downOne + cost[i - 1], downTwo + cost[i - 2])
        downTwo = temp
    }

    // In the end, since we treated the top floor as a step, downOne will refer to the minimum cost to reach the top
    // floor. Return downOne.
    return downOne
}
