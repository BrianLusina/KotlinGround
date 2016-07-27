package StringManipulation;

/**
 * Package: StringManipulation
 * Created by lusinabrian on 27/07/16 or 27 Jul of 2016,
 * Time: 09:39.
 * Project: JxProjects
 * Description:
 * Write a java algorithm to reverse a string, and print it's output
 * For instance, "CodeNinja" returns: 'ajniNedoC'
 */
public class ReverseString {

    public static void main(String[] args){
        System.out.printf("Actual:%s, Expected:%s",reverse("CodeNinja"), "ajniNedoC");
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
