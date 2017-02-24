package com.javapp.Scrabble;

import com.javapp.puzzles.Scrabble.ScrabbleGame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;

@RunWith(Parameterized.class)
public class ScrabbleGameTest{

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

    @Test
    public void test() {
        ScrabbleGame scrabble = new ScrabbleGame(input);
        assertEquals(expectedOutput, scrabble.getScore());
    }
    
}
