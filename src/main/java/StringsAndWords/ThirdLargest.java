package main.java.Strings;

/**
 * Created by lusinabrian on 20/07/16.
 * function ThirdGreatest(strArr)
 * take the array of strings stored in strArr and return the third largest word within in.
 * So for example: if strArr is ["hello", "world", "before", "all"]
 * your output should be "world" because "before" is 6 letters long, and "hello" and "world" are both 5, but the output should be world because it appeared as the last 5 letter word in the array.
 * <p>
 * If strArr was ["hello", "world", "after", "all"] the output should be after because the first three words are all 5 letters long, so return the last one.
 * <p>
 * The array will have at least three strings and each string will only contain letters.
 */
public class ThirdLargest {
    public static void main(String[] args) {
        System.out.println(ThirdGreatest(new String[]{"hello", "world", "before", "all"}));
        System.out.println(ThirdGreatest(new String[]{"hello", "world", "after", "all"}));
    }

    /**
     * @param arr string array input
     * @return third longest word
     * @implNote method checks for the third largest string in an array.
     * If strings are of same length, return the last word in the order of the array
     */
    public static String ThirdGreatest(String[] arr) {
        //initialize three string variables for the 1,2 and 3 longest strings
        String longW = "";
        String secW = "";
        String thW = "";
        /*perform a for loop, looping through each word, checking for longest word*/
        for (String current : arr) {
            /*if current is greater than longest, reassign it to the longest word
            assign the second longest to the third and the longest to the second.
            * */
            System.out.println("Current string: " + current);
            if (current.length() > longW.length()) {
                thW = secW;
                secW = longW;
                longW = current;
                System.out.printf("Third Word: %s Second Word: %s, Longest Word: %s", thW, secW, longW);
            /*if the current word is longer than second  assign it to the second*/
            } else if (current.length() > secW.length()) {
                thW = secW;
                secW = current;
            /*if current word is longer than third word*/
            } else if (current.length() > thW.length()) {
                thW = current;
            }
        }
        return thW;
    }
/*CLASS END*/
}