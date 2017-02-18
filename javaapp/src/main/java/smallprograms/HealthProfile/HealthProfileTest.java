package java.smallprograms.HealthProfile;

import javax.swing.*;
import java.util.Scanner;

public class HealthProfileTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JOptionPane joptPane = new JOptionPane();

        //prompt
        JOptionPane.showMessageDialog(null, "Welcome to the java.smallprograms.HealthProfile! Enter a few details about yorself and we shall set up your health profile");
        String fname = JOptionPane.showInputDialog(null, "What is your first name?");
        String sname = JOptionPane.showInputDialog(null, "What is your surname?");
        String gen = JOptionPane.showInputDialog(null, "What is our sex(male or female)?");
        String userdob = JOptionPane.showInputDialog(null, "In which year were you born?");
        int dob = Integer.parseInt(userdob);

        String userW = JOptionPane.showInputDialog(null, "What is your weight(Kgs)?");
        double w = Double.parseDouble(userW);

        String userH = JOptionPane.showInputDialog(null, "How tall are you?");
        double h = Double.parseDouble(userH);

        //create an object of the java.smallprograms.HealthProfile  class
        HealthProfile user = new HealthProfile(fname, sname, gen, dob, h, w);
        user.BmiTest();

        user.displayHealthProfile();
    }
}