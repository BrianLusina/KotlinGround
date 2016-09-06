package Scrabble;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

/**
 * Package: Scrabble
 * Created by lusinabrian on 06/09/16 or 06 Sep of 2016,
 * Time: 12:25.
 * Project: JxProjects
 * Description:
 */
@RunWith(Parameterized.class)
public class ScrabbleTest {

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

    public ScrabbleTest(String input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void test() {
        ScrabbleGame scrabble = new ScrabbleGame(input);
        assertEquals(expectedOutput, scrabble.getScore());
    }

}
