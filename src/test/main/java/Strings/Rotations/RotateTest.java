package test.main.java.Strings.Rotations;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import main.java.Strings.Rotations.Rotate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RotateTest extends TestCase {
    public RotateTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    private static void testing(Boolean actual, Boolean expected) {
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void test() {
        System.out.println("Fixed Tests containAllRots");
        testing(Rotate.containAllRots("", Collections.emptyList()), true);
        List<String> a = Arrays.asList("bsjq", "qbsj");
        testing(Rotate.containAllRots("", a), true);
        a = Arrays.asList("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs");
        testing(Rotate.containAllRots("bsjq", a), true);
        a = Arrays.asList("TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY");
        testing(Rotate.containAllRots("XjYABhR", a), false);
    }

    public static Test suite() {
        return new TestSuite(RotateTest.class);
    }
}
