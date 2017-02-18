package test.functionalprog.Triangle;

import junit.framework.TestCase;
import main.functionalprog.Triangle.TriangleFuncProgram;
import main.functionalprog.Triangle.TrianglePojo;

public class TriangleFuncProgramTest extends TestCase {
    public TriangleFuncProgramTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
    @org.junit.Test
    public void testArea() throws Exception {
        TrianglePojo t = new TrianglePojo(5, 10);
        assertEquals("Incorrect area returned", 25D, TriangleFuncProgram.f.applyAsDouble(t), 0.001);
        assertEquals("Incorrect area in Triangle object", 25D, t.getArea(), 0.001);
    }

}
