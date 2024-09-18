package com.rmit.week10;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {

    // Components for the calculator
    private JTextField displayField; // To display the expression and result
    private JButton[] buttons = new JButton[16]; // Array of buttons for the keypad
    private String[] labels = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "+", "-", "*", "/" };
    private JPanel keypad; // Panel for the keypad
    private double num1, num2, result;
    private String operator;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display field
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        add(displayField, BorderLayout.NORTH); // Add the display field to the top

        // Create the keypad panel with GridLayout
        keypad = new JPanel();
        keypad.setLayout(new GridLayout(4, 4, 2, 2)); // 4x4 grid with gaps of 2px

        // Create buttons using a loop and add them to the keypad
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(labels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttons[i].addActionListener(this); // Add action listener for each button
            keypad.add(buttons[i]); // Add the button to the keypad panel
        }

        // Add the keypad panel to the center of the frame
        add(keypad, BorderLayout.CENTER);

        // Add a Clear button at the bottom
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        clearButton.addActionListener(e -> clear()); // Action listener for clearing the calculator
        add(clearButton, BorderLayout.SOUTH);

        // Set the size of the frame and make it visible
        setSize(400, 500);
        setVisible(true);
    }

    // ActionListener method for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            // If a number or decimal point is pressed, append it to the display field
            displayField.setText(displayField.getText() + command);
        } else if ("+-*/".contains(command)) {
            // If an operator is pressed, store the first number and operator
            num1 = Double.parseDouble(displayField.getText());
            operator = command;
            displayField.setText(""); // Clear the display field for the next number
        } else if (command.equals("=")) {
            // When the equals button is pressed, perform the calculation
            num2 = Double.parseDouble(displayField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            // Display the result
            displayField.setText(String.valueOf(result));
        }
    }

    // Method to clear the calculator
    private void clear() {
        displayField.setText("");
        num1 = num2 = result = 0;
        operator = "";
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        new Calculator();
    }
}
