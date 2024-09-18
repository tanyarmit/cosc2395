package com.rmit.week10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class StudentGUI {
    // ArrayList to store Student objects
    private ArrayList<Student> studentList = new ArrayList<>();

    // GUI components
    private JTextField idField;
    private JTextField nameField;
    private JTextArea textArea;

    public StudentGUI() {
        // Create the frame
        JFrame frame = new JFrame("Student Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for input fields (ID and Name)
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // 2 rows, 2 columns with padding
        JLabel idLabel = new JLabel("Student ID:");
        JLabel nameLabel = new JLabel("Full name:");
        idField = new JTextField(10);
        nameField = new JTextField(10);

        // Add input fields to the input panel
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        // TextArea to display the list of students
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false); // Make the text area non-editable
        textArea.setBorder(new TitledBorder("List of students")); // Add a titled border
        JScrollPane scrollPane = new JScrollPane(textArea); // Add scroll functionality

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5)); // 1 row, 3 columns for buttons
        JButton addButton = new JButton("Add");
        JButton listButton = new JButton("List");
        JButton clearButton = new JButton("Clear");

        // Add buttons to the button panel
        buttonPanel.add(addButton);
        buttonPanel.add(listButton);
        buttonPanel.add(clearButton);

        // ActionListener for the Add button
        addButton.addActionListener(new AddButtonListener());

        // ActionListener for the List button
        listButton.addActionListener(e -> displayStudentList());

        // ActionListener for the Clear button
        clearButton.addActionListener(e -> {
            textArea.setText("");
            idField.setText("");
            nameField.setText("");
        });

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH); // Input fields at the top
        frame.add(scrollPane, BorderLayout.CENTER); // Text area in the center
        frame.add(buttonPanel, BorderLayout.SOUTH); // Buttons at the bottom

        // Set frame size and make it visible
        frame.pack();
        frame.setVisible(true);
    }

    // ActionListener for the Add Student button
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get input values from the text fields
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();

                // Create a new Student object and add it to the list
                Student student = new Student(id, name);
                studentList.add(student);

                // Clear the input fields after adding
                idField.setText("");
                nameField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid student ID.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to display the list of students in the text area
    private void displayStudentList() {
        textArea.setText(""); // Clear the text area before displaying the updated list
        for (Student student : studentList) {
            textArea.append(student.toString() + "\n"); // Append each student's details
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        new StudentGUI();
    }
}
