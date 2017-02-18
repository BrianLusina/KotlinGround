package com.javapp.algorithms.triangle;

/**
 * Created by lusinabrian on 16/07/16.
 * Checks the kind of java.java.algorithms.triangle based on length of sides given.
 */
public class Triangle {
    private double side1, side2, side3;

    /*constructor*/
    public Triangle(double side1, double side2, double side3) throws TriangleException {
        if ((side1 <= 0 || side2 <= 0 || side3 <= 0) || ((side1 + side2 <= side3) || ((side2 + side3 <= side1))) || ((side1 + side3 <= side2))) {
            throw new TriangleException();
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    /*return kind of java.java.algorithms.triangle*/
    public TriangleKind getKind() {
        if (getSide1() == getSide2() && getSide2() == getSide3()) {
            return TriangleKind.EQUILATERAL;
        } else if ((getSide1() == getSide2() && getSide2() != getSide3()) || (getSide2() == getSide3() && getSide3() != getSide1()) || (getSide1() == getSide3() && getSide1() != getSide2())) {
            return TriangleKind.ISOSCELES;
        } else {
            return TriangleKind.SCALENE;
        }
    }

    /*GETTERS AND SETTERS*/
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

/*CLASS END*/
}
