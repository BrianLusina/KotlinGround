package main.stringswords.NameThatNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Package, java.java.stringswords
 * Created by lusinabrian on 03/08/16 or 03 Aug of 2016,
 * Time, 09,30.
 * Project, JxProjects
 */
public class NameThatNumber {
    public final String[] NAMESTWO = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public Map<Integer, String> Name() {
        Map<Integer, String> NAMES = new HashMap<>();
        NAMES.put(0, "zero");
        NAMES.put(1, "one");
        NAMES.put(2, "two");
        NAMES.put(3, "three");
        NAMES.put(4, "four");
        NAMES.put(5, "five");
        NAMES.put(6, "six");
        NAMES.put(7, "seven");
        NAMES.put(8, "eight");
        NAMES.put(9, "nine");
        NAMES.put(10, "ten");
        NAMES.put(11, "eleven");
        NAMES.put(12, "twelve");
        NAMES.put(13, "thirteen");
        NAMES.put(14, "fourteen");
        NAMES.put(15, "fifteen");
        NAMES.put(16, "sixteen");
        NAMES.put(17, "seventeen");
        NAMES.put(18, "eighteen");
        NAMES.put(19, "nineteen");
        return NAMES;
    }

    public String nameThatNumber(int x) {
        String out;
        if (Name().containsKey(x)) {
            out = Name().get(x);
        } else {
            int tens = (int) Math.floor(x / 10);
            int ones = x % 10;
            out = (ones != 0) ? NAMESTWO[tens - 2] + " " + Name().get(ones) : NAMESTWO[tens - 2];
        }
        return out;
    }

/*class end*/
}
