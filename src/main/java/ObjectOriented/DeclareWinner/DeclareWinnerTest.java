package ObjectOriented.DeclareWinner;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

/** 
* DeclareWinner Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 4, 2016</pre> 
* @version 1.0 
*/ 
public class DeclareWinnerTest { 

@Test
public void testOne() throws Exception {
        assertEquals("Lew to win", "Lew", DeclareWinner.declareWinner(new DeclareWinner.Fighter("Lew", 10, 2),new DeclareWinner.Fighter("Harry", 5, 4), "Lew"));
}

    @Test
    public void testTwo() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Lew", 10, 2),new DeclareWinner.Fighter("Harry", 5, 4), "Harry"),"Harry");
    }

    @Test
    public void testThree() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Harald", 20, 5), new DeclareWinner.Fighter("Harry", 5, 4), "Harry"),"Harald");
    }

    @Test
    public void testFour() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Harald", 20, 5), new DeclareWinner.Fighter("Harry", 5, 4), "Harald"),"Harald");
    }

    @Test
    public void testFive() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Jerry", 30, 3), new DeclareWinner.Fighter("Harald", 20, 5), "Jerry"), "Harald");
    }

    @Test
    public void testSix() throws Exception{
        assertEquals(DeclareWinner.declareWinner(new DeclareWinner.Fighter("Jerry", 30, 3), new DeclareWinner.Fighter("Harald", 20, 5), "Harald"),"Harald");
    }

/*CLASS END*/
}
