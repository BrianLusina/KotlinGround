package SimpleCipher.src.test.java;

import SimpleCipher.src.test.java.IncorrectKeyCipherTest;
import SimpleCipher.src.test.java.RandomKeyCipherTest;
import SimpleCipher.src.test.java.SubstitutionCipherTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RandomKeyCipherTest.class,
        IncorrectKeyCipherTest.class,
        SubstitutionCipherTest.class
})
public class SimpleCipherTest {
}
