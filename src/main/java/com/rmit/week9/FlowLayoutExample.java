package com.rmit.week9;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutExample {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the program exits when the window is closed
        frame.setLayout(new FlowLayout()); // Set layout to FlowLayout

        // Create the first panel with FlowLayout and add 3 buttons
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton btn1 = new JButton("Button 1");
        panel1.add(btn1);
        JButton btn2 = new JButton("Button 2");
        // btn2.setBorder(new EmptyBorder(15, 150, 15, 150));
        panel1.add(btn2);
        JButton btn3 = new JButton("Button 3");
        panel1.add(btn3);
        // panel1.setBorder(new EmptyBorder(0, 0, 0, 300));

        // Create the second panel with FlowLayout and add 3 buttons
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(new JButton("Button 4"));
        panel2.add(new JButton("Button 5"));
        panel2.add(new JButton("Button 6"));

        // Add the panels to the frame
        frame.add(panel1);
        frame.add(panel2);

        // Set frame size and make it visible
        frame.setSize(700, 200);
        frame.setVisible(true);
    }
}
