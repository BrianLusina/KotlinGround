package com.kotlinground.puzzles.arrays.hindex

/**
 * The solution begins by sorting the array of citations in reverse order, ensuring that the papers with the highest
 * citation counts are at the beginning. Next, several conditions are checked to determine the h-index.
 *
 * First, if the array contains only one element and it is greater than zero, the h-index is 1.
 *
 * If the smallest value in the sorted array is greater than or equal to the length of the array, the h-index is equal
 * to the array length.
 *
 * Otherwise, the array is traversed, and for each index i, the value at that index is compared to i+1. If the value
 * is less than i+1, i is returned as the h-index.
 *
 * If none of the conditions are met, the h-index is 0.
 *
 * Time complexity:
 * The time complexity of the solution primarily depends on the sorting operation, which has a time complexity of
 * O(n log n), where n is the length of the input array. The subsequent iterations through the array and the condition
 *  checks have a linear time complexity of O(n). Therefore, the overall time complexity is O(n log n).
 *
 * Space complexity:
 * The solution has a space complexity of O(1) since it only uses a constant amount of extra space to store variables
 * and does not depend on the input size. No additional data structures are employed, and the sorting operation is
 * performed in-place.
 *
 * @param citations [IntArray] list of citations
 * @return [Int]
 */
fun hIndex(citations: IntArray): Int {
    val numberOfPublications = citations.size

    if (numberOfPublications == 1 && citations[0] > 0) {
        return 1
    }

    citations.sortDescending()

    if (citations[citations.size - 1] >= numberOfPublications) {
        return numberOfPublications
    }

    for ((idx, citation) in citations.withIndex()) {
        if (citation < idx + 1) {
            return idx
        }
    }

    return 0
}
