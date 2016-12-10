package main.java.Regex.ValidPhoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Package: Regex.ValidPhoneNumber
 * Created by lusinabrian on 05/09/16 or 05 Sep of 2016,
 * Time: 08:34.
 * Project: JxProjects
 * Description:
 */
public class ValidPhone {
    public static void main(String[] args) {

        System.out.println("Testing for validPhoneNumber()");
        System.out.println(validPhoneNumber("(123) 456-7890"));
        System.out.println(validPhoneNumber("(1111)555 2345"));
        System.out.println(validPhoneNumber("(098) 123 4567"));
    }

    public static boolean validPhoneNumber(String phoneNumber) {
        String number = "^\\([0-9]{3}\\)\\s[0-9]{3}\\-[0-9]{4}$";
        Pattern pattern = Pattern.compile(number);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }
}
