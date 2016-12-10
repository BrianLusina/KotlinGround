package main.java.Strings.WordSearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Package: Strings.WordSearch
 * Created by lusinabrian on 12/08/16 or 12 Aug of 2016,
 * Time: 06:13.
 * Project: JxProjects
 */
public class WordSearch {

    static String[] findWord_v2(String x, String[] y) {
        final String xLower = x.toLowerCase();
        String[] searchResults = Arrays.stream(y)
                .filter(s -> s.toLowerCase().contains(xLower))
                .toArray(String[]::new);
        return searchResults.length > 0 ? searchResults : new String[]{"Empty"};
    }

    /**
     * Loop through each word in the array, and check if the word contains any character in the string to search for
     *
     * @param x String to search for
     * @param y String array to search through
     * @return results
     */
    public String[] findWord(String x, String[] y) {
        ArrayList<String> results = new ArrayList<>();
        for (String w : y) {
            if (w.toLowerCase().contains(x)) {
                results.add(w);
            }
        }
        return (results.size() != 0) ? results.toArray(new String[results.size()]) : new String[]{"Empty"};
    }

/*class end*/
}
