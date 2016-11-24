package CoffeeCheckin;

import java.util.Scanner;

public class CoffeeCheckInMain {
    private static int day_counter = 1;

    public static void main(String[] args){
        System.out.println("Hello, welcome to Coffee Check-in. Please enter list of employees for the week( separate names with a space)");
        Scanner scannerEmplInput = new Scanner(System.in);
        String employeeList = scannerEmplInput.nextLine();

        // perform check before creating objects
        if(employeeList.isEmpty() || employeeList.split(" ").length == 1){
            System.out.println("No employees this week.");
            System.exit(1);
        }else{
            CoffeeCheckInSimulation coffeeCheck = new CoffeeCheckInSimulation(employeeList);
            while(day_counter <= 5){
                //initialize coffee check-in
                coffeeCheck.run(day_counter);
                day_counter += 1;
            }
        }
    }
}
