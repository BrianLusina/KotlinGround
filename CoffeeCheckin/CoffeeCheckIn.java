package CoffeeCheckin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Package: CoffeeCheckin
 * Created by lusinabrian on 29/08/16 or 29 Aug of 2016,
 * Time: 00:27.
 * Project: JxProjects
 * Description:
 store list of names in an ArrayList
 split the string with names and store in an ArrayList, evaluating who will be next in line.
 */
public class CoffeeCheckIn {
    public static void main(String[] args){
        System.out.println("Hello, welcome to Coffee Checkin, please enter list of employees, separate names with a space");
        Scanner scanner = new Scanner(System.in);
        String employee_list = scanner.next();
        queue(employee_list);
        System.out.println("Who was late today?");
        String later_commer = scanner.next();
    }

    /**queues the list of employees*/
    private static ArrayList<String> queue(String employee_list) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, employee_list.split(" "));
        return list;
    }

}
