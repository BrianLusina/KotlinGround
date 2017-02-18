package java.math.PopulationGrowth;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

public class PopulationGrowthTest extends TestCase {
    public PopulationGrowthTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

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
    @org.junit.Test
    public void testOne() throws Exception {
        assertEquals("Expect 10", 10, pg.nbYear(1500000, 2.5, 10000, 2000000));
    }

    @org.junit.Test
    public void testTwo(){
        assertEquals(15, pg.nbYear(1500, 5, 100, 5000));
    }

    @org.junit.Test
    public void testThree(){
        assertEquals(94, pg.nbYear(1500000, 0.25, 1000, 2000000));
    }

    public static Test suite() {
        return new TestSuite(PopulationGrowthTest.class);
    }
}
