package java.math.histogram;

public class Histogram {
    /***
     * Loop through the string converting the loop count to a string while concatenating
     * the count of hashes and the number itself.
     * @param results the integer array with the roll results, They will be arranged in order the 1st element is
     * the roll count of number 1 on the die and so on.
     * @return the java.java.math.histogram in string format*/
    public static String histogram(final int results[]) {
        String output = "";
        for (int i = results.length; i > 0; i--) {
            String n = (results[i - 1] != 0) ? " " + String.valueOf(results[i - 1]) + "\n" : "" + "\n";
            output += String.valueOf(i) + "|"
                    + new String(new char[results[i - 1]]).replace("\0", "#")
                    + n;
        }

        return output;
    }
}
