import java.util.ArrayList;
import java.util.List;

/**
 * Created by lusinabrian on 10/08/16 or 10 Aug of 2016,
 * Time: 10:32.
 * Project: atbash-cipher
 */
public class Atbash {

    private static final int GROUP_SIZE = 5;
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";

    public static String encode(String input){
        String enc = filterInvalids(input).toLowerCase();
        String dec = "";
        for(char c : enc.toCharArray()){
            dec += cipherizer(c);
        }

        return groupies(dec);
    }/*encoding end*/

    public static String decode(String input){
        String enc = filterInvalids(input).toLowerCase();
        String dec = "";
        for(char c : enc.toCharArray()){
            dec += cipherizer(c);
        }
        return dec;
    }/*decoding end*/

    /*filter invalid characters*/
    public static String filterInvalids(String toFilter){
        String out = "";
        for(char c: toFilter.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                out += c ;
            }
        }
        return out;
    }

    /*performs the actual cipher*/
    public static char cipherizer(char c){
        int indx = ALPHA.indexOf(c);
        return indx >= 0 ? CIPHER.toCharArray()[indx] : c;
    }

    /*groups the words into five letters*/
    public static String groupies(String str){
        List<String> words = new ArrayList<String>();
        for(int x = 0;x < str.length(); x += GROUP_SIZE){
            words.add(x + GROUP_SIZE <=  str.length() ? str.substring(x, x + GROUP_SIZE) : str.substring(x));
        }
        return String.join(" ", words);
    }
/*CLASS END*/
}