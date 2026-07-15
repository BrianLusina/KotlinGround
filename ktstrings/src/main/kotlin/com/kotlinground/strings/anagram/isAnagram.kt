package com.kotlinground.strings.anagram

/**
 * Checks to see if s is an anagram of t.
 */
fun isAnagram(s: String, t: String): Boolean {
    // first normalize the strings by removing white spaces which might result in uneven lengths if s1 and s2 are
    // anagrams of each other
    val s1 = s.replace(" ", "").lowercase()
    val s2 = t.replace(" ", "").lowercase()

    if (s1.length != s2.length) {
        return false
    }
    // This map is used to keep track of the character count in the strings to check if the strings are anagrams
    // of each other, the character count must be equal in both strings. This enables the algorithm to keep track of
    // this count.
    val map = mutableMapOf<Char, Int>()

    // Loop through each character in the first string to count the number of characters and store them in the map
    // this is linear, so, O(n) where n is the number of characters in the string as the loop has to iterate over each
    // character
    for (char in s1) {
        map[char] = map[char]?.plus(1) ?: 1
    }

    // Loops through each character in the second string checking for the existence of that character in the already
    // populated map. If a character, exists, the count is decremented, if not, the count is incremented. This
    // will be used to show the discrepancy in character count between the two strings
    for (char in s2) {
        if (map.containsKey(char)) {
            map[char] = map[char]?.minus(1) ?: 1
        } else {
            map[char] = 1
        }
    }

    // Finally, check each key in the map. If a given key's count is not equal to 0, then the algorithm exits
    // early as it's not possible to have a character count of more than 0 for strings that are anagrams, since the above
    // loop should have reduced the character count to 0. This shows a discrepancy, meaning there is an extra character
    // in a string that is not in another string
    for ((_, count) in map) {
        if (count != 0) {
            return false
        }
    }

    return true
}
