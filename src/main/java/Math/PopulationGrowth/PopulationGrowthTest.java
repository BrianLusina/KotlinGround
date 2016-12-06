package Math.PopulationGrowth;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.assertEquals;

/** 
* PopulationGrowth Tester. 
* 
* @author <Brian Lusina>
* @since <pre>Aug 12, 2016</pre> 
* @version 1.0 
*/ 
public class PopulationGrowthTest {
    PopulationGrowth pg = new PopulationGrowth();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: nbYear(int p0, double percent, int aug, int p) 
* 
*/ 
@Test
public void testOne() throws Exception {
    assertEquals("Expect 10", 10, pg.nbYear(1500000, 2.5, 10000, 2000000));
}

    @Test
    public void testTwo(){
        assertEquals(15, pg.nbYear(1500, 5, 100, 5000));
    }

    @Test
    public void testThree(){
        assertEquals(94, pg.nbYear(1500000, 0.25, 1000, 2000000));
    }

} 
