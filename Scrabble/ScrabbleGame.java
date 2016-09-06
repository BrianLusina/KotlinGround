package Scrabble;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package: Scrabble
 * Created by lusinabrian on 06/09/16 or 06 Sep of 2016,
 * Time: 12:24.
 * Project: JxProjects
 * Description:
 */
public class ScrabbleGame {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> result = new HashMap<String,Integer>();
        for(Map.Entry<Integer,List<String>> map:old.entrySet()){
            int pointKey = map.getKey();
            List<String> list = map.getValue();
            for(String alphas:list) {
                result.put(alphas.toLowerCase(),pointKey);
            }
        }

        return result;
    }
}
