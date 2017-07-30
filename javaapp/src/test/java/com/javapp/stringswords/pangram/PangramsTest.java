package com.javapp.stringswords.pangram;

import junit.framework.TestCase;

public class PangramsTest extends TestCase {

  public PangramsTest(String name) {
    super(name);
  }

  public void setUp() throws Exception {
    super.setUp();
  }

  public void tearDown() throws Exception {
    super.tearDown();
  }

  @org.junit.Test
  public void emptySentence() {
    assertFalse(Pangrams.isPangram(""));
  }

  @org.junit.Test
  public void testLowercasePangram() {
    assertTrue(Pangrams.isPangram("the quick brown fox jumps over the lazy dog"));
  }

  @org.junit.Test
  public void missingCharacterX() {
    assertFalse(Pangrams.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
  }

  @org.junit.Test
  public void mixedCaseAndPunctuation() {
    assertTrue(Pangrams.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
  }

  @org.junit.Test
  public void nonAsciiCharacters() {
    assertTrue(
        Pangrams.isPangram("Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich."));
  }
}
