package main.GUI.Graphics;

import javax.swing.*;

public class ShapesTest {
    public static void main(String[] args) {
        JOptionPane joptPane = new JOptionPane();
        JFrame jframe = new JFrame();
        String input;
        int choice;

        input = JOptionPane.showInputDialog("Enter 1 to draw rectangles\n Enter 2 to draw ovals");

        choice = Integer.parseInt(input);

        Shapes panel = new Shapes(choice);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.setSize(300, 300);
        jframe.setVisible(true);
    }
}