package java.stringswords.Wordcount;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String, Integer> phrase(String word) {
        //convert string to lowercase to cater for similar words with different capitalizations
        word = word.toLowerCase();
        //Use java.java.regex to remove all non-words and punctuation marks
        String punctuation = "\\W+";
        /*create a map to store the strings and the word count*/
        Map<String, Integer> map = new HashMap<String, Integer>();
        /*for each loop looping through each word in string array*/
        for (String s : word.split(" ")) {
            s = s.replaceAll(punctuation, "");
            Integer count = map.get(s);
            count = (count != null && map.containsKey(s)) ? ++count : 1;
            map.put(s, count);
            //remove all white spaces counted
            map.remove("");
        }
        return map;
    }
}
