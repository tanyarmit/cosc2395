package com.rmit.javaparadisegui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author eddie
 */
public class BookingTab extends JPanel implements ActionListener {

    RoomTab roomTab;
    CustomerTab customerTab;
    DatePanel datePanel;// interior class to this class
    JCheckBox chkBreakfast;
    JPanel inputPanel, displayPanel, buttonPanel, pnlCheckOut;
    JButton btnRemove, btnCheckOut, btnClear, btnAdd, btnSave, btnRead;
    JTextField txtTotalAmount, txtDays;
    private final String[] paymentsLabels = { "Visa", "Master card", "Cash", "Pay later" };
    DefaultListModel<Booking> bookingModel;
    JList<Booking> bookingList;
    JRadioButton[] payments;
    JLabel lblIsPaid, lblDate, lblDays, lblName;

    public BookingTab(RoomTab roomTab, CustomerTab customerTab) {
        setLayout(new BorderLayout());
        this.roomTab = roomTab;
        this.customerTab = customerTab;

        inputPanel = getInputPanel();
        displayPanel = getDisplayPanel();
        buttonPanel = getButtonPanel();
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        fixCheckOutPanel(); // puts it on the east side
    }

    private JPanel getDisplayPanel() {
        JPanel displayPanel = new JPanel();

        bookingModel = new DefaultListModel<>();
        bookingList = new JList(bookingModel);
        JScrollPane sp = new JScrollPane(bookingList);
        displayPanel.add(sp);

        return displayPanel;

    }

    private JPanel getTotalAmountPanel() {
        JPanel pnlTotalAmount = new JPanel();
        pnlTotalAmount.setLayout(new GridLayout(4, 1, 30, 30));
        pnlTotalAmount.setBorder(new TitledBorder("Process payment"));
        pnlTotalAmount.add(chkBreakfast);
        pnlTotalAmount.add(btnCheckOut);
        pnlTotalAmount.add(txtTotalAmount);
        pnlTotalAmount.add(lblIsPaid);
        return pnlTotalAmount;
    }

    private JPanel getPaymentPanel() {
        JPanel pnlPaymentOpt = new JPanel();
        pnlPaymentOpt.setBorder(new TitledBorder("Payment options"));
        pnlPaymentOpt.setLayout(new GridLayout(4, 1));
        // button group
        // paymentsLabels = {"Visa", "Master card", "Cash", "Pay later"};
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            payments[i] = new JRadioButton(paymentsLabels[i]);
            group.add(payments[i]);
            pnlPaymentOpt.add(payments[i]);
        }
        return pnlPaymentOpt;
    }

    /**
     * generate the checkoutpanel and place it in JFrame East
     */
    private void fixCheckOutPanel() {
        JPanel pnlCheckOut = new JPanel();
        pnlCheckOut.setLayout(new GridLayout(2, 1));

        lblIsPaid = new JLabel();
        payments = new JRadioButton[4];
        btnCheckOut = new JButton("Checkout");
        chkBreakfast = new JCheckBox("Breakfast:");
        txtTotalAmount = new JTextField(10);
        btnCheckOut.addActionListener(this);

        JPanel pnlPaymentOpt = getTotalAmountPanel();

        pnlCheckOut.add(getTotalAmountPanel());
        pnlCheckOut.add(pnlPaymentOpt);
        pnlCheckOut.setBorder(new EmptyBorder(10, 20, 10, 20));
        add(pnlCheckOut, BorderLayout.EAST);
    }

    private JPanel getInputPanel() {
        lblDate = new JLabel("Enter date as yyyy-mm-dd");
        lblDays = new JLabel("Duration");
        datePanel = new DatePanel();
        // txtDate = new JTextField(10);
        txtDays = new JTextField(10);
        // lblName = new JLabel("Name");
        // txtName = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        inputPanel.add(lblDate);
        // inputPanel.add(txtDate);
        inputPanel.add(datePanel);
        inputPanel.add(lblDays);
        inputPanel.add(txtDays);

        return inputPanel;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnClear = new JButton("Clear");
        btnSave = new JButton("Save");
        btnRead = new JButton("Read");

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
        btnSave.addActionListener(this);
        btnRead.addActionListener(this);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRemove);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnRead);

        return buttonPanel;
    }

    public double calculateTotalCost(Booking b) {
        int duration = b.getDuration();
        Room r = b.getRoom();
        double totalCost = duration * r.getPricePerDay();
        if (chkBreakfast.isSelected()) {
            totalCost += b.getBreakfast() * duration;
        }
        b.setTotalCost(totalCost);
        txtTotalAmount.setText(" " + totalCost);
        bookingModel.removeElement(b);
        // to do - fix payment options
        // for (int i = 0; i < 3; i++) {
        // if (payments[i].isSelected()) {
        // lblIsPaid.setText("Paid by " + payments[i].getText());
        // b.setIsPaid(true);
        // }
        // if (payments[3].isSelected()) {
        // lblIsPaid.setText("Customer will pay later");
        // b.setIsPaid(false);
        // }
        // }
        return totalCost;
    }

    public void addBooking(Booking booking) {
        bookingModel.addElement(booking);
    }

    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        JButton jb = (JButton) o;
        if (jb == btnClear) {
            bookingList.clearSelection();
        } else if (jb == btnRemove) {
            remove();
        } else if (jb == btnAdd) {
            add();
        } else if (jb == btnCheckOut) {
            checkOut();
        } else if (jb == btnSave) {
            saveBookings();
        } else if (jb == btnRead) {
            readBookings();
        }
    }

    private void add() {
        Booking booking = null;
        // get room and customer from the lists
        Room room = roomTab.roomList.getSelectedValue();
        Customer customer = customerTab.customerList.getSelectedValue();
        if (room != null && customer != null) {
            booking = new Booking(room, customer);
            // read other data
            try {
                LocalDate date = datePanel.getDate();
                booking.setDate(date);
                String daysStr = txtDays.getText();
                int days = 0;
                if (daysStr != "") {
                    days = Integer.parseInt(daysStr);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter duration in days");
                    txtDays.setText("Please enter duration in days");
                }
                booking.setDays(days);
                bookingModel.addElement(booking);
                room.setAvailability(false);
                // clear the fields
                txtDays.setText("");
                roomTab.roomList.clearSelection();
                customerTab.customerList.clearSelection();
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
                Booking.nextID--;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a room and a customer from lists");
        }
    }

    private void checkOut() {
        Booking b = bookingList.getSelectedValue();
        if (b != null) {
            double cost = calculateTotalCost(b);
            if (!b.getIsPaid()) {
                JOptionPane.showMessageDialog(null, "You have to pay $" + cost);
                Room room = b.getRoom();
                room.setAvailability(true);
                int index = bookingList.getSelectedIndex();
                if (index > -1) {
                    bookingList.remove(index);// check why if required as no longer selected
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a booking from the list");
        }
    }

    private void remove() {
        int index = bookingList.getSelectedIndex();
        if (index != -1) {
            try {
                bookingModel.remove(index);
            } catch (Exception ex) {
                System.out.println("btnRemove: " + ex.toString());
            }
        }
    }

    /**
     * inner class DatePanel
     */
    class DatePanel extends JPanel {

        JSpinner spinner;
        SpinnerModel dateModel;
        Calendar calendar;

        DatePanel() {
            calendar = Calendar.getInstance();
            Date initDate = calendar.getTime();// start with today's date
            calendar.add(Calendar.YEAR, -1);
            Date earliestDate = calendar.getTime();
            calendar.add(Calendar.YEAR, 2);
            Date latestDate = calendar.getTime();
            dateModel = new SpinnerDateModel(initDate,
                    earliestDate,
                    latestDate,
                    Calendar.YEAR);
            spinner = new JSpinner((SpinnerModel) dateModel);
            JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "dd-MMMM-yyyy");
            Font f1 = spinner.getFont();
            Font f2 = new Font(f1.getName(), Font.BOLD, 14);
            spinner.setFont(f2);
            spinner.setEditor(de);
            add(spinner);
            setBorder(new TitledBorder("Set Start Date"));
        }

        public LocalDate getDate() {
            LocalDate ld = null;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);
            System.out.println("DatePanel year: " + (year - 1) + ", month: " + (month + 1) + " day: " + (day + 1));
            ld = LocalDate.of(year - 1, month + 1, (day));
            System.out.println("ld: " + ld);
            return ld;
        }
    }// end of DatePanel class

    public void saveBookings() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("bookings.dat");
            oos = new ObjectOutputStream(fos);
            for (Object b : bookingModel.toArray()) {
                oos.writeObject((Booking) b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readBookings() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("bookings.dat");
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Object object = ois.readObject();
                    Booking b = (Booking) object;
                    // Add only if not there
                    if (!bookingModel.contains(b)) {
                        b.setBookingId();
                        bookingModel.addElement(b);
                    }

                    // Add customer if not there
                    Customer c = b.getCustomer();
                    if (!customerTab.customerModel.contains(c)) {
                        c.setCustId();
                        customerTab.customerModel.addElement(c);
                    }
                    // Add only if not there
                    Room r = b.getRoom();
                    if (!roomTab.roomModel.contains(r)) {
                        r.setRoomNo();
                        r.setAvailability(false);
                        roomTab.roomModel.addElement(r);
                    } else {
                        roomTab.searchRoomsByRoomNo(r.getRoomNo()).setAvailability(false);
                    }

                    // System.out.println(b);
                } catch (EOFException eof) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}// end BookingTab
