package StringManipulation.NameThatNumber;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.assertEquals;
/** 
* NameThatNumber Tester. 
* 
* @author <Brian Lusina>
* @since <pre>Aug 3, 2016</pre> 
* @version 1.0 
*/ 
public class NameThatNumberTest {
    NameThatNumber name = new NameThatNumber();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: nameThatNumber(int x) 
* 
*/ 
@Test
public void testNameThatNumber() throws Exception {
    assertEquals("10 must be supported and return \"ten\"", name.nameThatNumber(10), "ten");
    assertEquals("93 must be supported and return \"ninety three\"", name.nameThatNumber(93), "ninety three");
    assertEquals("0 must be supported and return \"zero\"", name.nameThatNumber(0), "zero");
}



} 
