package com.javapp.algorithms.Robotname;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RobotTest {

  private static final String EXPECTED_ROBOT_NAME_PATTERN = "[A-Z]{2}\\d{3}";
  private final Robot robot = new Robot();

  private static void assertIsValidName(String name) {
    assertThat(name.matches(EXPECTED_ROBOT_NAME_PATTERN), is(true));
  }

  @Test
  public void hasName() {
    assertIsValidName(robot.getName());
  }

  @Test
  public void differentRobotsHaveDifferentNames() {
    assertThat(robot.getName(), not(equalTo(new Robot().getName())));
  }

  @Test
  public void resetName() {
    final String name = robot.getName();
    robot.reset();
    final String name2 = robot.getName();
    assertThat(name, not(equalTo(name2)));
    assertIsValidName(name2);
  }
}
