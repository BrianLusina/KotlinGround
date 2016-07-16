package DataStructures.OOP;
/**Demonstration of OOP
 * This is a car class with a constructor to define its objects on creation
 * the getters and setters have been defined to allow the object's fields or states to be modified by
 * the instance.
* */

public class Car {
    private int wheels;
    private int engineCapacity;
    private int seats;
    private String name;

    /**Constructor for the Car class*/
    public Car(int wheels, int engineCapacity, int seats, String name){
        this.wheels = wheels;
        this.engineCapacity = engineCapacity;
        this.seats = seats;
        this.name = name;
    }

    /**ACCESSORS AND MODIFIERS getters and setters*/

    /*get and set wheels*/
    public int getWheels(){
        return wheels;
    }

    public void setWheels(int wheels){
        this.wheels = wheels;
    }

    /*set and get the engine capacity*/
    public int getEngineCapacity(){
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity){
        this.engineCapacity = engineCapacity;
    }

    /*getters and setters for the seats*/
    public int getSeats(){
        return seats;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    /*get and set the name*/
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
