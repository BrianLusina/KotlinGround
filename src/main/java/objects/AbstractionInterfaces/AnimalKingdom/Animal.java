package ObjectOriented.AbstractionInterfaces.AnimalKingdom;

/**
 * ObjectOriented.AbstractionInterfaces
 * Created by lusinabrian on 28/10/16.
 * Description:Abstract class for the animal kingdom
 */
abstract class Animal {

    /**
     * Types of food the animals eat
     */
    public abstract void eat(String food);

    /**
     * How long the anima will sleep
     */
    public void sleep(int hours) {
        try {
            // 1000 milliseconds * 60 seconds * 60 minutes * hours
            Thread.sleep(1000 * 60 * 60 * hours);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * The sound the animals make
     */
    public abstract void makeNoise();
}
