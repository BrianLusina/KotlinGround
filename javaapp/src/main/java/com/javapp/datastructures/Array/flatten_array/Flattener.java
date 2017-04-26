package com.javapp.datastructures.Array.flatten_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flattener {

    /**
     * Uses recursion to flatten a nested list
     * @param nestedList a list of lists
     * */
    public List flatten(List nestedList){
        if(nestedList.isEmpty()){
            return new ArrayList();
        }else{
            List result = new ArrayList();

            Object head = nestedList.get(0);
            List tail = nestedList.subList(1, nestedList.size());

            if(head instanceof List){
                result.addAll(flatten((List) head));
            }else{
                result.add(head);
            }

            result.addAll(flatten(tail));
            result.removeAll(Collections.singleton(null));
            return result;
        }
    }
}
