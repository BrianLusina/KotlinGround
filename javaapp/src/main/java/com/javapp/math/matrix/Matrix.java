package com.javapp.math.matrix;

import java.util.regex.Pattern;

public class Matrix {
    private int[][] matrix;
    private static Pattern spacePattern = Pattern.compile(" ");
    private static Pattern newlinePattern = Pattern.compile("\\n");

    public Matrix(String matrixAsString){
        String[] rows = newlinePattern.split(matrixAsString);
        matrix = new int[rows.length][];
        for(int x = 0; x < rows.length; x++){
            String[] columns = spacePattern.split(rows[x]);
            matrix[x] = new int[columns.length];
            for(int y = 0; y < columns.length; y++){
                matrix[x][y] = Integer.parseInt(columns[y]);
            }
        }
    }

    public int[] getRow(int rowNumber){
        return matrix[rowNumber];
    }

    public int[] getColumn(int columnNumber){
        int[] column = new int[matrix.length];
        for(int x = 0; x < matrix.length; x++){
            column[x] = matrix[x][columnNumber];
        }
        return column;
    }

    public int getRowsCount(){
        return matrix.length;
    }

    public int getColumnsCount(){
        return matrix[0].length;
    }
}
