package java.puzzles.DeadAnts;

public class Deadants {
    /**
     * Checks if the argument is null, returns 0
     * creates a string to later check if the word is ant or a regular word
     * count the number of words in the string using a java.java.regex
     */
    public static int deadAntCount(final String ants) {
        String ant = "ant|^([a-zA-Z]*)$";

        if (ants == null) {
            return 0;
        }

        String[] stampede = ants.split(" ");
        int count = 0;

        for (String aStampede : stampede) {

            if (!aStampede.equals("ant")) {
                count++;
            }
        }
        return count;
    }
}
