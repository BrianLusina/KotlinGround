package main.objects.Bicycle;

/**
 * objects.Bicycle
 * Created by lusinabrian on 02/11/16.
 * Description:Interface for {@link Bicycle}
 */
interface BicycleInterface {
    //  wheel revolutions per minute
    void changeCadence(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}
