package StringManipulation.WordSearch;


import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * WordSearch Tester.
 *
 * @author <Brian Lusina>
 * @since <pre>Aug 12, 2016</pre>
 * @version 1.0
 */
public class WordSearchTest {
    WordSearch ws = new WordSearch();
    String[] test1 = {"lemonade", "limeade", "Yoo-Hoo", "root beer", "grapeade ", "water", "Mr. Pibb"};
    String[] test1results = {"lemonade", "limeade", "grapeade "};
    String[] test2results = {"Tin + Oxygen", "lox"};
    String[] test3results = {"Empty"};

    @Test
    public void test1(){
        assertArrayEquals(test1results, ws.findWord("ade", test1));
    }

    @Test
    public void test2(){
        String[] test2 = new String[320];

        for(int i = 0; i < 320; i++){
            test2[i] = "o x";
        }

        test2[303] = "lox";
        test2[70] = "Tin + Oxygen";

        assertArrayEquals(test2results, ws.findWord("ox", test2));
    }

    @Test
    public void test3(){
        assertArrayEquals(test3results, ws.findWord("   ", test1));
    }

}
