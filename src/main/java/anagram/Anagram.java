package main.java.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
    String agram;

    public Anagram(String agram) {
        this.agram = agram;
    }

    public List<String> match(List<String> phrases) {
        List<String> result = new ArrayList<String>(); //create a list for result
        char[] agramChars = agram.toLowerCase().toCharArray(); //create character array from input word
        /*Loop through each word in list*/
        for (String word : phrases) {
            //if words are equal ignoring case, replace them
            if (word.equalsIgnoreCase(agram))
                word = word.replace(word, "");
            //create a char array from the word in lowercase
            char[] wordChars = word.toLowerCase().toCharArray();
            //sort both character arrays
            Arrays.sort(wordChars);
            Arrays.sort(agramChars);
            //if the arrays are equal add them to the result list
            if (Arrays.equals(wordChars, agramChars))
                result.add(word);
        }
        return result;
    }

/*CLASS END*/
}
