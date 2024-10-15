package com.rmit.javaparadisegui;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author eddie
 */
public class CustomerTab extends JPanel implements ActionListener {

    DefaultListModel<Customer> customerModel;
    JList<Customer> customerList;

    JLabel lblName;
    JTextField txtName;

    JPanel inputPanel, displayPanel, buttonPanel;
    JButton btnAdd, btnRemove, btnClear, btnDisplay;

    public CustomerTab() {
        setLayout(new BorderLayout());

        customerModel = new DefaultListModel<Customer>();
        customerList = new JList<Customer>(customerModel);

        inputPanel = new JPanel();
        displayPanel = new JPanel();
        buttonPanel = getButtonPanel();

        txtName = new JTextField(10);
        lblName = new JLabel("Name");

        add(inputPanel, BorderLayout.NORTH);

        JScrollPane scrollCustomers = new JScrollPane(customerList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollCustomers.setBorder(new TitledBorder("List of customers"));
        add(scrollCustomers, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        inputPanel.setLayout(new GridLayout(1, 2, 10, 10));
        inputPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        inputPanel.add(lblName);
        inputPanel.add(txtName);

    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnClear = new JButton("Clear");

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRemove);
        buttonPanel.add(btnClear);

        return buttonPanel;
    }

    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        JButton jb = (JButton) o;
        if (jb == btnAdd) {
            add();
        } else if (jb == btnRemove) {
            remove();
        } else if (jb == btnClear) {
            customerList.clearSelection();
        }

    }

    private void add() {
        //read the data
        String name = txtName.getText();
        if (!name.equals("")) {
            Customer customer = new Customer(name);
            customerModel.addElement(customer);
            //clear the text fields
            txtName.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid customer name.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void remove() {
        int index = customerList.getSelectedIndex();
        if (index != -1) {
            customerModel.remove(index);
        }
    }

    public void populateCustomers() {
        customerModel.addElement(new Customer("Natasha"));
        customerModel.addElement(new Customer("Jeff"));
        customerModel.addElement(new Customer("Sam"));
    }

    /**
     * following code just for testing this panel
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("CustomerTab Test");
        jf.setBounds(10, 10, 550, 550);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RoomTab rt = new RoomTab();
        jf.add(rt);

        jf.setVisible(true);

    }

}
