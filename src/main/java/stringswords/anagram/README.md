## MatchAnagram

Write a program that, given a word and a list of possible anagrams, selects the correct sublist.

Given `"listen"` and a list of candidates like `"enlists" "google"
"inlets" "banana"` the program should return a list containing
`"inlets"`.

## Source

Inspired by the Extreme Startup game [https://github.com/rchatley/extreme_startup](https://github.com/rchatley/extreme_startup)

## AnagramDetection

Write a function that accepts two parameters, a parent and a child string. Determine how many times the child string - or an anagram of the child string - appears in the parent string. There is a solution which can be done in near instant time.

``` java
f('AdnBndAndBdaBn', 'dAn') // 4 ("Adn", "ndA", "dAn", "And")
f('AbrAcadAbRa', 'cAda') // 2
```
