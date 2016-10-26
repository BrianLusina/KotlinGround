package HelloWorld.src.test.java;

import HelloWorld.src.main.java.HelloWorld;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void helloNoName() {
        assertEquals("Hello, World!", HelloWorld.hello(""));
        assertEquals("Hello, World!", HelloWorld.hello(null));
    }

    @Test
    public void helloSampleName() {
        assertEquals("Hello, Alice!", HelloWorld.hello("Alice"));
    }

    @Test
    public void helloAnotherSampleName() {
        assertEquals("Hello, Bob!", HelloWorld.hello("Bob"));
    }
}
