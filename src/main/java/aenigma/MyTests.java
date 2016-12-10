import java.util.Arrays;
import java.util.stream.IntStream;

public class MyTests {
    public static void main(String[] args) {

        String camel = "camel_case";
        System.out.println(camel.substring(0, 1));
        System.out.println(camel.substring(1));
        System.out.println(Arrays.toString(camel.split("")));

        System.out.println(Math.sqrt(625));

        System.out.println("\u00A3".equalsIgnoreCase("£"));
        System.out.println("\u00A3");

        System.out.println(String.join("", camel.split("")));
        String word = "middle";
        int y = (int) Math.floor(word.length() / 2);
        System.out.println(word.substring(y - 1, y + 1));

        System.out.println(Arrays.toString(IntStream.range(0, 10).toArray()));
        Primers primers = new Primers();
        System.out.println(primers.numberOfDivisors(30));

    /*Main method end*/
    }

/*Class end*/
}
