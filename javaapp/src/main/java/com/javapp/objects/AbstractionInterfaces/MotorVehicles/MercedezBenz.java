package com.javapp.objects.AbstractionInterfaces.MotorVehicles;

/**
 * java.objects.AbstractionInterfaces.MotorVehicles
 * Created by lusinabrian on 28/10/16.
 * Description: Subclass of {@link Cars}
 */

class MercedezBenz extends Cars {

  /**
   * Constructor for vehicles
   *
   * @param name Name of vehicle
   * @param model Model of vehicle
   */
  MercedezBenz(String name, String model) {
    super(name, model);
  }

  @Override
  String manufacturer() {
    return "Mercedez Benz";
  }

  @Override
  void dateOfManufacture() {

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

  @Override
  public void hasStereo(boolean hasStereo) {
    System.out.print(hasStereo);
  }

  @Override
  public String bodyColor(String color) {
    return color;
  }
}
