package com.kotlinground.strings.palindromes

import kotlin.test.Test
import kotlin.test.assertTrue

class IsPalindromePermutationTest {
 @Test
 fun `should return true for 'Tact Coa'`() {
  val s = "Tact Coa"
  val actual = isPalindromePermutation(s)
  assertTrue(actual)
 }

 @Test
 fun `should return true for 'This is not a palindrome permutation'`() {
  val s = "This is not a palindrome permutation"
  val actual = isPalindromePermutation(s)
  assertTrue(actual)
 }

 @Test
 fun `should return true for 'taco cat'`() {
  val s = "taco cat"
  val actual = isPalindromePermutation(s)
  assertTrue(actual)
 }
}
