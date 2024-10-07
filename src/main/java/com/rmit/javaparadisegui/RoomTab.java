package com.rmit.javaparadisegui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;

/**
 *
 * @author eddie
 */
public class RoomTab extends JPanel implements ActionListener {

    DefaultListModel<Room> roomModel;
    JList<Room> roomList;

    JPanel inputPanel, displayPanel, buttonPanel;
    JTextField txtRoomName, txtCostPerDay;
    JLabel lblRoomName, lblCostPerDay;
    JButton btnAdd, btnRemove, btnClear;

    public RoomTab() {
        setLayout(new BorderLayout());

        inputPanel = getInputPanel();
        displayPanel = getDisplayPanel();
        buttonPanel = getButtonPanel();

        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        populateRooms();
    }

    private JPanel getInputPanel() {
        JPanel inputPanel = new JPanel();  // this inputPanel is a local variable

        lblRoomName = new JLabel("Room name: ");
        inputPanel.add(lblRoomName);
        txtRoomName = new JTextField(8);
        inputPanel.add(txtRoomName);

        lblCostPerDay = new JLabel("  Cost Per Day: ");
        inputPanel.add(lblCostPerDay);
        txtCostPerDay = new JTextField(3);
        inputPanel.add(txtCostPerDay);
        return inputPanel;
    }

    private JPanel getDisplayPanel() {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        roomModel = new DefaultListModel<>();
        roomList = new JList<Room>(roomModel);
        JScrollPane scrollRooms = new JScrollPane(roomList);
        scrollRooms.setBorder(new TitledBorder("List of rooms"));
        displayPanel.add(scrollRooms);
        return displayPanel;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Add Room");
        btnRemove = new JButton("Remove Room");
        btnClear = new JButton("Clear Highlight");

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRemove);
        buttonPanel.add(btnClear);
        return buttonPanel;
    }

    public Room searchRoomsByRoomNo(int roomNo) {
        Room foundRoom = null;
        Object[] o = roomModel.toArray();
        for (Object r : o) {
            Room room = (Room) r;
            if (room.getRoomNo() == roomNo) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o instanceof JButton) { //only required if other widgets have action listeners 
            handleButton((JButton) o);
        }
    }

    public void handleButton(JButton jb) {
        if (jb == btnAdd) {
            addRoom();
        } else if (jb == btnRemove) {
            removeRoom();
        } else if (jb == btnClear) {
            roomList.clearSelection();
        }
    }

    public void removeRoom() {
        Room room = roomList.getSelectedValue();
        if (room != null) {
            roomModel.removeElement(room);
        }
    }

    public void addRoom() {
        String name = txtRoomName.getText();
        String scpd = txtCostPerDay.getText();
        if (name != null && name.length() > 0
                && scpd != null && scpd.length() > 0) {
            double cpd = 0.;
            try {
                cpd = Double.parseDouble(scpd);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid cost pere day.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (cpd > 0) {
                Room room = new Room(name, cpd);
                roomModel.addElement(room);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a room name and a valid cost pere day.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    public void populateRooms() {
        Room[] arrOfRooms = {new Room("Single"), new Room("Double"),
            new Room("Single"), new Room("Double")};
        for (Room r : arrOfRooms) {
            roomModel.addElement(r);
        }
        Room r1 = new Room("Single", 200.00);
        roomModel.addElement(r1);
    }
    
    /**
     * following code just for testing this panel
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("RoomTab Test");
        jf.setBounds(10, 10, 550, 550);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RoomTab rt = new RoomTab();
        jf.add(rt);

        jf.setVisible(true);

    }
}
