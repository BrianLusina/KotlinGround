package com.kotlinground.puzzles.arrays.movezeroes

/**
 * Modifies the list in place by moving the non-zero elements to the front maintaining their order and the zero elements
 * to the back. This uses 2 pointers with the left & right pointers being initialized at 0 and checking the value of
 * each pointer at each iteration. It performs a swap of the values if the left and right pointers are at elements
 * that are 0 and non-zero respectively, This way, non-zero elements retain their order, while 0 elements are moved to
 * the back.
 *
 * Complexity:
 *
 * Time Complexity: O(n) as we traverse the entire list checking for non-zero elements and perform a swap with 0 elements
 * from the previous position.
 *
 * Space Complexity: O(1), only constant extra space is used, as there is no additional list used to store the elements
 */
fun moveZeroes(nums: IntArray) {
    if (nums.size == 1) {
        return
    }

    var leftPointer = 0
    for (current in nums.indices) {
        if (nums[current] != 0) {
            val temp = nums[current]
            nums[current] = nums[leftPointer]
            nums[leftPointer] = temp
            leftPointer++
        }
    }
}


/**
 * Moves zero elements to the back while maintaining the order or non-zero elements. This counts the number of 0 elements
 * in the list which is an O(n) operation where n is the size of the list, as it traverses the list from beginning to end
 *
 * Then creates an intermediate list which will contain all the non-zero elements from the original list in the same order
 * This is done by traversing the list and adding the non-zero elements to the intermediate list. This can be done in the
 * same loop as the above operation, but will still be an O(n) operation. The Space complexity will be O(n) as the non-zero
 * elements are stored in a separate list.
 *
 * Now, the zero elements are moved to the end of the intermediate list.
 *
 * Finally, we combine the result by modifying the initial list with the intermediate list
 *
 * Complexity:
 * Time: O(n)
 * Space: O(n)
 */
fun moveZeroesOne(nums: IntArray) {
    if (nums.size == 1) {
        return
    }

    var numberOfZeroes = 0
    val intermediate = arrayListOf<Int>()

    for (i in nums.indices) {
        val num = nums[i]
        if (num == 0) {
            numberOfZeroes += 1
        } else {
            intermediate.add(num)
        }
    }

    while (numberOfZeroes > 0) {
        intermediate.add(0)
        numberOfZeroes--
    }

    for (idx in nums.indices) {
        nums[idx] = intermediate[idx]
    }
}
