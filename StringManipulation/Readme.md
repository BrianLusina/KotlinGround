# String Manipulation

Contains snippets that involve string manipulation.

## Phone Number
Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.

Example:
``` java
Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
```

The returned format must be correct in order to complete this challenge.
Don't forget the space after the closing parenthese!
Tags:
> ALGORITHMS, ARRAYS, STRINGS, LOOPS, CONTROL FLOW, BASIC LANGUAGE FEATURES, FUNDAMENTALS, FORMATTING, REGULAR EXPRESSIONS, DECLARATIVE PROGRAMMING, ADVANCED LANGUAGE FEATURES

## Combine String
   We are given 3 strings: str1, str2, and str3.
   Str3 is said to be a shuffle of str1 and str2 if it can be formed by interleaving the characters of str1 and str2
   in a way that maintains the left to right ordering of the characters from each string.
   For example, given str1="abc" and str2="def", str3="dabecf" is a valid shuffle since it preserves the character
    ordering of the two strings.
    So, given these 3 strings write a function that detects whether str3 is a valid shuffle of str1 and str2.

## Name That Number

  In this kata, you'll be given an integer of range 0 <= x <= 99 and have to return that number spelt out in English. A few examples:
  ```java
  nameThatNumber(4)   // returns "four"
  nameThatNumber(19)  // returns "nineteen"
  nameThatNumber(99)  // returns "ninety nine"
  ```
  Words should be seperated by only spaces and not hyphens. No need to validate parameters, they will always be in the range [0, 99]. Make sure that the returned String has no leading of trailing spaces. Good luck!
