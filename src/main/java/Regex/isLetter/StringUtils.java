package Regex.isLetter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Package: Regex
 * Created by lusinabrian on 05/09/16 or 05 Sep of 2016,
 * Time: 08:30.
 * Project: JxProjects
 * Description:
 */
public class StringUtils {
    public static boolean isLetter(String s) {
        String let = "^([a-z]{1})$";
        Pattern pattern = Pattern.compile(let, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}
