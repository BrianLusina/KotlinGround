package ObjectOriented.Bicycle;

/**
 * ObjectOriented.Bicycle
 * Created by lusinabrian on 02/11/16.
 * Description: Bicycle Class which will be the superclass describing all bicycles in existence
 */
public class Bicycle {
    //fields/ states of bicycles
    private int currentGear, currentSpeed,currentPedal;

    public Bicycle() {}

    /**Constructor for all bicycles*/
    public Bicycle(int currentGear, int currentSpeed, int currentPedal) {
        this.currentGear = currentGear;
        this.currentSpeed = currentSpeed;
        this.currentPedal = currentPedal;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "currentGear=" + currentGear +
                ", currentSpeed=" + currentSpeed +
                ", currentPedal=" + currentPedal +
                '}';
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentPedal() {
        return currentPedal;
    }

    public void setCurrentPedal(int currentPedal) {
        this.currentPedal = currentPedal;
    }
}
