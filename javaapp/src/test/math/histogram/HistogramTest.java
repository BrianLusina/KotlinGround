package test.math.histogram;

import main.math.histogram.Histogram;
import org.junit.Test;
import static org.junit.Assert.*;

public class HistogramTest {
    @Test
    public void basic() {
        final String expected =
                "6|##### 5\n"+
                        "5|\n"+
                        "4|# 1\n"+
                        "3|########## 10\n"+
                        "2|### 3\n"+
                        "1|####### 7\n";
        assertEquals(expected, Histogram.histogram(new int[]{7,3,10,1,0,5}));
    }
}
