package java.objects.Bicycle;

/**
 * java.objects.Bicycle
 * Created by lusinabrian on 02/11/16.
 * Description:Demonstrating inheritance of superclass {@link Bicycle}
 */
public class BicycleDemo {
    public static void main(String[] args) {
        // create an object MountainBike
        MountainBike mountainBike = new MountainBike(0, 2, 1, 2000, "Panther", "X58");

        // displaying current state of the bicycle
        System.out.println("Current state of " + mountainBike.getName());
        System.out.println("Current Gear: " + mountainBike.getCurrentGear());
        System.out.println("Current Pedal: " + mountainBike.getCurrentPedal());
        System.out.println("Current Speed: " + mountainBike.getCurrentSpeed());
        System.out.println("Model: " + mountainBike.getModel());
        System.out.println("Name: " + mountainBike.getName());
        System.out.println("Year Made " + mountainBike.getYearMade());

        //changing current state by interacting with the interface
        System.out.println("Interacting with Bicycle through interface...");
        mountainBike.changeCadence(2);
        mountainBike.changeGear(1);
        mountainBike.speedUp(50);
        mountainBike.applyBrakes(5);

        // displaying current state of the bicycle after interaction
        System.out.println("Current state of " + mountainBike.getName() + " after interaction");
        System.out.println("Current Gear: " + mountainBike.getCurrentGear());
        System.out.println("Current Pedal: " + mountainBike.getCurrentPedal());
        System.out.println("Current Speed: " + mountainBike.getCurrentSpeed());
        System.out.println("Model: " + mountainBike.getModel());
        System.out.println("Name: " + mountainBike.getName());
        System.out.println("Year Made: " + mountainBike.getYearMade());


    }
}
