package com.javapp.enums;

/**
 * com.javapp.enums
 * Created by lusinabrian on 03/03/17.
 * Description: Simply a test for the days of the week declared in {@link DaysOfWeek}
 */

public class DaysOfWeekTest {

  private DaysOfWeek daysOfWeek;

  public DaysOfWeekTest(DaysOfWeek daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
  }

  public static void main(String[] args) {
    DaysOfWeekTest firstDay = new DaysOfWeekTest(DaysOfWeek.MONDAY);
    firstDay.tellEm();
    DaysOfWeekTest thirdDay = new DaysOfWeekTest(DaysOfWeek.WEDNESDAY);
    thirdDay.tellEm();
    DaysOfWeekTest fifthDay = new DaysOfWeekTest(DaysOfWeek.FRIDAY);
    fifthDay.tellEm();
    DaysOfWeekTest sixthDay = new DaysOfWeekTest(DaysOfWeek.SATURDAY);
    sixthDay.tellEm();
    DaysOfWeekTest seventhDay = new DaysOfWeekTest(DaysOfWeek.SUNDAY);
    seventhDay.tellEm();
  }

  public void tellEm() {
    switch (daysOfWeek) {
      case MONDAY:
        System.out.println("I'm not a Monday person");
        break;

      case TUESDAY:
        System.out.println("Not a Tuesday guy either");
        break;

      case WEDNESDAY:
        System.out.println("Meh on Wednesday.");
        break;

      case THURSDAY:
        System.out.println("Thursday, I like Thursday!");
        break;

      case FRIDAY:
        System.out.println("Friday be the best!");
        break;

      case SATURDAY:
      case SUNDAY:
        System.out.println("Weekends are my jam!");
        break;
    }
  }
}
