package com.javapp.enums;

/**
 * com.javapp.enums
 * Created by lusinabrian on 03/03/17.
 * Description:
 *  Planet is an enum type that represents the planets in the solar system.
 *  They are defined with constant mass and radius properties.
 *  Each enum constant is declared with values for the mass and radius parameters.
 *  These values are passed to the constructor when the constant is created.
 *  Java requires that the constants be defined first, prior to any fields or methods.
 *  Also, when there are fields and methods, the list of enum constants must end with a semicolon.
 *
 *  Run this command on Planet.class
 *  java Planet <Value>
 */
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS (4.869e+24, 6.0518e6),
    EARTH (5.976e+24, 6.37814e6),
    MARS (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN (5.688e+26, 6.0268e7),
    URANUS (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    // sorry PLUTO :(

    // fields
    private final double mass;
    private final double radius;

    /**
     * Planet constructor wth mass and radius of each planet
     * @param mass mass of planet in kilograms
     * @param radius radius of plant in meters
     * */
    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity(){
        return G * mass / (radius * radius);
    }

    double surfaceWeight(double otherMass){
        return otherMass * surfaceGravity();
    }

    public static void main(String[] args){
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();

        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}
