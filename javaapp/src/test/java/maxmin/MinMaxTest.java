package java.maxmin;

import java.datastructures.Array.maxmin.MinMax;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.assertArrayEquals;

/**
 * Package: java.java.datastructures.Array.java.maxmin
 * Created by lusinabrian on 06/09/16 or 06 Sep of 2016,
 * Time: 05:47.
 * Project: JxProjects
 * Description:
 */
public class MinMaxTest {

    Random rand;

    @Before
    public void initTest() {
        rand = new Random();
    }

    @Test
    public void testExampleCases() {
        assertArrayEquals(new int[]{1,5}, MinMax.minMax(new int[]{1,2,3,4,5}));
        assertArrayEquals(new int[]{5, 2334454}, MinMax.minMax(new int[]{2334454,5}));
        assertArrayEquals(new int[]{1, 1}, MinMax.minMax(new int[]{1}));
    }

    @Test
    public void minMaxRandomTest() {
        for(int i = 0; i < 20; i++) {
            int r = rand.nextInt();
            assertArrayEquals(new int[]{r, r}, MinMax.minMax(new int[]{r}));
        }
    }
}
