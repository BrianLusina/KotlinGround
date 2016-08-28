package Strings.Capitalize;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import static org.junit.Assert.assertEquals;

/** 
* Capitalize Tester. 
* 
* @author Brian Lusina
* @since <pre>Aug 24, 2016</pre>
* @version 1.0 
*/ 
public class CapitalizeTest {
    Capitalize cap = new Capitalize();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/**
* Method: capitalize(String str)
*/ 
@Test
public void test_single_word() throws Exception {
    assertEquals("Men", cap.capitalize("men"));
}

    @Test
    public void test_many_words() throws Exception{
        assertEquals("Men Men Men Menly Men Men", cap.capitalize("men men men menly men men"));
    }

    @Test
    public void test_two_words() throws Exception{
        assertEquals("I Am", cap.capitalize("i am"));
    }


} 
