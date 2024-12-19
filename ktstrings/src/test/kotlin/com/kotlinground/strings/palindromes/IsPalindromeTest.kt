package com.kotlinground.strings.palindromes

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsPalindromeTest {

 @Test
 fun `should return true for anna`() {
  val s = "anna"
  val actual = isPalindrome(s)
  assertTrue(actual)
 }

 @Test
 fun `should return false for walter`() {
  val s = "walter"
  val actual = isPalindrome(s)
  assertFalse(actual)
 }

 @Test
 fun `should return true for 12321`() {
  val s = "12321"
  val actual = isPalindrome(s)
  assertTrue(actual)
 }

 @Test
 fun `should return false for 123456`() {
  val s = "123456"
  val actual = isPalindrome(s)
  assertFalse(actual)
 }

 @Test
 fun `should return true for Was it a cat I saw`() {
  val s = "Was it a cat I saw?"
  val actual = isPalindrome(s)
  assertTrue(actual)
 }

 @Test
 fun `should return true for Never odd or even`() {
  val s = "Never odd or even"
  val actual = isPalindrome(s)
  assertTrue(actual)
 }

 @Test
 fun `should return true for radar`() {
  val s = "radar"
  val actual = isPalindrome(s)
  assertTrue(actual)
 }

 @Test
 fun `should return true for Live on time, emit no evil`() {
  val s = "Live on time, emit no evil"
  val actual = isPalindrome(s)
  assertTrue(actual)
 }

}
