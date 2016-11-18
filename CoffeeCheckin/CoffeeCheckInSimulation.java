package CoffeeCheckin;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import CoffeeCheckin.CoffeeCheckinMarkers;

public class CoffeeCheckInSimulation {

    public static void main(String[] args){
        System.out.println("Hello, welcome to Coffee Check-in, please enter list of employees for the week( separate names with a space)");
        Scanner scannerEmplInput = new Scanner(System.in);
        employee_queue(scannerEmplInput.nextLine());

        System.out.println("Who was late today?(Separate names with spaces)");
        String late_comers = scannerEmplInput.nextLine();

        //late_evaluater(employee_queue(employee_list), late_comers);
    }

    /**queues the list of employees and add a 'marker', specifying who is next in the list*/
    private static ArrayList<String> employee_queue(String employee_list) {
        HashMap<String, Enum> employeeMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, employee_list.split(" "));
        return list;
    }

    /**Takes in initial list and new string with late comers and evaluates who will buy coffee*/
    private static ArrayList<String> late_evaluater(ArrayList<String> queue, String late_comers) {
        ArrayList<String> updated_list = new ArrayList<>();
        for(String late: late_comers.split(" ")){
            for(String q: queue){

            }
        }

        return updated_list;
    }
}
