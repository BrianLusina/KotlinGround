package CoffeeCheckin;
import java.util.Scanner;
import java.util.HashMap;
import static CoffeeCheckin.CheckinMarkers.*;

public class CoffeeCheckInSimulation {

    public static void main(String[] args){
        System.out.println("Hello, welcome to Coffee Check-in. Please enter list of employees for the week( separate names with a space)");
        Scanner scannerEmplInput = new Scanner(System.in);
        String employeeList = scannerEmplInput.nextLine();

        //if the list is empty exit the program, else continue execution
        if(validate_input(employeeList)){
            System.out.println("Employee List is empty.");
            System.exit(1);
        }else{
            //add to queue and store in a variable
            HashMap<String, Enum> employees = employee_queue(employeeList);

            System.out.println("Who was late today?(Separate names with spaces)");
            String lateComers = scannerEmplInput.nextLine();

            HashMap<String, Enum> lateHashMap = lateEvaluator(employees, lateComers);

        }
    }

    /**Validates user input
     * Returns false if the list for the week is empty
     * @return {@link Boolean} value*/
    private static boolean validate_input(String employeeList) {
        return employeeList.isEmpty();
    }

    /**queues the list of employees and add a 'marker'/ 'flag',
     * specifying who is next in the list
     * first name on the list is assumed to be next
     * @param employeeListStr the employee list input as a string
     * */
    private static HashMap<String, Enum> employee_queue(String employeeListStr) {
        HashMap<String, Enum> employeeHash = new HashMap<>();
        String[] employeeList = employeeListStr.split(" ");

        // first name on the list is assumed to be NEXT
        employeeHash.put(employeeList[0], NEXT);
        //add the rest of the names
        for(int x = 1; x < employeeList.length; x++){
            employeeHash.put(employeeList[x], OTHER);
        }
        return employeeHash;
    }

    /**Takes in initial list and new string with late comers and evaluates who will buy coffee
     * Crosschecks the employee queue and the late comers, if the employee names are in the late queue
     * then their 'markers'/'flags' are updated from OTHER to LATE, OR from NEXT to LATE
     * @param employeeQueue the employee queue for the week
     * @param lateComers The list of late comers for the day
     * @return The newly updated employee queue*/
    private static HashMap<String, Enum> lateEvaluator(HashMap<String, Enum> employeeQueue, String lateComers) {
        employeeQueue.keySet()
                .stream()
                .filter(lateComers::contains)
                .forEach(employeeName -> employeeQueue.put(employeeName, LATE));
        return employeeQueue;
    }

    /**Updates the queue aby moving the NEXT flag from the current to the next one in the list
     * The current NEXT will get coffee from the the LATE comer
     * Also removes the LATE flag and replaces it with OTHER
     * @param hashMap the HashMap with the employee queue
     * @return The newly updated queue list with the details of who is the beneficiary*/
    private static HashMap<String, Enum> beneficiary(HashMap<String, Enum> hashMap){
        
    }
}
