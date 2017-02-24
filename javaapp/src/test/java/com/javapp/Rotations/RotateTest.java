package com.javapp.Rotations;

import com.javapp.stringswords.Rotations.Rotate;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class RotateTest {
    private static void testing(Boolean actual, Boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(Rotate.containAllRots("", Collections.emptyList()), true);
        List<String> a = Arrays.asList("bsjq", "qbsj");
        testing(Rotate.containAllRots("", a), true);
        a = Arrays.asList("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs");
        testing(Rotate.containAllRots("bsjq", a), true);
        a = Arrays.asList("TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY");
        testing(Rotate.containAllRots("XjYABhR", a), false);
    }

}
