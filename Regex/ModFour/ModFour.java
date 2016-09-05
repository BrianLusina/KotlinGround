package Regex.ModFour;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ModFour {
    public static void main(String[] args) {

        String[] validTests = {"[+05620]", "[005624]", "[-05628]", "[005632]", "[555636]", "[+05640]", "[005600]", "the beginning [-0] the end", "~[4]", "[32]", "the beginning [0] ... [invalid] numb[3]rs ... the end", "...may be [+002016] will be."};
        for (String test : validTests) {
            Matcher m = mod4.matcher(test);
            System.out.print(test + " is valid, but no match was made." + m.find());
        }

        String[] invalidTests = {"[+05621]", "[-55622]", "[005623]", "[~24]", "[8.04]", "No, [2014] isn't a multiple of 4..."};

        for (String test : invalidTests) {
            Matcher m = mod4.matcher(test);
            System.out.println(test + " is invalid, but a match was made." + m.find());
        }
    }

    public static Pattern mod4 = Pattern.compile("...");
}
