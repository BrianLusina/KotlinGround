package main.java.GUI.DialogBoxes;

import javax.swing.*;

public class DialogBox {
    public static void main(String[] args) {
        //create an instance of the JOptionPane class
        JOptionPane joptionPane = new JOptionPane();

        //prompt user to enter their name
        String name = joptionPane.showInputDialog("Hey,what's your name?");
        ;

        //create the message
        String message = String.format("Welcome, %s, to Java", name);
        joptionPane.showMessageDialog(null, message);

        joptionPane.showMessageDialog(null, "I am Lusinaire (you probably have not heard of me, but I am a genius), now Let us do a small exercise");

        //prompt the user to enter a number
        String uNum1 = joptionPane.showInputDialog("Think of a number, any number");
        String uNum2 = joptionPane.showInputDialog("Think of another number");

        int num1 = Integer.parseInt(uNum1);
        int num2 = Integer.parseInt(uNum2);

        int answer = num1 + num2;

        String result = String.format("The sum of %d and %d is %d", num1, num2, answer);
        joptionPane.showMessageDialog(null, result);

        joptionPane.showMessageDialog(null, "Now, I know that may not seem like much, but you have just done a simple calculation in a very complex way");
    }
}