package com.rmit.week6;

public class Test {
    public static void main(String[] args) {
        int number = Utils.readInt("Enter a number: ");
        System.out.println("Number: " + number);
        double decimal = Utils.readDouble("Enter a decimal: ");
        System.out.println("Decimal: " + decimal);
        String text = Utils.readString("Enter a text: ");
        System.out.println("Text: " + text);
    }
}
