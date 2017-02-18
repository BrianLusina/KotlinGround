package main.math.raindrops;

/**
 * Package: PACKAGE_NAME
 * Created by lusinabrian on 31/07/16 or 31 Jul of 2016,
 * Time: 08:45.
 * Project: math.raindrops
 */
public class Raindrops {

    public static String convert(int number) {
        String rain = "";

        if (number % 3 == 0) {
            rain += "Pling";
        }

        if (number % 5 == 0) {
            rain += "Plang";
        }

        if (number % 7 == 0) {
            rain += "Plong";
        }

        if (rain.isEmpty()) {
            rain = Integer.toString(number);
        }

        return rain;
    }/*METHOD END*/

/*CLASS END*/
}