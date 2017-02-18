package main.algorithms.strain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lusinabrian on 08/08/16 or 08 Aug of 2016,
 * Time: 16:23.
 * Project: java.java.algorithms.strain
 */
public class Strain {

    public static <T> List<T> keep(List<T> collection, Predicate<T> predicate) {
        return filter(collection, predicate);
    }/*KEEP END*/

    public static <T> List<T> discard(List<T> collection, Predicate<T> predicate) {
        return filter(collection, predicate.negate());
    }/*discard end*/

    private static <T> List<T> filter(List<T> collection, Predicate<T> predicate) {
        List<T> filterd = new ArrayList<>();
        for (T item : collection) {
            if (predicate.test(item)) {
                filterd.add(item);
            }
        }
        return filterd;
    }/*filter end*/
/*CLASS END*/
}