package test.stringswords.Wordcount;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import main.stringswords.Wordcount.WordCount;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest extends TestCase {
    public WordCountTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }


    private final WordCount wordCount = new WordCount();

    @org.junit.Test
    public void countOneWord() {
        Map<String, Integer> actualWordCount = new HashMap<String, Integer>();
        final Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("word", 1);

        actualWordCount = wordCount.phrase("word");
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }

    @org.junit.Test
    public void countOneOfEach() {
        Map<String, Integer> actualWordCount = new HashMap<String, Integer>();
        final Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("one", 1);
        expectedWordCount.put("of", 1);
        expectedWordCount.put("each", 1);

        actualWordCount = wordCount.phrase("one of each");
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }

    @org.junit.Test
    public void countMultipleOccurences() {
        Map<String, Integer> actualWordCount = new HashMap<String, Integer>();
        final Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("one", 1);
        expectedWordCount.put("fish", 4);
        expectedWordCount.put("two", 1);
        expectedWordCount.put("red", 1);
        expectedWordCount.put("blue", 1);

        actualWordCount = wordCount.phrase("one fish two fish red fish blue fish");
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }

    @org.junit.Test
    public void ignorePunctuation() {
        Map<String, Integer> actualWordCount = new HashMap<String, Integer>();
        final Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("car", 1);
        expectedWordCount.put("carpet", 1);
        expectedWordCount.put("as", 1);
        expectedWordCount.put("java", 1);
        expectedWordCount.put("javascript", 1);

        actualWordCount = wordCount.phrase("car : carpet as java : javascript!!&@$%^&");
        assertEquals(
                expectedWordCount, actualWordCount
        );

    }

    @org.junit.Test
    public void includeNumbers() {
        Map<String, Integer> actualWordCount = new HashMap<String, Integer>();
        final Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("testing", 2);
        expectedWordCount.put("1", 1);
        expectedWordCount.put("2", 1);

        actualWordCount = wordCount.phrase("testing, 1, 2 testing");
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }

    @org.junit.Test
    public void normalizeCase() {
        Map<String, Integer> actualWordCount = new HashMap<String, Integer>();
        final Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("go", 3);

        actualWordCount = wordCount.phrase("go Go GO");
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }

    public static Test suite() {
        return new TestSuite(WordCountTest.class);
    }
}
