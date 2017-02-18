package java.cryptography.SimpleCipher;

import org.junit.Test;

import java.cryptography.SimpleCipher.Cipher;

public class IncorrectKeyCipherTest {

    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithAllCapsKey() {
        new Cipher("ABCDEF");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithAnyCapsKey() {
        new Cipher("abcdEFg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithNumericKey() {
        new Cipher("12345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithAnyNumericKey() {
        new Cipher("abcd345ef");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cipherThrowsWithEmptyKey() {
        new Cipher("");
    }
}
