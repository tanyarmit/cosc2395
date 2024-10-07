package com.rmit.week11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ColorPanel extends JFrame {
    // Array of colors and radio buttons
    private Color[] colors = { Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA };
    private JRadioButton[] jrbs = new JRadioButton[colors.length];
    private String[] radioButtonsLabels = { "yellow", "red", "green", "blue", "magenta" };

    private JPanel colorPanel; // The panel whose color will change
    private JButton changeColorButton; // Button to trigger color change

    public ColorPanel() {
        // Set up the frame
        setTitle("Coloured Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the color panel
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.GREEN); // Initial color is red
        add(colorPanel, BorderLayout.CENTER);

        // Create the radio buttons and add them to a button group
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(colors.length, 1));
        ButtonGroup group = new ButtonGroup(); // Group to allow only one selection

        for (int i = 0; i < colors.length; i++) {
            jrbs[i] = new JRadioButton(radioButtonsLabels[i]);
            group.add(jrbs[i]);
            radioPanel.add(jrbs[i]);
        }

        // Set "red" as the default selected radio button
        jrbs[2].setSelected(true);

        // Add the radio panel to the left (West)
        add(radioPanel, BorderLayout.WEST);

        // Create and add the "Change Color" button to the top (North)
        changeColorButton = new JButton("Change color");
        add(changeColorButton, BorderLayout.NORTH);

        // Add ActionListener to the button to change the color of the panel
        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < jrbs.length; i++) {
                    if (jrbs[i].isSelected()) {
                        colorPanel.setBackground(colors[i]); // Change the panel color
                        break;
                    }
                }
            }
        });

        // Set frame size and make it visible
        setSize(400, 300);
        setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        new ColorPanel();
    }
}
