package pangram.src.main.java;

/**
 * Created by lusinabrian on 24/06/16.
 */
public class Pangrams {

    public static boolean isPangram(String pan){
        int i=0;
        for(char c : pan.toCharArray()) {
            int x = Character.toUpperCase(c);
            if (x >= 'A' && x <= 'Z') {
                i |= 1 << (x - 'A');
            }
        }
        return i == (i | ((1 << (1 + 'Z' - 'A')) - 1));
    }
}
