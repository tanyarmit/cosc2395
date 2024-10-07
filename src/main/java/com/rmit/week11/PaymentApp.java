package com.rmit.week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentApp extends JFrame {
    // GUI components
    private JTextField itemField;
    private JTextField priceField;
    private JTextArea displayArea;
    private JComboBox<String> paymentMethodCombo;
    private JButton payButton;

    public PaymentApp() {
        // Set up the frame
        setTitle("Payment App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the input panel for item and price fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel itemLabel = new JLabel("Item");
        JLabel priceLabel = new JLabel("Price");
        itemField = new JTextField(10);
        priceField = new JTextField(10);

        inputPanel.add(itemLabel);
        inputPanel.add(itemField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);

        // Create the text area for displaying output
        displayArea = new JTextArea(5, 20);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Create the combo box for payment method selection
        String[] paymentMethods = { "Visa", "MasterCard", "PayPal" };
        paymentMethodCombo = new JComboBox<>(paymentMethods);

        // Create the pay button
        payButton = new JButton("Pay");

        // Panel for Pay button and combo box
        JPanel paymentPanel = new JPanel(new FlowLayout());
        paymentPanel.add(payButton);
        paymentPanel.add(paymentMethodCombo);

        // Add action listener to the Pay button
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(paymentPanel, BorderLayout.SOUTH);

        // Set the frame size and make it visible
        pack();
        setVisible(true);
    }

    // Method to process the payment and display the result in the text area
    private void processPayment() {
        // Get values from text fields and combo box
        String item = itemField.getText();
        String price = priceField.getText();
        String paymentMethod = (String) paymentMethodCombo.getSelectedItem();

        // Display the result in the text area
        displayArea.setText("For " + item + " $" + price + " paid by " + paymentMethod);
    }

    // Main method to run the application
    public static void main(String[] args) {
        new PaymentApp();
    }
}
