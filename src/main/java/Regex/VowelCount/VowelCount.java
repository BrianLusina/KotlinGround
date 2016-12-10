package main.java.Regex.VowelCount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Package: Regex.VowelCount
 * Created by lusinabrian on 05/09/16 or 05 Sep of 2016,
 * Time: 08:36.
 * Project: JxProjects
 * Description:
 */
public class VowelCount {
    public static void main(String[] args){
        System.out.println("Testing for getCount()");
        System.out.println(getCount("Power"));
        System.out.println(getCount("Oops"));
    }

    public static int getCount(String str) {
        String vow = "[aeiou]";
        int vowelCount = 0;
        Pattern pattern = Pattern.compile(vow,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            vowelCount++;
        }
        return vowelCount;
    }

}
