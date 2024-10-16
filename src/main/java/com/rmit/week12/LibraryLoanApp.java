package com.rmit.week12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryLoanApp extends JFrame {
    // Components for the Books tab
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JComboBox<Book> bookComboBox;
    private DefaultComboBoxModel<Book> bookComboBoxModel;

    // Components for the Loans tab
    private JTextField customerNameField;
    private JTextField customerAddressField;
    private JComboBox<Customer> borrowerComboBox;
    private DefaultComboBoxModel<Customer> borrowerComboBoxModel;
    private JTextField loanDaysField;
    private JTextArea loanListArea;

    // List to store loans
    private ArrayList<Loan> loanList;

    public LibraryLoanApp() {
        // Initialize loan list
        loanList = new ArrayList<>();

        // Set up the frame
        setTitle("Library Loan System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create the Books panel
        JPanel booksPanel = createBooksPanel();
        tabbedPane.addTab("Books", booksPanel);

        // Create the Loans panel
        JPanel loansPanel = createLoansPanel();
        tabbedPane.addTab("Loans", loansPanel);

        // Add the tabbed pane to the frame
        add(tabbedPane);
        populateLists();
        setBounds(10, 10, 900, 600);
        // Make the frame visible
        setVisible(true);
    }

    // Method to create the Books panel using GridLayout
    private JPanel createBooksPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns, 10px horizontal and vertical gaps

        // Title label and field
        panel.add(new JLabel("Title:"));
        bookTitleField = new JTextField(15);
        panel.add(bookTitleField);

        // Author label and field
        panel.add(new JLabel("Author:"));
        bookAuthorField = new JTextField(15);
        panel.add(bookAuthorField);

        // Book ComboBox
        panel.add(new JLabel("Select a book from the list:"));
        bookComboBoxModel = new DefaultComboBoxModel<>();
        bookComboBox = new JComboBox<>(bookComboBoxModel);
        panel.add(bookComboBox);

        // Add Book Button
        JButton addBookButton = new JButton("Add Book");
        panel.add(new JLabel("")); // Empty space for alignment
        panel.add(addBookButton);

        // Action listener to add books to the ComboBox
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = bookTitleField.getText();
                String author = bookAuthorField.getText();
                if (!title.isEmpty() && !author.isEmpty()) {
                    Book book = new Book(title, author);
                    bookComboBoxModel.addElement(book);
                    bookTitleField.setText("");
                    bookAuthorField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both title and author.");
                }
            }
        });

        return panel;
    }

    // Method to create the Loans panel using GridLayout
    private JPanel createLoansPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10)); // 7 rows, 2 columns, 10px horizontal and vertical gaps

        // Customer name label and field
        panel.add(new JLabel("Customer name:"));
        customerNameField = new JTextField(15);
        panel.add(customerNameField);

        // Customer address label and field
        panel.add(new JLabel("Customer address:"));
        customerAddressField = new JTextField(15);
        panel.add(customerAddressField);

        // Select a borrower label and combo box
        panel.add(new JLabel("Select a borrower:"));
        borrowerComboBoxModel = new DefaultComboBoxModel<>();
        borrowerComboBox = new JComboBox<>(borrowerComboBoxModel);
        panel.add(borrowerComboBox);

        // Add Borrower Button
        panel.add(new JLabel("")); // Empty label for spacing
        JButton addBorrowerButton = new JButton("Add Borrower");
        panel.add(addBorrowerButton);

        // Enter days label and field
        panel.add(new JLabel("Enter days:"));
        loanDaysField = new JTextField(5);
        panel.add(loanDaysField);

        // Add Loan Button
        JButton addLoanButton = new JButton("Add Loan");
        panel.add(addLoanButton);

        // List Loans Button
        JButton listLoansButton = new JButton("List Loans");
        panel.add(listLoansButton);

        // Loan list area (scrollable)
        panel.add(new JLabel("")); // Empty label for alignment
        loanListArea = new JTextArea(5, 30);
        loanListArea.setEditable(false);
        JScrollPane loanListScrollPane = new JScrollPane(loanListArea);
        panel.add(loanListScrollPane);

        // Action listeners to add borrowers, loans, and list loans
        addBorrowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameField.getText();
                String customerAddress = customerAddressField.getText();
                if (!customerName.isEmpty() && !customerAddress.isEmpty()) {
                    Customer customer = new Customer(customerName, customerAddress);
                    borrowerComboBoxModel.addElement(customer);
                    customerNameField.setText("");
                    customerAddressField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both name and address.");
                }
            }
        });

        addLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String daysStr = loanDaysField.getText();
                Customer selectedBorrower = (Customer) borrowerComboBox.getSelectedItem();
                Book selectedBook = (Book) bookComboBox.getSelectedItem();
                if (selectedBorrower != null && selectedBook != null && !daysStr.isEmpty()) {
                    try {
                        int days = Integer.parseInt(daysStr);
                        Loan loan = new Loan(selectedBook.getBookId(), selectedBorrower.getCustID(), days);
                        loanList.add(loan);
                        loanListArea.append(loan.toString() + "\n");
                        loanDaysField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number of days.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a borrower, a book, and enter the days.");
                }
            }
        });

        listLoansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loanListArea.setText(""); // Clear the loan list area
                for (Loan loan : loanList) {
                    loanListArea.append(loan.toString() + "\n");
                }
            }
        });

        return panel;
    }

    private void populateLists() {
        // Add 10 books
        bookComboBoxModel.addElement(new Book("The Catcher in the Rye", "J.D. Salinger"));
        bookComboBoxModel.addElement(new Book("1984", "George Orwell"));
        bookComboBoxModel.addElement(new Book("To Kill a Mockingbird", "Harper Lee"));
        bookComboBoxModel.addElement(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        bookComboBoxModel.addElement(new Book("Moby Dick", "Herman Melville"));
        bookComboBoxModel.addElement(new Book("Pride and Prejudice", "Jane Austen"));
        bookComboBoxModel.addElement(new Book("War and Peace", "Leo Tolstoy"));
        bookComboBoxModel.addElement(new Book("The Odyssey", "Homer"));
        bookComboBoxModel.addElement(new Book("The Iliad", "Homer"));
        bookComboBoxModel.addElement(new Book("Don Quixote", "Miguel de Cervantes"));

        // Add 5 customers
        borrowerComboBoxModel.addElement(new Customer("John Doe", "123 Main St"));
        borrowerComboBoxModel.addElement(new Customer("Jane Smith", "456 Oak Ave"));
        borrowerComboBoxModel.addElement(new Customer("Alice Johnson", "789 Maple Dr"));
        borrowerComboBoxModel.addElement(new Customer("Bob Brown", "321 Elm St"));
        borrowerComboBoxModel.addElement(new Customer("Charlie Davis", "654 Pine Rd"));
    }

    public static void main(String[] args) {
        new LibraryLoanApp();
    }
}
