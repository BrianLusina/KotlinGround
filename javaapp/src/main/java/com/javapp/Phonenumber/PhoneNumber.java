package com.javapp.Phonenumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        String patRegex = "\\W";
        String badNumber = "0000000000";
        String newNumResult = "";
        Pattern pattern = Pattern.compile(patRegex);
        String list = "";

        /*clean number*/
        for (String s : number.split("")) {
            Matcher matcher = pattern.matcher(s);
            if (!matcher.matches())
                list += s;
        }
        /*if less than 10, then the number is invalid*/
        if (list.length() < 10)
            newNumResult = badNumber;
        /*if number is 10 digits, valid*/
        else if (list.length() == 10)
            newNumResult = list;
        /*if 11 and starts with 1, trim 1,*/
        else if (list.length() == 11 && list.startsWith("1"))
            newNumResult = list.substring(1);
        /*number does not start with 1, but is 11 digits, then it is bad*/
        else if (list.length() == 11 && !list.startsWith("1"))
            newNumResult = badNumber;
        else if (list.length() >= 11)
            newNumResult = badNumber;

        return newNumResult;
    }

    public String getAreaCode() {
        return number.substring(0, 3);
    }

    /*pretty print*/
    public String pretty() {
        //get area code
        String format = this.getNumber();
        String area = "(" + new PhoneNumber(format).getAreaCode() + ")";
        /*get next three digits*/
        String nextThree = " " + format.substring(3, 6) + "-";
        /*get last digits*/
        String last = format.substring(6);
        /*concatenate them*/
        return area + nextThree + last;
    }
/*CLASS END*/
}
