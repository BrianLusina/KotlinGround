package com.javapp.stringswords.twelvedays;


public class TwelveDays {

  private static String[] days = new String[]{
      "first", "second", "third", "fourth", "fifth", "sixth",
      "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"
  };
  private static String[] gifts = new String[]{
      "a Partridge in a Pear Tree.",
      "two Turtle Doves, ",
      "three French Hens, ",
      "four Calling Birds, ",
      "five Gold Rings, ",
      "six Geese-a-Laying, ",
      "seven Swans-a-Swimming, ",
      "eight Maids-a-Milking, ",
      "nine Ladies Dancing, ",
      "ten Lords-a-Leaping, ",
      "eleven Pipers Piping, ",
      "twelve Drummers Drumming, "
  };


  /**
   * Searches for a particular verse give the verse number and returns it
   *
   * @param verseNo the verse number
   * @return the verse at this particular verse number
   */
  public static String verse(int verseNo) {
    return buildVerse(verseNo);
  }

  /**
   * Prints out the verse from start to end given the starting verse number and ending verse number
   *
   * @param start starting verse as an integer
   * @param end ending verse as an integer
   * @return the verses from the start verse to the end verse
   */
  public static String verses(int start, int end) {
    StringBuilder stringBuilder = new StringBuilder(buildVerse(start));
    for (int x = start + 1; x <= end; x++) {
      stringBuilder.append("\n");
      stringBuilder.append(buildVerse(x));
    }
    return stringBuilder.toString();
  }

  /**
   * Sings out the whole 12 days song
   *
   * @return the whole song
   */
  public static String sing() {
    return verses(1, 12);
  }

  /**
   * builds the verse number from the {@link #gifts} and {@link #days} arrays
   *
   * @param verseNum the verse number
   */
  private static String buildVerse(int verseNum) {
    StringBuilder stringBuilder = new StringBuilder("On the " + days[verseNum - 1] +
        " day of Christmas my true love gave to me, ");

    for (int i = verseNum; i > 0; i--) {
      if (verseNum != 1 && i == 1) {
        stringBuilder.append("and ");
      }
      stringBuilder.append(gifts[i - 1]);
    }
    stringBuilder.append("\n");
    return stringBuilder.toString();
  }

}
