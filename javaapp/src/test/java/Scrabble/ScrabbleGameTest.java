package java.Scrabble;

import java.puzzles.Scrabble.ScrabbleGame;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScrabbleGameTest extends TestCase {
    public ScrabbleGameTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    private String input;
    private int expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", 0},
                {" \t\n", 0},
                {null, 0},
                {"a", 1},
                {"f", 4},
                {"street", 6},
                {"quirky", 22},
                {"OXYPHENBUTAZONE", 41},
                {"alacrity", 13},
        });
    }

    public ScrabbleGameTest(String input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @org.junit.Test
    public void test() {
        ScrabbleGame scrabble = new ScrabbleGame(input);
        assertEquals(expectedOutput, scrabble.getScore());
    }    public static Test suite() {
        return new TestSuite(ScrabbleGameTest.class);
    }
}
