package com.kotlinground.algorithms.fastandslow.circulararrayloop

/**
 * Determines if there is a cycle in a circular array.
 *
 * A cycle must have more than one element and must be in a single direction.
 * It means that the numbers involved in the cycle should either all be positive
 * or all be negative. Therefore, the cycle cannot include both positive and
 * negative numbers.
 *
 * Time Complexity:
 * The time complexity is O(n), where n is the length of the array. Each element is processed at most once.
 *
 * Space Complexity:
 * The space complexity is O(1) as no extra space is used
 * If a visited array is used to track indices visited, then this becomes an O(n) space complexity. However, this is
 * based on the assumption that the input nums list can be modified in place. If this is not allowed, then using a
 * visited array to keep track of the visited indices will be required and therefore the space complexity will become
 * O(n) where n is the size of the input nums array.
 *
 * @param nums [IntArray] the input array representing a circular array
 * @return [Boolean] true if there is a cycle in the array, false otherwise
 */
fun circularArrayLoop(nums: IntArray): Boolean {
    val length = nums.size

    for (i in 0 until length) {
        // skip as we have already seen this value
        if (nums[i] == 0) {
            continue
        }

        // determine the direction of the cycle based on the sign of the current index
        val direction = if (nums[i] > 0) 1 else -1

        // initialize the slow and fast pointers
        var slow = i
        var fast = i

        while (true) {
            // move the slow pointer one step
            // .mod simplifies handling of circular indices
            slow = (slow + nums[slow]).mod(length)

            if (nums[slow]*direction <= 0) {
                // direction changed or the slow pointer moved out of the cycle
                break
            }

            // move the fast pointer two steps

            // move it the first time
            fast = (fast + nums[fast]).mod(length)

            // check if direction changed or the fast pointer moved out of the cycle
            if (nums[fast]*direction <= 0) {
                break
            }

            // move the fast pointer a second time
            fast = (fast + nums[fast]).mod(length)
            // check if direction changed or the fast pointer moved out of the cycle
            if (nums[fast]*direction <= 0){
                break
            }

            // check if the slow and fast pointers have met
            if (slow == fast) {
                var nextSlow = (slow + nums[slow]).mod(length)

                // validate the cycle by checking if the cycle length is greater than 1
                if( slow == nextSlow) {
                    // cycle length is 1, this is not a valid cycle
                    break
                }
                return true
            }
        }

        // set all elements in the cycle to 0
        slow = i
        while (nums[slow]*direction > 0) {
            val next = (slow + nums[slow]).mod(length)
            nums[slow] = 0
            slow = next
        }
    }

    return false
}
