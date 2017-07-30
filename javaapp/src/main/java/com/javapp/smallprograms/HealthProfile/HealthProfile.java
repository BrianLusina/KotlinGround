package com.javapp.smallprograms.HealthProfile;

import javax.swing.JOptionPane;

public class HealthProfile {

  private String firstName, surname, gender;
  private int patientDob;
  private double height, weight;
  private JOptionPane joptPane = new JOptionPane();

  //constructor
  public HealthProfile(String fname, String sname, String userGender, int userDob,
      double userHeight, double userWeight) {
    firstName = fname;
    surname = sname;
    gender = userGender;
    patientDob = userDob;
    height = userHeight;
    weight = userWeight;
  }

  public String getFirstName() {
    return firstName;
  }

  //setters and getters
  public void setFirstName(String fname) {
    firstName = fname;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String sname) {
    surname = sname;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gen) {
    gender = gen;
  }

  public int getPatientDob() {
    return patientDob;
  }

  public void setPatientDob(int pdob) {
    patientDob = pdob;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double uHeight) {
    height = uHeight;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double uWeight) {
    weight = uWeight;
  }

  public int currentAge() {
    int ca = 2014 - getPatientDob();
    return ca;
  }

  public void maxHeartRate() {
    int mhr = 220 - currentAge();
    System.out
        .println(getFirstName() + " " + getSurname() + "'s current maximum heart rate is " + mhr);
  }

  public double getMaxHR() {
    int mhr = 220 - currentAge();
    return mhr;
  }

  public void targetHeartRate() {
    int mhr = 220 - currentAge();
    double lowerTrgt = 0.5 * mhr;
    double higherTrgt = 0.85 * mhr;

    System.out
        .println("Your target heart rate is between the range " + lowerTrgt + " and " + higherTrgt);
  }

  public String getTargetHR() {
    int mhr = 220 - currentAge();
    double lowerTrgt = 0.5 * mhr;
    double higherTrgt = 0.85 * mhr;
    String thr = String.format("Target Heart Rate is between %.2f and %.2f", lowerTrgt, higherTrgt);
    return thr;
  }

  public void BmiTest() {
    double w = getWeight();
    double h = getHeight();
    double bmi = w / (h * h);

    //comparison
    if (bmi < 18.5) {
      System.out.print("You are underweight. You need to bulk up! \n");
    }

    if (bmi >= 18.5 && bmi <= 24.9) {
      System.out.print("You are normal. Keep doing what you do! \n");
    }

    if (bmi >= 25 && bmi <= 29.9) {
      System.out.print("You are overweight. You need to hit the gym! \n");
    }

    if (bmi >= 30) {
      System.out.print(
          "You are obese. You need to work out a lot. Eat right and lead a healthy life! \n");
    }

    System.out.println("And that was the BMI calculator. Welcome back soon");
  }

  public double getBMI() {
    double w = getWeight();
    double h = getHeight();
    double bmi = w / (h * h);
    return bmi;
  }

  public void displayHealthProfile() {
    String message = String.format(
        "First Name: %s\n Surname: %s\n Gender: %s\n Birth Year: %d\n Age: %d\n Current height: %.2f\n Current Weight: %.2f\n Maximum Heart Rate: %.2f\n Target Heart Rate: %s\n BMI: %.2f",
        getFirstName(), getSurname(), getGender(), getPatientDob(), currentAge(), getHeight(),
        getWeight(), getMaxHR(), getTargetHR(), getBMI());
    JOptionPane.showMessageDialog(null, message);
  }

//end
}