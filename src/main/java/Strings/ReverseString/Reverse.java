package Strings.ReverseString;

/**
 * Package: Strings
 * Created by lusinabrian on 27/07/16 or 27 Jul of 2016,
 * Time: 09:39.
 * Project: JxProjects
 * Description:
 * Write a java algorithm to reverse a string, and print it's output
 * For instance, "CodeNinja" returns: 'ajniNedoC'
 */
public class Reverse {

    public static void main(String[] args){
        /*TESTS*/
        System.out.printf("Actual:%s, Expected:%s\n",reverse("CodeNinja"), "ajniNedoC");
        System.out.printf("Actual:%s, Expected:%s\n",reverse("ninja"), "ajnin");
        System.out.printf("Actual:%s, Expected:%s\n",reverse("World"), "dlroW");
        System.out.printf("Actual:%s, Expected:%s\n",reverse("pleh em"), "help me");
    }

    /**
     * Create a new string builder append the string to the string builder
     * use the reverse method of sb and convert to string
     * @param input, string input to reverse*/
    public static String reverse(String input){
        StringBuilder sb = new StringBuilder().append(input);
        return sb.reverse().toString();
    }/*method end*/
/*CLASS END*/
}
