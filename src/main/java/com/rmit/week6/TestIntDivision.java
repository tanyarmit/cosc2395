package com.rmit.week6;

public class TestIntDivision {
    public static void main(String[] args) {
        int int1 = Utils.readInt("Enter an integer");
        int int2 = Utils.readInt("Enter another integer");
        try {
            double result = int1 / int2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

    }

}
