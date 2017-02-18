package java.DeadAnts;

import java.puzzles.DeadAnts.Deadants;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;


public class DeadantsTest extends TestCase {
    public DeadantsTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(DeadantsTest.class);
    }

    @org.junit.Test
    public void example() {
        assertEquals(0, Deadants.deadAntCount("ant ant ant ant"));
        assertEquals(0, Deadants.deadAntCount(null));
        assertEquals(2, Deadants.deadAntCount("ant anantt aantnt"));
        assertEquals(1, Deadants.deadAntCount("ant ant .... a nt"));
    }
}
