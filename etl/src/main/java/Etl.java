package etl.src.main.java;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Etl {
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