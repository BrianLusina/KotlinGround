package FunctionalProg.Triangle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TriangleFuncTests {
    @Test
    public void testArea() throws Exception {
        TrianglePojo t = new TrianglePojo(5, 10);
        assertEquals("Incorrect area returned", 25D, TriangleFuncProgram.f.applyAsDouble(t), 0.001);
        assertEquals("Incorrect area in Triangle object", 25D, t.getArea(), 0.001);
    }
}