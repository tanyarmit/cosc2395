package com.rmit.week9;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class TicTacToeBoard {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the program exits when the window is closed
        frame.setLayout(new GridLayout(3, 3)); // 3 rows, 3 columns for the Tic-Tac-Toe board

        // Path to image files (Replace with actual paths)
        String crossImagePath = "images/cross.gif"; // Path to cross image
        String notImagePath = "images/not.gif"; // Path to not image

        // Create a random number generator
        Random rand = new Random();

        // Create 9 labels for the Tic-Tac-Toe grid
        for (int i = 0; i < 9; i++) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER); // Center the image in the label

            // Generate a random integer 0, 1, or 2
            int randomValue = rand.nextInt(3); // Generates 0, 1, or 2

            // Set the label based on the random value
            if (randomValue == 0) {
                label.setIcon(new ImageIcon(crossImagePath)); // Display cross image
            } else if (randomValue == 1) {
                label.setIcon(new ImageIcon(notImagePath)); // Display not image
            } else {
                label.setText(""); // Display nothing (empty label)
            }

            // Set border for the label
            label.setBorder(new LineBorder(Color.BLACK, 1));

            // Add label to the frame
            frame.add(label);
        }

        // Set frame size and make it visible
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
