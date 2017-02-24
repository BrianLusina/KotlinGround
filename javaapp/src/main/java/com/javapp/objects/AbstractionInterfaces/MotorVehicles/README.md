# Demonstrating Abstraction in MotorVehicles

Vehicles is the main class which is abstract, it contains the constructor that will be inherited by all subclasses.

This demonstrates that Abstract classes can have constructors that can be inherited.

This is the hierarchy: 

                                            Vehicle implments VehicleInterface
                                               |
                                              Cars
                                               |
                                          MercedezBenz

MercedezBenz can now override the methods from both Cars and Vehicle abstract classes.