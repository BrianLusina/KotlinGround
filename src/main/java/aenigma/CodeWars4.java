import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class CodeWars4 {
    public static void main(String[] args) {

        System.out.println("Testing for zebulansNightmare(String s) function");
        System.out.println(zebulansNightmare("camel_case").equals("camelCase"));
        System.out.println(zebulansNightmare("zebulans_nightmare").equals("zebulansNightmare"));
        System.out.println(zebulansNightmare("get_string").equals("getString"));
        System.out.println(zebulansNightmare("convert_to_uppercase").equals("convertToUppercase"));
        System.out.println(zebulansNightmare("main").equals("main"));

        System.out.println("Testing for saleHotdogs(final int n) function");
        System.out.println(100 == saleHotdogs(1));
        System.out.println(400 == saleHotdogs(4));
        System.out.println(475 == saleHotdogs(5));
        System.out.println(855 == saleHotdogs(9));
        System.out.println(900 == saleHotdogs(10));
        System.out.println(9000 == saleHotdogs(100));

        System.out.println("Testing for orderWord(String s) function");
        System.out.println(orderWord("hello world").equals(" dehllloorw"));
        System.out.println(orderWord("bobby").equals("bbboy"));
        System.out.println(orderWord("").equals("Invalid String!"));
        System.out.println(orderWord("i\"d][@z!#$r(^a&world%").equals("!\"#$%&(@[]^addilorrwz"));
        System.out.println(orderWord("\"][@!#$*(^&%").equals("!\"#$%&(*@[]^"));
        System.out.println(orderWord("completesolution").equals("ceeillmnooopsttu"));
        System.out.println(orderWord("Hello, World!").equals(" !,HWdellloor"));

        System.out.println("Testing for isSqure(int n) function");
        System.out.println(!isSquare(-1));
        System.out.println(!isSquare(3));
        System.out.println(isSquare(4));
        System.out.println(isSquare(25));
        System.out.println(!isSquare(26));

        System.out.println("Testing for noBoringZeroes(int n) function");
        System.out.println(noBoringZeros(1450) == 145);
        System.out.println(noBoringZeros(960000) == 96);
        System.out.println(noBoringZeros(1050) == 105);
        System.out.println(noBoringZeros(-1050) == -105);

        Ghost ghost = new Ghost();
        System.out.print(ghost.color());
        //MAIN METHOD END
    }


    /**
     * Zebulan has worked hard to write all his python code in strict compliance to PEP8 rules. In this kata, you are a mischevious hacker that has set out to sabatoge all his good code.
     * <p>
     * Your job is to take PEP8 compatible function names and convert them to camelCase. For example:
     * <p>
     * zebulansNightmare('camel_case') == 'camelCase'
     * zebulansNightmare('zebulans_nightmare') == 'zebulansNightmare'
     * zebulansNightmare('get_string') == 'getString'
     * zebulansNightmare('convert_to_uppercase') == 'convertToUppercase'
     * zebulansNightmare('main') == 'main'
     */

    public static String zebulansNightmare(final String fnName) {
        String[] strArr = fnName.split("_"); //split into an array of words, separator is _
        ArrayList<String> arrList = new ArrayList<>();
        String res = "";
        arrList.add(strArr[0]); //add first word to ArrayList
        if (strArr.length == 1)
            return strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            res += strArr[i].substring(0, 1).toUpperCase() + strArr[i].substring(1);
        }
        return String.join("", arrList.get(0) + res);
    }

    public static int saleHotdogs(final int n) {
        if (n == 0)
            return 0;
        else if (n < 5)
            return n * 100;
        else if (n >= 5 && n < 10)
            return n * 95;
        else
            return n * 90;
    }

    /**
     * Given a string, you need to write a method that order every letter in this string in ascending order.
     * <p>
     * Also, you should validate that the given string is not empty or null. If so, the method should return:
     * <p>
     * "Invalid String!";
     * Examples
     * <p>
     * System.out.println(orderWord("hello world").equals(" dehllloorw"));
     * System.out.println(orderWord("bobby").equals("bbboy"));
     * System.out.println(orderWord("").equals("Invalid String!"));
     * System.out.println(orderWord("i\"d][@z!#$r(^a&world%").equals("!\"#$%&(@[]^addilorrwz"));
     * System.out.println(orderWord("\"][@!#$*(^&%")).equals("!\"#$%&(*@[]^"));
     * System.out.println(orderWord("completesolution").equals("ceeillmnooopsttu"));
     * System.out.println(orderWord("Hello, World!").equals(" !,HWdellloor"));
     * Notes
     * <p>
     * • the given string can be lowercase and uppercase.
     * • the string could include spaces or other special characters like '# ! or ,'
     */
    public static String orderWord(String s) {
        if (s.equals("") || s.equals(null))
            return "Invalid String!";
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        String newWord = new String(characters);
        return newWord;
    }

    /**
     * You like building blocks. You especially like building blocks that are squares. And what you even like more, is to arrange them into a square of square building blocks!
     * <p>
     * However, sometimes, you can't arrange them into a square. Instead, you end up with an ordinary rectangle! Those blasted things! If you just had a way to know, whether you're currently working in vain… Wait! That's it! You just have to check if your number of building blocks is a perfect square.
     * <p>
     * Task
     * <p>
     * Given an integral number, determine if it's a square number:
     * <p>
     * In mathematics, a square number or perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
     * The tests will always use some integral number, so don't worry about that in dynamic typed languages.
     * <p>
     * Examples
     * <p>
     * System.out.println(isSquare(-1) // => false
     * System.out.println(isSquare( 3) // => false
     * System.out.println(isSquare( 4) // => true
     * System.out.println(isSquare(25) // => true
     * System.out.println(isSquare(26) // => false
     */

    public static boolean isSquare(int n) {
        return n > 0 && Math.round(Math.sqrt(n)) == Math.sqrt(n);
    }

    /**
     * Numbers ending with zeros are boring.
     * <p>
     * They might be fun in your world, but not here.
     * <p>
     * Get rid of them. Only the ending ones.
     * <p>
     * System.out.println(noBoringZeros(1450 ==145));
     * System.out.println(noBoringZeros(960000 == 96));
     * System.out.println(noBoringZeros(1050 == 105));
     * System.out.println(noBoringZeros(-1050 == -105));
     * Zero alone is fine, don't worry about it. Poor guy anyway
     */
    public static int noBoringZeros(int n) {
        if (n == 0)
            return n;
        String s = String.valueOf(n);
        s = s.replaceAll("0*$", "");
        return Integer.parseInt(s);
    }

    /**
     * Color Ghost
     * <p>
     * Create a class Ghost
     * <p>
     * Ghost objects are instantiated without any arguments.
     * <p>
     * Ghost objects are given a random color attribute of white" or "yellow" or "purple" or "red" when instantiated
     * <p>
     * Ghost ghost = new Ghost();
     * ghost.getColor(); //=> "white" or "yellow" or "purple" or "red"
     * c# Ghost ghost = new Gost(); ghost.GetColor(); // => "white" or "yellow" or "purple" or "red"
     */
    public static class Ghost {
        String[] colors = new String[]{"red", "purple", "white", "yellow"};
        Random r = new Random();

        public Ghost() {
        }

        public String color() {
            return colors[r.nextInt(4)];
        }
    }

//CLASS END
}