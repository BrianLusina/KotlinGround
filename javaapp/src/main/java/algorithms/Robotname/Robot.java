package java.algorithms.Robotname;

import java.util.Random;

public class Robot {

    /*randomize robot names*/
    public String getName() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        char c1 = (char) (rand.nextInt(26) + 'A');
        char c2 = (char) (rand.nextInt(26) + 'B');
        char[] cArr = new char[]{c1, c2};
        sb.append(cArr);
        return sb + String.valueOf(rand.nextInt(1000));
    }

    /*reset the name*/
    public String reset() {
        return getName();
    }
}
