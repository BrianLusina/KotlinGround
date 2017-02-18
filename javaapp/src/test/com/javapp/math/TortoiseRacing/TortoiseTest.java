package com.javapp.math.TortoiseRacing;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class TortoiseTest extends TestCase {
    public TortoiseTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    @org.junit.Test
    public void testRaceOne() throws Exception {
        assertArrayEquals(new int[]{0, 32, 18}, Tortoise.race(720, 850, 70));

    }

    @org.junit.Test
    public void testRaceTwo() throws Exception{
        assertArrayEquals(new int[]{3, 21, 49}, Tortoise.race(80, 91, 37));
    }

    @org.junit.Test
    public void testRaceThree() throws Exception{
        assertArrayEquals(new int[]{2, 0, 0}, Tortoise.race(80, 100, 40));
    }

}
