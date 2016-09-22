package histogram;

public class Histogram {
    /***
     * Loop through the string converting the loop count to a string while concatenating
     * the count of hashes and the number itself.
     * @param results the integer array with the roll results, They will be arranged in order the 1st element is
     * the roll count of number 1 on the die and so on.
     * @return the histogram in string format*/
    public static String histogram(final int results[]) {
        String output = "";
        for(int i =0; i < results.length;i++) {
            output += String.valueOf(i+1) + "|"
                    + new String(new char[results[i]]).replace("\0","#")
                    + " " + String.valueOf(results[i]) + "\n";
        }

        return output;
    }
}
