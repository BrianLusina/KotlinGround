package CoffeeCheckin;
import java.util.Optional;
import java.util.Scanner;
import java.util.HashMap;
import static CoffeeCheckin.CheckinMarkers.*;

public class CoffeeCheckInSimulation {
    private static Scanner scannerEmplInput;
    private static int day_counter = 1;

    public static void main(String[] args){
        System.out.println("Hello, welcome to Coffee Check-in. Please enter list of employees for the week( separate names with a space)");
        scannerEmplInput = new Scanner(System.in);
        String employeeList = scannerEmplInput.nextLine();
        //add the list to a queue and store in a variable

        while(day_counter <= 5){
            //if the list is empty exit the program, else continue execution
            if(employeeList.isEmpty()){
                System.out.println("Employee List is empty. No one is coming in this week. Free week!");
                System.exit(1);
            }else{
                HashMap<String, Enum> employees = employee_queue(employeeList);
                Enum currentDay = evaluate_day(day_counter);
                HashMap<String, Enum> lateHashMap = lateEvaluator(employees, currentDay);
                week_memory(day_counter, lateHashMap);
            }
            day_counter += 1;
        }
    }
    
    /**Evaluates the current day*/
    private static Enum evaluate_day(int day_counter) {
        Enum day = null;
        switch (day_counter){
            case 1:
                day =  MONDAY;
                break;
            case 2:
                day =  TUESDAY;
                break;
            case 3:
                day =  WEDNESDAY;
                break;
            case 4:
                day =  THURSDAY;
                break;
            case 5:
                day =  FRIDAY;
                break;
        }
        return day;
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
     * @return The newly updated employee queue for the next day*/
    private static HashMap<String, Enum> lateEvaluator(HashMap<String, Enum> employeeQueue, Enum currentDay) {
        System.out.printf("Day: %s. Who was late today?(Separate names with spaces)", currentDay);
        String lateComers = scannerEmplInput.nextLine();

        employeeQueue.keySet()
                .stream()
                .filter(lateComers::contains)
                .forEach(employeeName -> employeeQueue.put(employeeName, LATE));
        //this is day one, we return who will buy coffee for who next, on Tuesday
        if(day_counter == 1){
            return employeeQueue;
        }else{
            return beneficiary(employeeQueue);
        }
    }

    /**Updates the queue by moving the NEXT flag from the current to the next one in the list
     * The current NEXT will get coffee from the the LATE comer
     * Also removes the LATE flag and replaces it with OTHER
     * @param hashMap the HashMap with the employee queue
     * @return The newly updated queue list with the details of who is the beneficiary*/
    private static HashMap<String, Enum> beneficiary(HashMap<String, Enum> hashMap){
        Optional<String> lateComer;
        Optional<String> beneficiary;

        //collect the late comer
        lateComer = hashMap.keySet().stream().filter(employee -> hashMap.get(employee) == LATE).findFirst();

        //Retrieve the next person from the queue
        beneficiary = hashMap.keySet().stream()
                .filter(employee -> hashMap.get(employee) == NEXT)
                .findFirst();

        //update the list, moving the NEXT flag to OTHER and deleting all LATE flags
        hashMap.keySet().stream()
                .filter(empl -> hashMap.get(empl) == LATE)
                .forEach(empl -> hashMap.put(empl, OTHER));

        //move NEXT to OTHER
        hashMap.keySet().stream()
                .filter(empl -> hashMap.get(empl) == NEXT)
                .forEach(empl -> hashMap.put(empl, OTHER));

        //move first OTHER to NEXT
        //// TODO: edit the first next, moving it to the first NEXT
        hashMap.keySet().stream()
                .filter(employee -> hashMap.get(employee) == OTHER)
                .findFirst()
                .ifPresent(employee -> hashMap.put(employee, NEXT));

        System.out.println(lateComer + " buys coffee for " +  beneficiary);
        return hashMap;
    }

    /**Small 'in-memory db' to store the data for each day for who was late when
     * @param dayNumber The day of the week
     * @param resultForDay This is the result for the day, who will buy coffee for who and who is next*/
    private static HashMap<Enum, HashMap<String, Enum>> week_memory(int dayNumber, HashMap<String, Enum> resultForDay){
        HashMap<Enum, HashMap<String, Enum>> week_queue = new HashMap<>();
        switch (dayNumber){
            case 1:
                week_queue.put(MONDAY,resultForDay);
                break;
            case 2:
                week_queue.put(TUESDAY,resultForDay);
                break;
            case 3:
                week_queue.put(WEDNESDAY,resultForDay);
                break;
            case 4:
                week_queue.put(THURSDAY,resultForDay);
                break;
            case 5:
                week_queue.put(FRIDAY, resultForDay);
                break;
        }

        System.out.println(week_queue);
        return week_queue;
    }
}
