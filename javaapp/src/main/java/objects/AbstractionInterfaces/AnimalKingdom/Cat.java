package main.objects.AbstractionInterfaces.AnimalKingdom;

/**
 * java.objects.AbstractionInterfaces.AnimalKingdom
 * Created by lusinabrian on 28/10/16.
 * Description: cat class that extends {@link Animal}
 */
public class Cat extends Animal {
    @Override
    public void eat(String food) {
        System.out.println("Cats eat " + food);
    }

    @Override
    public void makeNoise() {
        System.out.println("Cats meow a lot");
    }
}
