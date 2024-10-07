package com.rmit.week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FavoriteDisplay extends JFrame {
    private JTextArea textArea;
    private JCheckBox playCheckBox, studyCheckBox, sleepCheckBox;
    private JButton displayButton;

    public FavoriteDisplay() {
        // Set up the frame
        setTitle("My Favorites");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and set up text area (center panel)
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JScrollPane(textArea)); // Scrollable text area

        // Create checkboxes (east panel)
        playCheckBox = new JCheckBox("play");
        studyCheckBox = new JCheckBox("study");
        sleepCheckBox = new JCheckBox("sleep");
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS)); // Vertical layout
        eastPanel.add(playCheckBox);
        eastPanel.add(studyCheckBox);
        eastPanel.add(sleepCheckBox);

        // Create Display button (south panel)
        displayButton = new JButton("Display");
        JPanel southPanel = new JPanel();
        southPanel.add(displayButton);

        // Add panels to the frame
        add(centerPanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        // Add ActionListener to the button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear text area
                textArea.setText("I like to\n");

                // Append selected checkboxes' text to the text area
                if (playCheckBox.isSelected()) {
                    textArea.append("play\n");
                }
                if (studyCheckBox.isSelected()) {
                    textArea.append("study\n");
                }
                if (sleepCheckBox.isSelected()) {
                    textArea.append("sleep\n");
                }
            }
        });

        // Set the size of the frame and make it visible
        setSize(300, 200);
        setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        new FavoriteDisplay();
    }
}
