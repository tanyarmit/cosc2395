package com.rmit.week11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TrafficLight extends JFrame {
    // Traffic light images as ImageIcons
    private ImageIcon[] icons = {
            new ImageIcon("images/green.png"),
            new ImageIcon("images/yellow.png"),
            new ImageIcon("images/red.png")
    };

    private JLabel lightLabel; // Label to display traffic light image
    private JRadioButton redButton, yellowButton, greenButton;
    private ButtonGroup buttonGroup;

    public TrafficLight() {
        // Set up the frame
        setTitle("Traffic Lights");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the label to hold the traffic light image
        lightLabel = new JLabel();
        lightLabel.setIcon(icons[0]); // Set green light as default

        // Center the image both horizontally and vertically
        lightLabel.setHorizontalAlignment(JLabel.CENTER);
        lightLabel.setVerticalAlignment(JLabel.CENTER);

        // Add the label to the center of the frame
        add(lightLabel, BorderLayout.CENTER);

        // Create the radio buttons
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green", true); // Set green as default selected

        // Add radio buttons to a button group
        buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        // Create a panel for radio buttons and add them to the panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(greenButton);

        // Add the radio panel to the bottom (South)
        add(radioPanel, BorderLayout.SOUTH);

        // Add ActionListeners to the radio buttons
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightLabel.setIcon(icons[2]); // Set light to red
            }
        });

        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightLabel.setIcon(icons[1]); // Set light to yellow
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightLabel.setIcon(icons[0]); // Set light to green
            }
        });

        // Set the frame size and make it visible
        setSize(300, 400);
        setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        new TrafficLight();
    }
}
