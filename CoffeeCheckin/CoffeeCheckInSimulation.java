package CoffeeCheckin;
import java.util.*;

import static CoffeeCheckin.CheckinMarkers.*;
import static CoffeeCheckin.CheckinMarkers.FRIDAY;

class CoffeeCheckInSimulation {
    private String employeesForWeek;
    private HashMap<String, Enum> coffeeQueue;

    CoffeeCheckInSimulation(String employeesForWeek){
        this.employeesForWeek = employeesForWeek;
    }

    /**Runs the simulation*/
    void run(int day_counter){
        HashMap<String, Enum> employees = employee_queue();
        Enum currentDay = evaluate_day(day_counter);
        HashMap<String, Enum> lateHashMap = lateEvaluator(employees, currentDay);
        week_memory(day_counter, lateHashMap);
    }

    /**Check if the list is empty or one*/
    boolean isListEmptyOrOne() {
        return !getEmployeesForWeek().isEmpty() && getEmployeesForWeek().split(" ").length != 1;
    }

    /**queues the list of employees and add a 'marker' / 'flag',
     * specifying who is next in the list
     * first name on the list is assumed to be next
     * */
    private HashMap<String, Enum> employee_queue() {
        HashMap<String, Enum> employeeHash = new HashMap<>();
        if(!isListEmptyOrOne()) {
            String[] employeeList = getEmployeesForWeek().split(" ");
            // first name on the list is assumed to be NEXT
            employeeHash.put(employeeList[0], NEXT);
            //add the rest of the names
            for (int x = 1; x < employeeList.length; x++) {
                employeeHash.put(employeeList[x], OTHER);
            }
        }
        return employeeHash;
    }

    /**Takes in initial list and new string with late comers and evaluates who will buy coffee
     * Crosschecks the employee queue and the late comers, if the employee names are in the late queue
     * then their 'markers'/'flags' are updated from OTHER to LATE, OR from NEXT to LATE
     * @param employeeQueue the employee queue for the week
     * @return The newly updated employee queue for the next day*/
    private static HashMap<String, Enum> lateEvaluator(HashMap<String, Enum> employeeQueue, Enum currentDay) {
        System.out.printf("%s: Who was late today?(Separate names with spaces)", currentDay);
        Scanner scannerLateInput = new Scanner(System.in);
        String lateComers = scannerLateInput.nextLine();
        String[] lateArr = lateComers.split(" ");

        if(lateArr.length == 1){
            employeeQueue.keySet()
                    .stream()
                    .filter(lateComers::contains)
                    .forEach(employeeName -> employeeQueue.put(employeeName, LATE));
        }else{
            for(String empl : employeeQueue.keySet()){
                for(String late : lateArr){
                    if(empl.equals(late)){
                        employeeQueue.put(empl, LATE);
                    }
                }
            }
        }


        System.out.println("The current queue " + employeeQueue);

        return beneficiary(employeeQueue);
    }

    /**Updates the queue by moving the NEXT flag from the current to the next one in the list
     * The current NEXT will get coffee from the the LATE comer
     * Also removes the LATE flag and replaces it with OTHER
     * @param hashMap the HashMap with the employee queue
     * @return The newly updated queue list with the details of who is the beneficiary*/
    private static HashMap<String, Enum> beneficiary(HashMap<String, Enum> hashMap){
        String lateComer;
        String beneficiary;

        //collect the late comer
        lateComer = hashMap.keySet().stream()
                .filter(employee -> hashMap.get(employee) == LATE)
                .findFirst().toString();

        //Retrieve the next person from the queue
        beneficiary = hashMap.keySet().stream()
                .filter(employee -> hashMap.get(employee) == NEXT)
                .findFirst().toString();

        //update the list, moving the NEXT flag to OTHER
        hashMap.keySet().stream()
                .filter(empl -> hashMap.get(empl) == LATE)
                .forEach(empl -> hashMap.put(empl, OTHER));

        //move NEXT to OTHER
        hashMap.keySet().stream()
                .filter(empl -> hashMap.get(empl) == NEXT)
                .forEach(empl -> hashMap.put(empl, OTHER));

        //move first OTHER to NEXT
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


    String getEmployeesForWeek() {
        return employeesForWeek;
    }

    public void setEmployeesForWeek(String employeesForWeek) {
        this.employeesForWeek = employeesForWeek;
    }
}
