package com.kotlinground.algorithms.slidingwindow.repeateddnasequences

fun findRepeatedDnaSequences(dnaSequence: String): List<String> {
    val toIntMap = mapOf('A' to 0, 'C' to 1, 'G' to 2, 'T' to 3)
    val encodedSequence = arrayListOf<Int>()
    for (c in dnaSequence) {
        val n = toIntMap[c] ?: throw IllegalArgumentException("Invalid DNA character: $c")
        encodedSequence.add(n)
    }

    val dnaSequenceLength = dnaSequence.length // Length of DNA sequence to check
    val dnaSequenceSubstrLength = 10

    if (dnaSequenceLength <= dnaSequenceSubstrLength) {
        return emptyList()
    }

    val baseAEncoding = 4 // Base-4 encoding
    var rollingHashValue = 0
    val output = mutableSetOf<String>() // Sets to track hashes and repeated sequences map[string]bool{}
    val seenHashes = mutableSetOf<Int>()
    var aK = 1 // Stores a^k for hash updates

    // Compute the initial hash using base-4 multiplication
    for (i in 0 until dnaSequenceSubstrLength) {
        rollingHashValue = rollingHashValue * baseAEncoding + encodedSequence[i];
        aK *= baseAEncoding; // Precompute a^k for later use in rolling hash updates
    }

    // Store the initial hash
    seenHashes.add(rollingHashValue);

    // Sliding window approach to update the hash efficiently
    for (start in 1 until dnaSequenceLength - dnaSequenceSubstrLength + 1) {
        // Remove the leftmost character and add the new rightmost character
        rollingHashValue =
            rollingHashValue * baseAEncoding -
                    encodedSequence[start - 1] * aK +
                    encodedSequence[start + dnaSequenceSubstrLength - 1]

        // If this hash has been seen_hashes before, add the corresponding substring to the output
        val found = seenHashes.contains(rollingHashValue)
        if (found) {
            val d = dnaSequence.substring(start, start + dnaSequenceSubstrLength)
            output.add(d)
        } else {
            seenHashes.add(rollingHashValue)
        }
    }

    return output.toList()
}

fun findRepeatedDnaSequencesNaive(dnaSequence: String): List<String> {
    if (dnaSequence.length <= 10) {
        return emptyList()
    }

    val resultSet = mutableSetOf<String>()
    val seen = mutableSetOf<String>()

    for (idx in 0 until dnaSequence.length-10) {
        val subsequence = dnaSequence.substring(idx, idx + 10)
        if (seen.contains(subsequence)) {
            resultSet.add(subsequence)
        } else {
            seen.add(subsequence);
        }
    }

    return resultSet.toList()
}