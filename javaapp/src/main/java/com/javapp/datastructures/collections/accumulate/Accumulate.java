package com.javapp.datastructures.collections.accumulate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by lusinabrian on 11/08/16 or 11 Aug of 2016,
 * Time: 19:03.
 * Project: java.java.javapp.datastructures.collections.accumulate
 */
public class Accumulate {

    public static <T> List<T> accumulate(List<T> collection, Function<T, T> func) {
        List<T> outCollection = new ArrayList<>();
        for (T item : collection) {
            outCollection.add(func.apply(item));
        }
        return outCollection;
    }/*java.java.javapp.datastructures.collections.accumulate end*/

    public static <T> List<T> accumulate_v2(List<T> items, UnaryOperator<T> operation) {
        List<T> processed = new ArrayList<>();
        items.forEach(t -> processed.add(operation.apply(t)));
        return processed;
    }/*java.java.javapp.datastructures.collections.accumulate version 2*/

/*CLASS END*/
}



