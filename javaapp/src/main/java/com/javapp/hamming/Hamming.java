package com.javapp.hamming;

public class Hamming {

  public static int compute(String dnaStrand1, String dnaStrand2) {
    int count = 0;
    String[] d1 = dnaStrand1.split("");
    String[] d2 = dnaStrand2.split("");
    if (dnaStrand1.length() != dnaStrand2.length()) {
      throw new IllegalArgumentException(
          dnaStrand1 + " and " + dnaStrand2 + " are of different lengths.");
    } else {
      for (int x = 0; x < d1.length; x++) {
        if (!d1[x].equals(d2[x])) {
          count += 1;
        }
      }
    }
    return count;
  }
}
