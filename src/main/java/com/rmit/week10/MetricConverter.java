package com.rmit.week10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MetricConverter {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Metric Converter: Miles to Kilometers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for the North section (Label, TextField, and Button)
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        // Create the label, text field, and button
        JLabel label = new JLabel("Enter miles: ");
        JTextField textField = new JTextField(10);
        JButton convertButton = new JButton("Convert to KM");

        // Add components to the north panel
        northPanel.add(label);
        northPanel.add(textField);
        northPanel.add(convertButton);

        // Panel for the Center section (TextArea)
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false); // Disable editing
        JScrollPane scrollPane = new JScrollPane(textArea); // Add scroll functionality

        // Add the panels to the frame
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Action listener for the button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the input value from the text field
                    String milesStr = textField.getText();
                    double miles = Double.parseDouble(milesStr); // Convert to double

                    // Convert miles to kilometers using the formula
                    double km = miles / 0.62;
                    String kmStr = String.format("%.3f", km); // Format with 3 decimal places

                    // Append the result to the text area
                    textArea.append(milesStr + " miles = " + kmStr + " kilometers\n");
                    textField.setText(""); // Clear the text field

                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame size and make it visible
        frame.pack();
        frame.setVisible(true);
    }
}
