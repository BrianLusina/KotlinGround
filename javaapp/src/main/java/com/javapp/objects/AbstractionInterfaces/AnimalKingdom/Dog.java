package com.javapp.objects.AbstractionInterfaces.AnimalKingdom;

/**
 * java.objects.AbstractionInterfaces.AnimalKingdom
 * Created by lusinabrian on 28/10/16.
 * Description: class that extends the {@link Animal} class
 */
public class Dog extends Animal {

  @Override
  public void eat(String food) {
    System.out.println("Dogs love to eat " + food);
  }

  @Override
  public void makeNoise() {
    System.out.println("Dogs bark a lot more than they should");
  }
}
