package test.main.java.Primefactors;
import junit.framework.TestCase;
import main.java.Primefactors.PrimeFactors;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PrimeFactorsTest extends TestCase {
    public PrimeFactorsTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetForNumber() throws Exception {
        //TODO: Test goes here...
    }
    private long input;
    private List<Long> expectedOutput;

    @Parameterized.Parameters(name="Prime factors of {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1L, Arrays.asList()},
                {2L, Arrays.asList(2L)},
                {3L, Arrays.asList(3L)},
                {4L, Arrays.asList(2L, 2L)},
                {6L, Arrays.asList(2L, 3L)},
                {8L, Arrays.asList(2L, 2L, 2L)},
                {9L, Arrays.asList(3L, 3L)},
                {27L, Arrays.asList(3L, 3L, 3L)},
                {625L, Arrays.asList(5L, 5L, 5L, 5L)},
                {901255L, Arrays.asList(5L, 17L, 23L, 461L)},
                {93819012551L, Arrays.asList(11L, 9539L, 894119L)}
        });
    }

    public PrimeFactorsTest(long input, List<Long> expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @org.junit.Test
    public void test() {
        assertEquals(expectedOutput, PrimeFactors.getForNumber(input));
    }
}
