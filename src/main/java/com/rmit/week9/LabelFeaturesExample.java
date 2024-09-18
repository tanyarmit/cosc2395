package com.rmit.week9;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class LabelFeaturesExample {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Swing Common Features Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the program exits when the window is closed
        frame.setLayout(new GridLayout(6, 1)); // 6 rows, 1 column for the labels

        // Create a font for the labels
        Font font = new Font("TimesRoman", Font.BOLD, 20);

        // Create the labels with their respective foreground colors and text
        JLabel label1 = createLabel("Black", Color.BLACK, font);
        JLabel label2 = createLabel("Blue", Color.BLUE, font);
        JLabel label3 = createLabel("Cyan", Color.CYAN, font);
        JLabel label4 = createLabel("Green", Color.GREEN, font);
        JLabel label5 = createLabel("Magenta", Color.MAGENTA, font);
        JLabel label6 = createLabel("Orange", Color.ORANGE, font);

        // Add the labels to the frame
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);

        // Set frame size and make it visible
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    // Helper method to create a label with specific text, foreground color, and
    // font
    private static JLabel createLabel(String text, Color foreground, Font font) {
        JLabel label = new JLabel(text, JLabel.CENTER); // Center-align the text in the label
        label.setOpaque(true); // Allows the background color to be visible
        label.setBackground(Color.WHITE); // Set the background color to white
        label.setForeground(foreground); // Set the foreground (text) color
        label.setBorder(new LineBorder(Color.YELLOW, 1)); // Set the border to a yellow line border
        label.setFont(font); // Set the font to TimesRoman, bold, 20 pixels
        return label;
    }
}
