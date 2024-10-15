
package com.rmit.javaparadisegui;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author eddie
 */
public class Booking implements Serializable {

    private int bookingId;
    private Customer customer;
    private Room room;
    private LocalDate startDate;
    private int duration;
    private double cost;
    private double breakfast = 34;
    private boolean isPaid;
    static int nextID = 10;

    public Booking() {
        bookingId = nextID++;
    }

    public Booking(Room room, Customer customer) {
        this.customer = customer;
        this.room = room;
        bookingId = nextID++;
    }

    public Booking(Customer customer, LocalDate startDate, int duration) {
        this.customer = customer;
        this.startDate = startDate;
        this.duration = duration;
        bookingId = nextID++;
    }

    public Booking(Customer customer, int duration) {
        this.customer = customer;
        this.duration = duration;
        bookingId = nextID++;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId() {
        this.bookingId = nextID++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return startDate;
    }

    public int getDuration() {
        return duration;
    }

    public Room getRoom() {
        return room;
    }

    public double getBreakfast() {
        return breakfast;
    }

    public void setTotalCost(double cost) {
        this.cost = cost;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setDateFromString(String dateStr) {// old code
        startDate = LocalDate.parse(dateStr);
    }

    public void setDate(LocalDate localDate) {
        startDate = localDate;
    }

    public void setBreakfast(double breakfast) {
        this.breakfast = breakfast;
    }

    public void setDays(int duration) {
        this.duration = duration;
    }

    public void setRoomNo(Room room) {
        this.room = room;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(duration);
    }

    public double getTotalCost() {
        return cost;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int compareTo(Booking b) {
        LocalDate endDate = this.getEndDate();
        LocalDate endDate1 = b.getEndDate();
        return endDate.compareTo(endDate1);
    }

    public String toString() {
        return "<html>" + "<br />" + "Booking ID: " + bookingId + "<br />" + "Customer " + customer.toString()
                + "<br />" + " Start date: " + startDate
                + ", duration: " + duration + "<br />" + room.toString() + "<br />" + "</html>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Booking booking = (Booking) o;
        return (bookingId == booking.bookingId && customer.equals(booking.customer) && room.equals(booking.room)
                && startDate.equals(booking.startDate) && duration == booking.duration);
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
