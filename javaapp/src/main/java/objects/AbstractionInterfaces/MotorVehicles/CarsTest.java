package java.objects.AbstractionInterfaces.MotorVehicles;

/**
 * java.objects.AbstractionInterfaces.MotorVehicles
 * Created by lusinabrian on 28/10/16.
 * Description:
 */
public class CarsTest {
    public static void main(String[] args) {
        VehicleInterface vehicleInterface = new MercedezBenz("S class", "sclass1200");

        vehicleInterface.bodyColor("black");
        vehicleInterface.hasStereo(true);
    }
}
