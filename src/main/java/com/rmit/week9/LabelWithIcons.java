package com.rmit.week9;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class LabelWithIcons {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Label with Icons Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the program exits when the window is closed
        frame.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns for the labels

        // Create the labels with ImageIcons (replace the image file names with actual
        // paths)
        JLabel label1 = new JLabel(new ImageIcon("images/img1a.jpg"));
        JLabel label2 = new JLabel(new ImageIcon("images/img2a.jpg"));
        JLabel label3 = new JLabel(new ImageIcon("images/img3a.jpg"));
        JLabel label4 = new JLabel(new ImageIcon("images/img4a.jpg"));

        // Set borders for each label
        label1.setBorder(new LineBorder(Color.BLACK, 1));
        label2.setBorder(new LineBorder(Color.BLACK, 1));
        label3.setBorder(new LineBorder(Color.BLACK, 1));
        label4.setBorder(new LineBorder(Color.BLACK, 1));

        // Add the labels to the frame
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

        // Set frame size and make it visible
        frame.setSize(400, 400); // Adjust size as needed
        frame.setVisible(true);
    }
}
