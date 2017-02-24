package com.javapp.algorithms.triangle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TriangleTest extends TestCase {
    public TriangleTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    @org.junit.Test
    public void equilateralTriangleHaveEqualSides() throws Exception {
        Triangle triangle = new Triangle(2, 2, 2);

        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @org.junit.Test
    public void largerEquilateralTrianglesAlsoHaveEqualSides() throws Exception {
        Triangle triangle = new Triangle(10, 10, 10);

        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @org.junit.Test
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws Exception {
        Triangle triangle = new Triangle(3, 4, 4);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @org.junit.Test
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws Exception {
        Triangle triangle = new Triangle(4, 3, 4);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @org.junit.Test
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws Exception {
        Triangle triangle = new Triangle(4, 4, 3);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @org.junit.Test
    public void isoscelesTrianglesHaveInFactExactlyTwoSidesEqual() throws Exception {
        Triangle triangle = new Triangle(10, 10, 2);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @org.junit.Test
    public void scaleneTrianglesHaveNoEqualSides() throws Exception {
        Triangle triangle = new Triangle(3, 4, 5);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @org.junit.Test
    public void scaleneTrianglesHaveNoEqualSidesAtLargerScaleEither() throws Exception {
        Triangle triangle = new Triangle(10, 11, 12);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @org.junit.Test
    public void scaleneTrianglesHaveNoEqualSidesInDescendingOrderEither() throws Exception {
        Triangle triangle = new Triangle(5, 4, 2);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @org.junit.Test
    public void verySmallTrianglesAreLegal() throws Exception {
        Triangle triangle = new Triangle(0.4, 0.6, 0.3);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @org.junit.Test(expected = TriangleException.class)
    public void trianglesWithNoSizeAreIllegal() throws Exception {
        new Triangle(0, 0, 0);
    }

    @org.junit.Test(expected = TriangleException.class)
    public void trianglesWithNegativeSidesAreIllegal() throws Exception {
        new Triangle(3, 4, -5);
    }

    @org.junit.Test(expected = TriangleException.class)
    public void trianglesViolatingTriangleInequalityAreIllegal() throws Exception {
        new Triangle(1, 1, 3);
    }

    @org.junit.Test(expected = TriangleException.class)
    public void trianglesViolatingTriangleInequalityAreIllegal2() throws Exception {
        new Triangle(2, 4, 2);
    }

    @org.junit.Test(expected = TriangleException.class)
    public void trianglesViolatingTriangleInequalityAreIllegal3() throws Exception {
        new Triangle(7, 3, 2);
    }    public static Test suite() {
        return new TestSuite(TriangleTest.class);
    }
}
