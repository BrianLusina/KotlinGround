package AbstractionInterfaces.MotorVehicles;

/**
 * AbstractionInterfaces.MotorVehicles
 * Created by lusinabrian on 28/10/16.
 * Description: Subclass of {@link Cars}
 */

public class MercedezBenz extends Cars{
    /**
     * Constructor for vehicles
     * @param name  Name of vehicle
     * @param model Model of vehicle
     */
    MercedezBenz(String name, String model) {
        super(name, model);
    }

    @Override
    void manufacturer(String name) {

    }

    @Override
    void dateOfManufacture(String name) {

    }

    @Override
    void speed(int maxSpeed) {

    }

    @Override
    void numberOfWheels(int wheels) {

    }

    @Override
    void engineCapacity(int capacity) {

    }

    @Override
    void numberOfSeats(int seats) {

    }
}
