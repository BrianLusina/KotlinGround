package com.kotlinground.algorithms.slidingwindow.maxpointsfromcards

fun maxPointsFromCards(cards: IntArray, k: Int): Int {
    val total = cards.sum()
    val numberOfCards = cards.size

    // If the number of cards to pick is equivalent or more than the number of cards, then the maximum possible score is
    // the total
    if (k >= numberOfCards) {
        return total
    }

    // Window sum is ths state used to keep track of the sum of the current window, initially starts at 0
    var windowSum = 0
    // Start keeps track of the index to remove at the beginning of the window at each iteration
    var start = 0
    // maxPoints is the maximum points possible from picking k cards and is returned once the computation completes
    var maxPoints = 0

    for (end in 0 until numberOfCards) {
        // We add the current card to the current window
        windowSum += cards[end]

        // check if the window is of valid length
        if (end - start + 1 == numberOfCards - k) {
            // get the maximum points possible from the picked cards
            maxPoints = maxOf(maxPoints, total - windowSum)
            // Remove the element from the beginning of the window
            windowSum -= cards[start]
            // move to the next index that will be added to the window
            start += 1
        }
    }

    return maxPoints
}
