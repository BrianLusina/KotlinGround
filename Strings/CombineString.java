package Strings;

/**
 * Package: Strings
 * Created by lusinabrian on 02/08/16 or 02 Aug of 2016,
 * Time: 08:30.
 * Project: JxProjects
 * Description:
   We are given 3 strings: str1, str2, and str3.
   Str3 is said to be a shuffle of str1 and str2 if it can be formed by interleaving the characters of str1 and str2
   in a way that maintains the left to right ordering of the characters from each string.
   For example, given str1="abc" and str2="def", str3="dabecf" is a valid shuffle since it preserves the character ordering of the two strings.
    So, given these 3 strings write a function that detects whether str3 is a valid shuffle of str1 and str2.
 */
public class CombineString {
    public static void main(String[] args){
        System.out.printf("Actual: %s, Expected: %s\n", combine_string("abc", "def","dabecf"), true);
    }

    /**
     * Check if the length of the two strings is equal to the length of the third
     * if the first character of the first string is not equal to the first character of the last string
     * and the second string's first character is not equal to the first character of the 3rd string return false
     * We check whether the length of str1 plus str2 equals to the length of str3. If not, then str3 can’t be a valid shuffle since it contains extra characters, so we return false.
     *If the first characters of str1 and str3 are the same, then recurse with new str1 and str3 being all but first characters of the strings, and str2 will stay the same.
     * If first characters of str2 and str3 are the same, do the same thing with new str2 and str3 being all but first characters, and str1 the same.
     * If neither str1’s nor str2’s first character equals str3’s first character, we return false. The base case of the recursion is, if any of the strings is empty then the concatenation of str1 and str2 should be equal to str3
     * */
    public static boolean combine_string(String str1, String str2, String str3) {
        if (str1.length() + str2.length() != str3.length()) {
            return false;
        }
        if(str1 == null || str2== null || str3 ==null){
            if((str1 + str2).equals(str3)){
                return true;
            }else{
                return false;
            }
        }
        if(str1.charAt(0) != str3.charAt(0) && str2.charAt(0) != str3.charAt(0)){
            return false;
        }

        if(str1.charAt(0) == str3.charAt(0) && combine_string(str1.substring(1),str2, str3.substring(1))){
            return true;
        }

        if(str2.charAt(0) == str3.charAt(0) && combine_string(str1,str2.substring(1), str3.substring(1))){
            return true;
        }
        return false;

    }/*end*/
/*CLASS END*/
}
