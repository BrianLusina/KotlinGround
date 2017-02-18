package java.objects.Bicycle;

/**
 * java.objects.Bicycle
 * Created by lusinabrian on 02/11/16.
 * Description: Bicycle Class which will be the superclass describing all bicycles in existence
 */
class Bicycle implements BicycleInterface {
    //fields/ states of bicycles
    private int currentGear, currentSpeed, currentPedal, yearMade;
    private String name, model;

    Bicycle(int currentGear, int currentSpeed, int currentPedal, int yearMade, String name, String model) {
        this.currentGear = currentGear;
        this.currentSpeed = currentSpeed;
        this.currentPedal = currentPedal;
        this.yearMade = yearMade;
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "currentGear=" + currentGear +
                ", currentSpeed=" + currentSpeed +
                ", currentPedal=" + currentPedal +
                ", yearMade=" + yearMade +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        this.currentSpeed += currentSpeed;
    }

    public int getCurrentPedal() {
        return currentPedal;
    }

    public void setCurrentPedal(int currentPedal) {
        this.currentPedal = currentPedal;
    }

    @Override
    public void changeCadence(int newValue) {
        this.setCurrentPedal(newValue);
    }

    @Override
    public void changeGear(int newValue) {
        this.setCurrentGear(newValue);
    }

    @Override
    public void speedUp(int increment) {
        this.setCurrentSpeed(increment);
    }

    @Override
    public void applyBrakes(int decrement) {
        this.setCurrentSpeed(decrement);
    }
}
