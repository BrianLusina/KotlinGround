import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by lusinabrian on 16/06/16.
 * Class for all Regex tests and solutions
 */
public class Regex {
    public static void main(String[] args){

        System.out.println("Testing for autocorrect()");
        System.out.println(autocorrect("you are huge"));
        System.out.println(autocorrect("youuuuuuuuu"));
        System.out.println(autocorrect("u"));
        System.out.println(autocorrect("u woos"));
    }



/**
 * Your friend won't stop texting his girlfriend. It's all he does. All day. Seriously. The texts are so mushy too! The whole situation just makes you feel ill. Being the wonderful friend that you are, you hatch an evil plot. While he's sleeping, you take his phone and change the autocorrect options so that every time he types "you" or "u" it gets changed to "your sister."

 Write a function called autocorrect that takes a string and replaces all instances of "you" or "u" (not case sensitive) with "your sister" (always lower case).

 Return the resulting string.

 Here's the slightly tricky part: These are text messages, so there are different forms of "you" and "u".

 For the purposes of this kata, here's what you need to support:

 "youuuuu" with any number of u characters tacked onto the end
 "u" at the beginning, middle, or end of a string, but NOT part of a word
 "you" but NOT as part of another word like youtube or bayou
 * **/

    public static String autocorrect(String input) {
        String pat = "^(u)+$|^(u)$(\\s\\w|\\W)+|(\\w|\\W\\s)(u)(\\w|\\W\\s)+(u)(\\s\\w|\\W)+|yo(u)+$|yo(u)+(\\s|\\w|\\W)+$|^(\\w|\\W)+yo(u)+$|(\\w|\\W\\s)+(you)(\\s\\w|\\W)+";
        Pattern pattern = Pattern.compile(pat,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            input = input.replaceAll(pat,"your sister");
        }
        return input;
    }

/*CLASS END*/
}
