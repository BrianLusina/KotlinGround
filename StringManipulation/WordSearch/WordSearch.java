package StringManipulation.WordSearch;

import java.util.ArrayList;

/**
 * Package: StringManipulation.WordSearch
 * Created by lusinabrian on 12/08/16 or 12 Aug of 2016,
 * Time: 06:13.
 * Project: JxProjects
 */
public class WordSearch {
    /**
     * Loop through each word in the array, and check if the word contains any character in the string to search for
     * @param x String to search for
     * @param y String array to search through
     * @return results*/
    public String[] findWord(String x, String[] y){
        ArrayList<String> results = new ArrayList<>();
        for(String w : y){
           if(w.toLowerCase().contains(x)){
               results.add(w);
           }
        }
        return (results.size() != 0) ? results.toArray(new String[results.size()]) : new String[]{"Empty"};
    }

/*class end*/
}
