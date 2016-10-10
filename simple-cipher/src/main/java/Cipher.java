import java.util.Random;
import java.util.stream.IntStream;

public class Cipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();
    public String key;

    public Cipher(){
        this.key = IntStream.range(0, 100)
                .map(x -> ALPHABET.toCharArray()[random.nextInt(ALPHABET.length())])
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    public Cipher(String key){
        if(!isValidKey(key)){
            throw new IllegalArgumentException("Invalid Key");
        }
        this.key = key;
    }

    public static boolean isValidKey(String key){
        return key.matches("^[a-z]+$");
    }

    public String getKey(){
        return key;
    }

    public String encode(String plainText){
        StringBuilder cipherText = new StringBuilder(plainText.length());
        for(int index = 0; index < Math.min(plainText.length(), key.length());index++){
            cipherText.append(encodeCharacter(plainText, index));
        }
        return cipherText.toString();
    }

    private char encodeCharacter(String plainText, int index){
        int alphabetIdx = ALPHABET.indexOf(plainText.toCharArray()[index]) + ALPHABET.indexOf(key.toCharArray()[index]);

        if(alphabetIdx >= ALPHABET.length()){
            alphabetIdx -= ALPHABET.length();
        }

        return ALPHABET.toCharArray()[alphabetIdx];
    }

    public String decode(String cipherText){
        StringBuilder plainText = new StringBuilder(cipherText.length());

        for(int i = 0; i < cipherText.length(); i++){
            plainText.append(decodeCharacter(cipherText, i));
        }

        return plainText.toString();
    }


    private char decodeCharacter(String cipherText, int i){
        int alphaIndx = ALPHABET.indexOf(cipherText.toCharArray()[i]) - ALPHABET.indexOf(key.toCharArray()[i]);

        if(alphaIndx < 0){
            alphaIndx += ALPHABET.length();
        }

        return ALPHABET.toCharArray()[alphaIndx];
    }


}
