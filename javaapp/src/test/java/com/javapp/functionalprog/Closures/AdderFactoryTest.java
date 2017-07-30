package com.javapp.functionalprog.Closures;

import junit.framework.TestCase;

public class AdderFactoryTest extends TestCase {

  public AdderFactoryTest(String name) {
    super(name);
  }

  public void setUp() throws Exception {
    super.setUp();
  }

  public void tearDown() throws Exception {
    super.tearDown();
  }

  @org.junit.Test
  public void testMakeFunction() throws Exception {
    assertEquals("Created add 1 function; gave it 4; did not get 5 back",
        5, AdderFactory.create(1).applyAsInt(4));
  }

}
