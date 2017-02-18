package java.stringswords.pangram;

public class Pangrams {

    public static boolean isPangram(String pan) {
        int i = 0;
        for (char c : pan.toCharArray()) {
            int x = Character.toUpperCase(c);
            if (x >= 'A' && x <= 'Z') {
                i |= 1 << (x - 'A');
            }
        }
        return i == (i | ((1 << (1 + 'Z' - 'A')) - 1));
    }
}
