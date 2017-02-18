package main.regex.Autocorrect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Package: regex.Autocorrect
 * Created by lusinabrian on 05/09/16 or 05 Sep of 2016,
 * Time: 08:39.
 * Project: JxProjects
 * Description:
 */
public class AutoCorrect {
    public static void main(String[] args) {

        System.out.println("Testing for autocorrect()");
        System.out.println(autocorrect("you are huge"));
        System.out.println(autocorrect("youuuuuuuuu"));
        System.out.println(autocorrect("u"));
        System.out.println(autocorrect("u woos"));
    }

    public static String autocorrect(String input) {
        String pat = "^(u)+$|^(u)$(\\s\\w|\\W)+|(\\w|\\W\\s)(u)(\\w|\\W\\s)+(u)(\\s\\w|\\W)+|yo(u)+$|yo(u)+(\\s|\\w|\\W)+$|^(\\w|\\W)+yo(u)+$|(\\w|\\W\\s)+(you)(\\s\\w|\\W)+";
        Pattern pattern = Pattern.compile(pat, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            input = input.replaceAll(pat, "your sister");
        }
        return input;
    }
}
