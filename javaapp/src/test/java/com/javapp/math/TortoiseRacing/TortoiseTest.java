package com.javapp.math.TortoiseRacing;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TortoiseTest {
    @Test
    public void testRaceOne() throws Exception {
        assertArrayEquals(new int[]{0, 32, 18}, Tortoise.race(720, 850, 70));

    }

    @Test
    public void testRaceTwo() throws Exception{
        assertArrayEquals(new int[]{3, 21, 49}, Tortoise.race(80, 91, 37));
    }

    @Test
    public void testRaceThree() throws Exception{
        assertArrayEquals(new int[]{2, 0, 0}, Tortoise.race(80, 100, 40));
    }

}
