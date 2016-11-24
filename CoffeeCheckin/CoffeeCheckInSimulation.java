package CoffeeCheckin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    /**queues the list of employees and add a 'marker' / 'flag',
     * specifying who is next in the list
     * first name on the list is assumed to be next
     * */
    private HashMap<String, Enum> employee_queue() {
        HashMap<String, Enum> employeeHash = new HashMap<>();
        String[] employeeList = getEmployeesForWeek().split(" ");
        // first name on the list is assumed to be NEXT
        employeeHash.put(employeeList[0], NEXT);
        //add the rest of the names
        for (int x = 1; x < employeeList.length; x++) {
            employeeHash.put(employeeList[x], OTHER);
        }
        System.out.println("Employee Q: " + employeeHash);
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

        System.out.printf("Late comers on %s are %s\n",currentDay, Arrays.toString(lateArr));

        //evaluate the length of the late comers and update the queue
        if(lateArr.length == 1){
            employeeQueue.keySet()
                    .stream()
                    .filter(lateComers::contains)
                    .forEach(employeeName -> employeeQueue.put(employeeName, LATE));
        }else{
            for(String empl : employeeQueue.keySet()){
                for(String late : lateArr){
                    if(empl.equalsIgnoreCase(late)){
                        employeeQueue.put(empl, LATE);
                    }
                }
            }
        }

        return beneficiary(employeeQueue);
    }

    /**Updates the queue by moving the NEXT flag from the current to the next one in the list
     * The current NEXT will get coffee from the the LATE comer
     * Also removes the LATE flag and replaces it with OTHER
     * @param hashMap the HashMap with the employee queue
     * @return The newly updated queue list with the details of who is the beneficiary*/
    private static HashMap<String, Enum> beneficiary(HashMap<String, Enum> hashMap){
        ArrayList<String> lateComer = new ArrayList<>();
        final String[] beneficiary = new String[1];

        //collect the late comer(s)
        lateComer.addAll(
                hashMap.keySet()
                        .stream()
                        .filter(late -> hashMap.get(late) == LATE)
                        .collect(Collectors.toList())
        );

        //Retrieve the next person from the queue
        hashMap.keySet()
                .stream()
                .filter(benefit -> hashMap.get(benefit) == NEXT)
                .forEach(benefit -> beneficiary[0] = benefit);

        //move first OTHER to NEXT
        hashMap.keySet()
                .stream()
                .filter(emplOther -> hashMap.get(emplOther) == OTHER)
                .findFirst()
                .ifPresent(emplOther -> hashMap.put(emplOther, NEXT));

        //move first NEXT to OTHER
        hashMap.keySet()
                .stream()
                .filter(name -> hashMap.get(name) == NEXT)
                .findFirst()
                .ifPresent(emplOther -> hashMap.put(emplOther, OTHER));

        System.out.printf("Current Map: %s\n", hashMap);
        System.out.println(lateComer.get(0) + " buys coffee for " + beneficiary[0]);
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


    private String getEmployeesForWeek() {
        return employeesForWeek;
    }

    public void setEmployeesForWeek(String employeesForWeek) {
        this.employeesForWeek = employeesForWeek;
    }
}
