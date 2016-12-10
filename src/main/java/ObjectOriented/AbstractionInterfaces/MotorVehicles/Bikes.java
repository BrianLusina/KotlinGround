package ObjectOriented.AbstractionInterfaces.MotorVehicles;

/**
 * ObjectOriented.AbstractionInterfaces.MotorVehicles
 * Created by lusinabrian on 28/10/16.
 * Description: Subclass of {@link Vehicles}
 */
abstract class Bikes extends Vehicles {

    /**
     * Constructor for vehicles
     *
     * @param name  Name of vehicle
     * @param model Model of vehicle
     */
    Bikes(String name, String model) {
        super(name, model);
    }


}
