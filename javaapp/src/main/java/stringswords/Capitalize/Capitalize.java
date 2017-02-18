package main.stringswords.Capitalize;

/**
 * Package: java.java.stringswords
 * Created by lusinabrian on 24/08/16 or 24 Aug of 2016,
 * Time: 05:28.
 * Project: JxProjects
 * Description: take the str parameter being passed and capitalize the first letter of each word.
 * Words will be separated by only one space.
 * use the main method for testing and call the function from the main method
 * it should take string input from a user
 */
public class Capitalize {

    public String capitalize(String str) {
        String res = "";
        for (String s : str.split(" ")) {
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            res += s + " ";
        }
        return res.trim();
    }
}