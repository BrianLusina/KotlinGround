package Math;
/**
 * Package: Math
 * Created by lusinabrian on 29/07/16 or 29 Jul of 2016,
 * Time: 08:43.
 * Project: JxProjects
 * Description:
 Using java, have the function divide(num1,num2)
 Let the function take both parameters being passed and return the Greatest Common Factor.
 That is, return the greatest number that evenly goes into both numbers with no remainder.
 For example: 20 and 10 both are divisible by 1, 2, 5 and 10 so the output should be 10.
 The range for both parameters will be from 1 to 10^3.
 */
public class GCF {
    public static void main(String[] args){
        System.out.printf("Actual: %d, Expected:%d\n", divide(20,10), 10);
        System.out.printf("Actual: %d, Expected:%d\n",divide(5,1), 1);
    }
    /**
     * @implNote Used to obtain the GCD of two numbers
     * @param num1 number to evaluate gcd
     * @param num2 number to evaluat gcd*/
    public static int divide(int num1, int num2){
        if(num1 == 0 || num2 == 0)
            return num1+num2;
        return divide(num2,num1%num2);
    }/*METHOD END*/

/*CLASS END*/
}