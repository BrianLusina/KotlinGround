package javapp.algorithms.DeclareWinner;

import com.javapp.algorithms.DeclareWinner.DeclareWinner;
import junit.framework.TestCase;


public class DeclareWinnerTest extends TestCase {
    public DeclareWinnerTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }


    @org.junit.Test
    public void testOne() throws Exception {
        assertEquals("Lew to win", "Lew", DeclareWinner.declareWinner(new DeclareWinner.Fighter("Lew", 10, 2),new DeclareWinner.Fighter("Harry", 5, 4), "Lew"));
    }

    @org.junit.Test
    public void testTwo() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Lew", 10, 2),new DeclareWinner.Fighter("Harry", 5, 4), "Harry"),"Harry");
    }

    @org.junit.Test
    public void testThree() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Harald", 20, 5), new DeclareWinner.Fighter("Harry", 5, 4), "Harry"),"Harald");
    }

    @org.junit.Test
    public void testFour() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Harald", 20, 5), new DeclareWinner.Fighter("Harry", 5, 4), "Harald"),"Harald");
    }

    @org.junit.Test
    public void testFive() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Jerry", 30, 3), new DeclareWinner.Fighter("Harald", 20, 5), "Jerry"), "Harald");
    }

    @org.junit.Test
    public void testSix() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Jerry", 30, 3), new DeclareWinner.Fighter("Harald", 20, 5), "Harald"),"Harald");
    }

}
