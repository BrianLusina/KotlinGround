package DataStructures.OOP;
/**
 * Created by lusinabrian on 05/07/16.
 * This class tests the functions/ getters and setters for the Car class
 */
public class CarTest {
    public static void main(String[] args){
        Car merc = new Car(4, 3500, 5, "Mercedez Benz");
        Car toyota = new Car(4, 1200, 5, "Allion");

        /*The getters allows the private variables to be accessed from the constructor*/
        System.out.printf("This is a %s with %d wheels, %d seats and an engine capacity of %d CC \n", toyota.getName(), toyota.getWheels(), toyota.getSeats(),toyota.getEngineCapacity()); //output is This is a Allion with 4 wheels, 5 seats and an engine capacity of 1200

        System.out.printf("This is a %s with %d wheels, %d seats and an engine capacity of %d CC \n", merc.getName(), merc.getWheels(), merc.getSeats(),merc.getEngineCapacity());
        //output is This is a Mercedez Benz with 4 wheels, 5 seats and an engine capacity of 3500 CC

        /*the setters modify the states or fields of the object*/
        merc.setName("Mercedes SLS");
        merc.setEngineCapacity(4500);
        merc.setWheels(4);
        merc.setSeats(2);

        /*these have been modified from the previous states to the current states as described below*/
        System.out.printf("This is a %s with %d wheels, %d seats and an engine capacity of %d CC \n", merc.getName(), merc.getWheels(), merc.getSeats(),merc.getEngineCapacity());
        //output is This is a Mercedes SLS with 4 wheels, 2 seats and an engine capacity of 4500 CC

        //below lines modify the toyota object
        toyota.setName("Toyota Celica");
        toyota.setEngineCapacity(2500);
        toyota.setWheels(4);
        toyota.setSeats(2);

        /*these have been modified from the previous states to the current states as described below*/
        System.out.printf("This is a %s with %d wheels, %d seats and an engine capacity of %d CC", toyota.getName(), toyota.getWheels(), toyota.getSeats(),toyota.getEngineCapacity());
        //output is: This is a Toyota Celica with 4 wheels, 2 seats and an engine capacity of 2500 CC

    }
}
