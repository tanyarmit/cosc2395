package com.rmit.week6;

public class Q2 {
    public static void main(String[] args) {
        try {
            System.out.println("Statement 1");
            System.out.println("Statement 2" + (10 / 0));
            System.out.println("Statement 3");
            // } catch (IndexOutOfBoundsException ex) {
        } catch (ArithmeticException ex1) {
            // } catch (RuntimeException ex2) {
        }
        System.out.println("Statement 4");

    }
}
