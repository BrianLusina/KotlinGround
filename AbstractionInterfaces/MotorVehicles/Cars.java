package AbstractionInterfaces.MotorVehicles;

/**
 * AbstractionInterfaces.MotorVehicles
 * Created by lusinabrian on 28/10/16.
 * Description: Subclass of {@link Vehicles}
 */
abstract class Cars extends Vehicles{
    /**
     * Constructor for vehicles
     * @param name  Name of vehicle
     * @param model Model of vehicle
     */
    Cars(String name, String model) {
        super(name, model);
    }

    /**Name of the manufacturer*/
    abstract String manufacturer();


    /**Date of manufacture*/
    abstract void dateOfManufacture();

}
