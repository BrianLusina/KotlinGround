package CoffeeCheckin;

import java.util.HashMap;
import java.util.Scanner;

import static CoffeeCheckin.CheckinMarkers.*;
import static CoffeeCheckin.CheckinMarkers.FRIDAY;

public class CoffeeCheckInMain {
    private static Scanner scannerEmplInput;
    private static int day_counter = 1;

    public static void main(String[] args){
        System.out.println("Hello, welcome to Coffee Check-in. Please enter list of employees for the week( separate names with a space)");
        scannerEmplInput = new Scanner(System.in);
        String employeeList = scannerEmplInput.nextLine();
        
        
        //add the list to a queue and store in a variable
        while(day_counter <= 5){
            //if the list is empty exit the program, else continue execution
            if(isListEmptyOrOne(employeeList)){
                System.out.println("Employee List is empty. No one is coming in this week. Free week!");
                System.exit(1);
            }else{
                //initialize coffee check-in
                CoffeeCheckInSimulation coffeeCheck = new CoffeeCheckInSimulation(employeeList);
                coffeeCheck.run(day_counter);
            }
            day_counter += 1;
        }
    }
    /**Check if the list is empty or one*/
    private static boolean isListEmptyOrOne(String employeeList) {
        return !employeeList.isEmpty() && employeeList.split(" ").length != 1;
    }

}
