package com.rmit.javaparadisegui;

import java.io.Serializable;

public class Room implements Serializable {

    private int roomNo;
    private String type;
    private double pricePerDay;
    private boolean availability = true;
    static int nextId = 1;

    public Room() {
        roomNo = nextId++;
    }

    public Room(String type) {
        this();
        if (pricePerDay < 1.) {
            setPricePerDay(type);
        }
        this.type = type;
    }

    public Room(String type, double pricePerDay) {
        this(type);
        this.pricePerDay = pricePerDay;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public String getType() {
        return type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPricePerDay(String type) {
        if (type.equalsIgnoreCase("single")) {
            pricePerDay = 125;
        } else if (type.equalsIgnoreCase("double")) {
            pricePerDay = 256;
        } else if (type.equalsIgnoreCase("luxury")) {
            pricePerDay = 359;
        } else {
            pricePerDay = 0.0;
        }
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String toString() {
        return "Room #: " + roomNo + ", type: " + type + ", price per day: " + pricePerDay + ", available?  "
                + availability;
    }

    public void setRoomNo() {
        this.roomNo = nextId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return roomNo == room.roomNo && type.equals(room.type);
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
