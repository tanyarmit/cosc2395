package com.rmit.javaparadisegui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author eddie
 */
public class JavaParadiseGUI_v4 extends JFrame {

  // ImageIcon[] icons = {new ImageIcon("images/single small.jpeg"), new
  // ImageIcon("images/double small.jpeg"),
  // new ImageIcon("images/double business small.jpg"), new
  // ImageIcon("images/single view small.jpg")};

  JTabbedPane tabs = new JTabbedPane();
  // tabs
  RoomTab roomTab;
  CustomerTab customerTab;
  BookingTab bookingTab;

  // componenets for customer
  // constructor
  public JavaParadiseGUI_v4() {
    roomTab = new RoomTab();
    customerTab = new CustomerTab();
    bookingTab = new BookingTab(roomTab, customerTab);

    // tabbed pane added
    add(tabs);
    // tabs are created
    tabs.addTab("Rooms", roomTab);
    tabs.addTab("Customers", customerTab);
    tabs.addTab("Bookings", bookingTab);

    populateLists();

    setBounds(10, 10, 600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }

  public void populateLists() {
    roomTab.populateRooms();
    customerTab.populateCustomers();
  }

  public static void main(String[] args) {
    new JavaParadiseGUI_v4();
  }

}
