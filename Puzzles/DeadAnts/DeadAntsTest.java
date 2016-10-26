package Puzzles.DeadAnts;

import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DeadAntsTest {
    @Test
    public void example() {
        assertEquals(0, Deadants.deadAntCount("ant ant ant ant"));
        assertEquals(0, Deadants.deadAntCount(null));
        assertEquals(2, Deadants.deadAntCount("ant anantt aantnt"));
        assertEquals(1, Deadants.deadAntCount("ant ant .... a nt"));
    }
}
