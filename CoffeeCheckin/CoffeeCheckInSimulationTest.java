package CoffeeCheckin;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CoffeeCheckInSimulationTest extends TestCase {
    public CoffeeCheckInSimulationTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testEmptyInput(){
        CoffeeCheckInSimulation coffeeCheck = new CoffeeCheckInSimulation("");
        assertEquals("List can not be empty", false, coffeeCheck.isListEmptyOrOne());
    }

    public void testOneInput(){
        CoffeeCheckInSimulation coffeeCheck = new CoffeeCheckInSimulation("John");
        assertEquals("List can not have one employee for the week", false, coffeeCheck.isListEmptyOrOne());
    }


}
