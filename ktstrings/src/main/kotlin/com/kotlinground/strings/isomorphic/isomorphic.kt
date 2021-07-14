package com.kotlinground.strings.isomorphic

fun transformString(s: String): String {
    val indexMapping = HashMap<Char, Int>()
    var newString = ""

    for (i in s.indices) {
        val c1 = s[i]

        if (!indexMapping.containsKey(c1)) {
            indexMapping[c1] = i
        }

        newString += indexMapping[c1]
    }
    return newString
}

fun isIsomorphicWithTransform(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    return transformString(s) == transformString(t)
}

fun isIsomorphicWithMapping(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val mappings = mutableMapOf<Char, Char>()
    val mappedTo = mutableSetOf<Char>()

    for (x in s.indices) {
        val mapping = mappings[s[x]]

        if (mapping == null) {
            if (mappedTo.contains(t[x])) {
                return false
            }
            mappings[s[x]] = t[x]
            mappedTo.add(t[x])
        } else if (t[x] != mapping) {
            return false
        }
    }
    return true
}
