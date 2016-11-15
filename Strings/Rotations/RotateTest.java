package Strings.Rotations;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import org.junit.Test;

/**
 * Strings.Rotations
 * Created by lusinabrian on 15/11/16.
 * Description: Tests for {@link Rotate}
 */
class RotateTest {

    private static void testing(Boolean actual, Boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
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
}

