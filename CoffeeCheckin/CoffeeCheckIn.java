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
        System.out.println("Who was late today?(Separate names with spaces)");
        String late_comers = scanner.next();
        late_evaluater(queue(employee_list), late_comers);
    }

    /**queues the list of employees and add a 'marker', specifying who is next in the list*/
    private static ArrayList<String> queue(String employee_list) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, employee_list.split(" "));
        String s = list.get(1) + "*";
        return list;
    }

    /**Takes in initial list and new string list with late comers and evaluates who will buy coffee*/
    private static ArrayList<String> late_evaluater(ArrayList<String> queue, String late_comers) {
        ArrayList<String> updated_list = new ArrayList<>();
        for(String late: late_comers.split(" ")){
            if(queue.contains(late)){
                
            }
        }

        return null;
    }
}
