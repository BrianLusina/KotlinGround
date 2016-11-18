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

        //add to queue and store in a variable
        HashMap<String, Enum> employees = employee_queue(employeeList);

        System.out.println("Who was late today?(Separate names with spaces)");
        String lateComers = scannerEmplInput.nextLine();

        lateEvaluater(employees, lateComers);
    }

    /**queues the list of employees and add a 'marker', specifying who is next in the list
     * @param employeeListStr the employee list input as a string
     * */
    private static HashMap<String, Enum> employee_queue(String employeeListStr) {
        //first name on the list is assumed to be next
        HashMap<String, Enum> employeeHash = new HashMap<>();
        String[] employeeList = employeeListStr.split(" ");

        //todo: evaluate length of the array before performing loop
        employeeHash.put(employeeList[0], NEXT);
        //add the rest of the names
        for(int x = 1; x < employeeList.length; x++){
            employeeHash.put(employeeList[x], OTHER);
        }
        return employeeHash;
    }

    /**Takes in initial list and new string with late comers and evaluates who will buy coffee
     * Crosschecks the employee queue and the late comers, if the employee names are in the late queue
     * then their 'markers' are updated from OTHER to LATE, OR from NEXT to LATE
     * @param employeeQueue the employee queue for the week
     * @param lateComers The list of late comers for the day*/
    private static HashMap<String, Enum> lateEvaluater(HashMap<String, Enum> employeeQueue, String lateComers) {
        employeeQueue.keySet()
                .stream()
                .filter(lateComers::contains)
                .forEach(employeeName -> employeeQueue.put(employeeName, LATE));
        System.out.println(employeeQueue);
        return employeeQueue;
    }
}
