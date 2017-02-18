package com.javapp.WordSearch;

import com.javapp.stringswords.WordSearch.WordSearch;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.assertArrayEquals;


public class WordSearchTest extends TestCase {
    public WordSearchTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    WordSearch ws = new WordSearch();
    String[] test1 = {"lemonade", "limeade", "Yoo-Hoo", "root beer", "grapeade ", "water", "Mr. Pibb"};
    String[] test1results = {"lemonade", "limeade", "grapeade "};
    String[] test2results = {"Tin + Oxygen", "lox"};
    String[] test3results = {"Empty"};

    @org.junit.Test
    public void test1(){
        assertArrayEquals(test1results, ws.findWord("ade", test1));
    }

    @org.junit.Test
    public void test2(){
        String[] test2 = new String[320];

        for(int i = 0; i < 320; i++){
            test2[i] = "o x";
        }

        test2[303] = "lox";
        test2[70] = "Tin + Oxygen";

        assertArrayEquals(test2results, ws.findWord("ox", test2));
    }

    @org.junit.Test
    public void test3(){
        assertArrayEquals(test3results, ws.findWord("   ", test1));
    }

    public static Test suite() {
        return new TestSuite(WordSearchTest.class);
    }
}
