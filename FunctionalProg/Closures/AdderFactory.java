package FunctionalProg.Closures;

import java.util.function.ToIntFunction;
import java.util.function.IntUnaryOperator;
/**
 * FunctionalProg.Closures
 * Created by lusinabrian on 14/11/16.
 * Description:
 */
class AdderFactory {
    /*
   * Make the "create" method (public, static). It accepts one parameter (int addTo) and returns
   * a function (make sure to use the appropriate type). This function accepts an integer,
   * adds "addTo" to that integer, and returns the result as an integer (integer-to-integer function).
   */
    public static IntUnaryOperator create(int addTo) {
        return (integer) -> integer + addTo;
    }
}
