package com.javapp.stringswords.RNATranscription;

import junit.framework.TestCase;

import org.junit.Assert;

public class RnaTranscriptionTest extends TestCase {

  public RnaTranscriptionTest(String name) {
    super(name);
  }

  public void setUp() throws Exception {
    super.setUp();
  }

  public void tearDown() throws Exception {
    super.tearDown();
  }

  @org.junit.Test
  public void testRnaTranscriptionOfEmptyDnaIsEmptyRna() {
    Assert.assertEquals("", RnaTranscription.ofDna(""));
  }

  @org.junit.Test
  public void testRnaTranscriptionOfCytosineIsGuanine() {
    Assert.assertEquals("G", RnaTranscription.ofDna("C"));
  }

  @org.junit.Test
  public void testRnaTranscriptionOfGuanineIsCytosine() {
    Assert.assertEquals("C", RnaTranscription.ofDna("G"));
  }

  @org.junit.Test
  public void testRnaTranscriptionOfThymineIsAdenine() {
    Assert.assertEquals("A", RnaTranscription.ofDna("T"));
  }

  @org.junit.Test
  public void testRnaTranscriptionOfAdenineIsUracil() {
    Assert.assertEquals("U", RnaTranscription.ofDna("A"));
  }

  @org.junit.Test
  public void testRnaTranscription() {
    Assert.assertEquals("UGCACCAGAAUU", RnaTranscription.ofDna("ACGTGGTCTTAA"));
  }
}
