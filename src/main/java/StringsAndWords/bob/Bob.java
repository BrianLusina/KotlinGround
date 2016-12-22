package main.java.bob;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bob {

    public String hey(String input) {
        /*silence*/
        if (input.trim().length() == 0) {
            return "Fine. Be that way!";
        }
        /*compile the regex*/
        Pattern patternQue = Pattern.compile("\\w+\\?$");
        Matcher matcherQue = patternQue.matcher(input);
        /*if shouting*/
        if (input.equals(input.toUpperCase()) && !input.equals(input.toLowerCase())) {
            return "Whoa, chill out!";
        /*if question*/
        } else if (matcherQue.find()) {
            return "Sure.";
        } else
            return "Whatever.";
    }
}
