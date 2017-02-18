package java.smallprograms.CoffeeCheckin;

import java.util.*;
import java.util.stream.Collectors;

class CoffeeCheckInSimulation {
    private String employeesForWeek;
    private LinkedHashMap<String, Enum> coffeeQueue;

    CoffeeCheckInSimulation(String employeesForWeek) {
        this.employeesForWeek = employeesForWeek;
        this.coffeeQueue = getCoffeeQueue();
    }

    /**
     * Small 'in-memory db' to store the data for each day for who was late when
     *
     * @param dayNumber    The day of the week
     * @param resultForDay This is the result for the day, who will buy coffee for who and who is next
     */
    private static HashMap<Enum, HashMap<String, Enum>> week_memory(
            int dayNumber, HashMap<String, Enum> resultForDay) {

        HashMap<Enum, HashMap<String, Enum>> week_queue = new HashMap<>();
        switch (dayNumber) {
            case 1:
                week_queue.put(CheckinMarkers.MONDAY, resultForDay);
                break;
            case 2:
                week_queue.put(CheckinMarkers.TUESDAY, resultForDay);
                break;
            case 3:
                week_queue.put(CheckinMarkers.WEDNESDAY, resultForDay);
                break;
            case 4:
                week_queue.put(CheckinMarkers.THURSDAY, resultForDay);
                break;
            case 5:
                week_queue.put(CheckinMarkers.FRIDAY, resultForDay);
                break;
        }

        return week_queue;
    }

    /**
     * Evaluates the current day
     */
    private static Enum evaluate_day(int day_counter) {
        Enum day = null;
        switch (day_counter) {
            case 1:
                day = CheckinMarkers.MONDAY;
                break;
            case 2:
                day = CheckinMarkers.TUESDAY;
                break;
            case 3:
                day = CheckinMarkers.WEDNESDAY;
                break;
            case 4:
                day = CheckinMarkers.THURSDAY;
                break;
            case 5:
                day = CheckinMarkers.FRIDAY;
                break;
        }
        return day;
    }

    /**
     * Runs the simulation
     */
    void run(int day_counter) {
        Enum currentDay = evaluate_day(day_counter);
        HashMap<String, Enum> lateHashMap = lateEvaluator(this.coffeeQueue, currentDay);
        week_memory(day_counter, lateHashMap);
    }

    /**
     * Takes in initial list and new string with late comers and evaluates who will buy coffee
     * Crosschecks the employee queue and the late comers, if the employee names are in the late queue
     * then their 'markers'/'flags' are updated from OTHER to LATE, OR from NEXT to LATE
     *
     * @param employeeQueue the employee queue for the week
     * @return The newly updated employee queue for the next day
     */
    private HashMap<String, Enum> lateEvaluator(LinkedHashMap<String, Enum> employeeQueue, Enum currentDay) {
        System.out.printf("%s: Who was late today?(Separate names with spaces)", currentDay);
        Scanner scannerLateInput = new Scanner(System.in);
        String lateComers = scannerLateInput.nextLine();
        String[] lateArr = lateComers.split(" ");

        System.out.printf("Late comers on %s are %s\n", currentDay, Arrays.toString(lateArr));

        //evaluate the length of the late comers and update the queue
        if (lateArr.length == 1) {
            employeeQueue.keySet()
                    .stream()
                    .filter(lateComers::contains)
                    .forEach(employeeName -> employeeQueue.put(employeeName, CheckinMarkers.LATE));
        } else {
            for (String empl : employeeQueue.keySet()) {
                for (String late : lateArr) {
                    if (empl.equalsIgnoreCase(late)) {
                        employeeQueue.put(empl, CheckinMarkers.LATE);
                    }
                }
            }
        }

        return beneficiary(employeeQueue);
    }

    /**
     * Updates the queue by moving the NEXT flag from the current to the next one in the list
     * The current NEXT will get coffee from the the LATE comer
     * Also removes the LATE flag and replaces it with OTHER
     *
     * @param linkedHashMap the HashMap with the employee queue
     * @return The newly updated queue list with the details of who is the beneficiary
     */
    private HashMap<String, Enum> beneficiary(LinkedHashMap<String, Enum> linkedHashMap) {
        ArrayList<String> lateComer = new ArrayList<>();
        final String[] beneficiary = new String[1];

        //collect the late comer(s)
        lateComer.addAll(
                linkedHashMap.keySet()
                        .stream()
                        .filter(late -> linkedHashMap.get(late) == CheckinMarkers.LATE)
                        .collect(Collectors.toList())
        );

        //check if the NEXT person is late, move the beneficiary down the list
        for (String fortfeit : linkedHashMap.keySet()) {
            for (String aLateComer : lateComer) {
                if (linkedHashMap.get(fortfeit) == CheckinMarkers.NEXT && aLateComer.equalsIgnoreCase(fortfeit)) {
                    linkedHashMap.keySet()
                            .stream()
                            .filter(other -> linkedHashMap.get(other) == CheckinMarkers.OTHER)
                            .findFirst()
                            .ifPresent(next -> linkedHashMap.put(next, CheckinMarkers.NEXT));
                }
            }
        }

        //Retrieve the next person from the queue
        linkedHashMap.keySet()
                .stream()
                .filter(benefit -> linkedHashMap.get(benefit) == CheckinMarkers.NEXT)
                .forEach(benefit -> {
                    beneficiary[0] = benefit;
                    linkedHashMap.put(benefit, CheckinMarkers.DONE);
                });

        //remove late flags, replace with other
        linkedHashMap.keySet()
                .stream()
                .filter(lateOrNext -> linkedHashMap.get(lateOrNext) == CheckinMarkers.LATE)
                .forEach(late -> linkedHashMap.put(late, CheckinMarkers.OTHER));

        //move NEXT down the list
        linkedHashMap.keySet()
                .stream()
                .filter(other -> linkedHashMap.get(other) == CheckinMarkers.OTHER)
                .findFirst()
                .ifPresent(next -> linkedHashMap.put(next, CheckinMarkers.NEXT));

        System.out.printf("Queue for tomorrow: %s\n", linkedHashMap);

        setCoffeeQueue(linkedHashMap);

        System.out.println(lateComer.get(0) + " buys coffee for " + beneficiary[0]);
        return linkedHashMap;
    }

    /**
     * This sets the coffee queue for the week from the user input
     * Returns the coffee queue for the week
     */
    private LinkedHashMap<String, Enum> getCoffeeQueue() {
        LinkedHashMap<String, Enum> employeeQueue = new LinkedHashMap<>();
        String[] employeeList = this.employeesForWeek.split(" ");
        // first name on the list is assumed to be NEXT
        employeeQueue.put(employeeList[0], CheckinMarkers.NEXT);
        //add the rest of the names
        for (int x = 1; x < employeeList.length; x++) {
            employeeQueue.put(employeeList[x], CheckinMarkers.OTHER);
        }

        return employeeQueue;
    }

    /**
     * Updates the coffee queue
     */
    private void setCoffeeQueue(LinkedHashMap<String, Enum> coffeeQueue) {
        this.coffeeQueue = coffeeQueue;
    }
}
