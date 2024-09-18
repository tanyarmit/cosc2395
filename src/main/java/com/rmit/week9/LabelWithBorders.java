package com.rmit.week9;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class LabelWithBorders {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Label with Borders Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the program exits when the window is closed
        frame.setLayout(new GridLayout(4, 1)); // 4 rows, 1 column layout for the labels

        // Create the labels with text
        JLabel label1 = new JLabel("This is line 1", JLabel.CENTER);
        JLabel label2 = new JLabel("This is line 2", JLabel.CENTER);
        JLabel label3 = new JLabel("This is line 3", JLabel.CENTER);
        JLabel label4 = new JLabel("This is line 4", JLabel.CENTER);

        // Set blue borders with 1-pixel thickness for each label
        label1.setBorder(new LineBorder(Color.BLUE, 1));
        label2.setBorder(new LineBorder(Color.BLUE, 5));
        label3.setBorder(new LineBorder(Color.BLUE, 1));
        label4.setBorder(new LineBorder(Color.BLUE, 1));

        // Add the labels to the frame
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

        // Set frame size and make it visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
