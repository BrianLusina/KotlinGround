package com.javapp.math.pascalstriangle;

import java.util.Arrays;

/*** @author lusinabrian on 26/04/17.*/
public class PascalsTriangle {
    /**
     * Computes the given triangle*/
    public static int[][] computeTriangle(int rows) {
        // sanity check
        if(rows < 0){
            throw new IllegalArgumentException("Rows can't be negative!");
        }
        // base case
        if(rows == 0){
            return new int[][];
        }
        return new int[0][];
    }

    /**
     * Check if a triangle is valid based on pascal
     * @param triangle array with a pascall triangle
     * @return {@link Boolean} true/false*/
    public static boolean isTriangle(int[][] triangle){
        return Arrays.deepEquals(triangle, computeTriangle(triangle.length));
    }
}
