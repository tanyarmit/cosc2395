package com.rmit.week9;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutExample {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("GridLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the program exits when the window is closed
        frame.setLayout(new GridLayout(2, 1)); // Set layout of the frame to 2 rows, 1 column (for two panels)

        // Create the first panel with GridLayout (2 rows, 3 columns) and add 6 buttons
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 3)); // 2 rows, 3 columns
        panel1.add(new JButton("Button 1"));
        panel1.add(new JButton("Button 2"));
        panel1.add(new JButton("Button 3"));
        panel1.add(new JButton("Button 4"));
        panel1.add(new JButton("Button 5"));
        panel1.add(new JButton("Button 6"));

        // Create the second panel with GridLayout (2 rows, 2 columns) and add 4 buttons
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns
        panel2.add(new JButton("Button 7"));
        panel2.add(new JButton("Button 8"));
        panel2.add(new JButton("Button 9"));
        panel2.add(new JButton("Button 10"));

        // Add both panels to the frame
        frame.add(panel1);
        frame.add(panel2);

        // Set frame size and make it visible
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
