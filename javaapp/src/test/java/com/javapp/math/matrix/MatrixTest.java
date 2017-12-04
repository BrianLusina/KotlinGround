package com.javapp.math.matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Enclosed.class)
public class MatrixTest {

  @RunWith(Parameterized.class)
  public static class CountRowsTest {

    private Matrix matrix;
    private int numberOfRows;

    public CountRowsTest(String matrixAsString, int numberOfRows) {
      this.matrix = new Matrix(matrixAsString);
      this.numberOfRows = numberOfRows;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {"0", 1},
          {"0 1", 1},
          {"0\n"
              + "1", 2},
          {"0 1\n"
              + "2 3", 2},
          {"0 1 2\n"
              + "3 4 5\n"
              + "6 7 8", 3}
      });
    }

    @Test
    public void countRowsTest() {
      assertEquals(numberOfRows, matrix.getRowsCount());
    }
  }

  @RunWith(Parameterized.class)
  public static class CountColumnsTest {

    private Matrix matrix;
    private int numberOfColumns;

    public CountColumnsTest(String matrixAsString, int numberOfColumns) {
      this.matrix = new Matrix(matrixAsString);
      this.numberOfColumns = numberOfColumns;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {"0", 1},
          {"0 1", 2},
          {"0\n"
              + "1", 1},
          {"0 1\n"
              + "2 3", 2},
          {"0 1 2\n"
              + "3 4 5\n"
              + "6 7 8", 3}
      });
    }

    @Test
    public void countColumnsTest() {
      assertEquals(numberOfColumns, matrix.getColumnsCount());
    }
  }

  @RunWith(Parameterized.class)
  public static class GetFirstRowTest {

    private Matrix matrix;
    private int[] firstRow;

    public GetFirstRowTest(String matrixAsString, int[] firstRow) {
      this.matrix = new Matrix(matrixAsString);
      this.firstRow = firstRow;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {"0", new int[]{0}},
          {"0 1", new int[]{0, 1}},
          {"0\n"
              + "1", new int[]{0}},
          {"0 1\n"
              + "2 3", new int[]{0, 1}},
          {"0 1 2\n"
              + "3 4 5\n"
              + "6 7 8", new int[]{0, 1, 2}}
      });
    }

    @Test
    public void getFirstRowTest() {
      assertArrayEquals(firstRow, matrix.getRow(0));
    }
  }

  @RunWith(Parameterized.class)
  public static class GetLastRowTest {

    private Matrix matrix;
    private int[] lastRow;

    public GetLastRowTest(String matrixAsString, int[] lastRow) {
      this.matrix = new Matrix(matrixAsString);
      this.lastRow = lastRow;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {"0", new int[]{0}},
          {"0 1", new int[]{0, 1}},
          {"0\n"
              + "1", new int[]{1}},
          {"0 1\n"
              + "2 3", new int[]{2, 3}},
          {"0 1 2\n"
              + "3 4 5\n"
              + "6 7 8", new int[]{6, 7, 8}}
      });
    }

    @Test
    public void getLastRowTest() {
      assertArrayEquals(lastRow, matrix.getRow(matrix.getRowsCount() - 1));
    }
  }

  @RunWith(Parameterized.class)
  public static class GetFirstColumnTest {

    private Matrix matrix;
    private int[] firstColumn;

    public GetFirstColumnTest(String matrixAsString, int[] firstColumn) {
      this.matrix = new Matrix(matrixAsString);
      this.firstColumn = firstColumn;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {"0", new int[]{0}},
          {"0 1", new int[]{0}},
          {"0\n"
              + "1", new int[]{0, 1}},
          {"0 1\n"
              + "2 3", new int[]{0, 2}},
          {"0 1 2\n"
              + "3 4 5\n"
              + "6 7 8", new int[]{0, 3, 6}}
      });
    }

    @Test
    public void getFirstColumnTest() {
      assertArrayEquals(firstColumn, matrix.getColumn(0));
    }
  }


  @RunWith(Parameterized.class)
  public static class GetLastColumnTest {

    private Matrix matrix;
    private int[] lastColumn;

    public GetLastColumnTest(String matrixAsString, int[] lastColumn) {
      this.matrix = new Matrix(matrixAsString);
      this.lastColumn = lastColumn;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {"0", new int[]{0}},
          {"0 1", new int[]{1}},
          {"0\n"
              + "1", new int[]{0, 1}},
          {"0 1\n"
              + "2 3", new int[]{1, 3}},
          {"0 1 2\n"
              + "3 4 5\n"
              + "6 7 8", new int[]{2, 5, 8}}
      });
    }

    @Test
    public void getLastColumnTest() {
      assertArrayEquals(lastColumn, matrix.getColumn(matrix.getColumnsCount() - 1));
    }
  }
}