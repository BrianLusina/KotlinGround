package CoffeeCheckin;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import static CoffeeCheckin.CoffeeCheckinMarkers.*;


public class CoffeeCheckInSimulation {

    public static void main(String[] args){
        System.out.println("Hello, welcome to Coffee Check-in, please enter list of employees for the week( separate names with a space)");
        Scanner scannerEmplInput = new Scanner(System.in);
        String employeeList = scannerEmplInput.nextLine();

        //add to queue
        employee_queue(employeeList);

        System.out.println("Who was late today?(Separate names with spaces)");
        String late_comers = scannerEmplInput.nextLine();

        //late_evaluater(employee_queue(employee_list), late_comers);
    }

    /**queues the list of employees and add a 'marker', specifying who is next in the list
     * @param employeeListStr the employee list input as a string
     * */
    private static HashMap<String, Enum> employee_queue(String employeeListStr) {
        //first name on the list is assumed to be next
        HashMap<String, Enum> employeeHash = new HashMap<>();
        String[] employeeList = employeeListStr.split(" ");

        employeeHash.put(employeeList[0], NEXT);
        //add the rest of the names
        for(int x = 1; x < employeeList.length; x++){
            employeeHash.put(employeeList[x], OTHER);
        }
        return employeeHash;
    }

    /**Takes in initial list and new string with late comers and evaluates who will buy coffee
     * @param queue the employee queue for the week
     * @param late_comers The list of late comers for the day*/
    private static ArrayList<String> late_evaluater(ArrayList<String> queue, String late_comers) {
        ArrayList<String> updated_list = new ArrayList<>();
        for(String late: late_comers.split(" ")){
            for(String q: queue){
            }
        }

        return updated_list;
    }
}
