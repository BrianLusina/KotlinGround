package com.javapp.objects.AbstractionInterfaces.MotorVehicles;

/**
 * java.objects.AbstractionInterfaces.MotorVehicles
 * Created by lusinabrian on 28/10/16.
 * Description: Abstract class for all the motor vehicles
 */

abstract class Vehicles implements VehicleInterface {

  /**
   * Constructor for vehicles
   *
   * @param name Name of vehicle
   * @param model Model of vehicle
   */
  Vehicles(String name, String model) {
  }

  /**
   * Speed of the Vehicle
   *
   * @param maxSpeed The maximum speed this vehicle can attain
   */
  abstract void speed(int maxSpeed);

  /**
   * The number of wheels of the vehicle
   *
   * @param wheels Number of wheels of the vehicle
   */
  abstract void numberOfWheels(int wheels);

  /**
   * Engine Capacity
   *
   * @param capacity Engine capacity
   */
  abstract void engineCapacity(int capacity);

  /**
   * Number of passengers this vehicle can accomodate
   *
   * @param seats Number of seats
   */
  abstract void numberOfSeats(int seats);

  /**
   * Implemented when the car is moving, the gear it will change to
   */
  void changeGear(int number) {

  }

}
