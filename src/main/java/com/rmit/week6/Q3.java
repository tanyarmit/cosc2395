package com.rmit.week6;

public class Q3 {
    public static void main(String[] args) {
        try {
            int[] list = new int[10];
            System.out.println("list[9] is " + list[9]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException");
        } catch (Exception ex) {
            System.out.println("Exception");
        }
    }
}
// What is the output?