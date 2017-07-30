package com.javapp.math.RomanNumerals;

import static org.testng.AssertJUnit.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RomanNumeralTest {

  private int input;
  private String expectedOutput;

  public RomanNumeralTest(int input, String expectedOutput) {
    this.input = input;
    this.expectedOutput = expectedOutput;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0, ""},
        {1, "I"},
        {2, "II"},
        {3, "III"},
        {4, "IV"},
        {5, "V"},
        {6, "VI"},
        {9, "IX"},
        {27, "XXVII"},
        {48, "XLVIII"},
        {59, "LIX"},
        {93, "XCIII"},
        {141, "CXLI"},
        {163, "CLXIII"},
        {402, "CDII"},
        {575, "DLXXV"},
        {911, "CMXI"},
        {1024, "MXXIV"},
        {3000, "MMM"}
    });
  }

  @org.junit.Test
  public void convertArabicNumberalToRomanNumeral() {
    RomanNumeral romanNumeral = new RomanNumeral(input);

    assertEquals(expectedOutput, romanNumeral.getRomanNumeral());
  }
}
