package com.rmit.week7;

import java.util.Scanner;

public class Utils {
    public static int readInt(String message) {
        int userInput = -1;
        Scanner scanner = new Scanner(System.in);
        while (userInput == -1) {
            System.out.print(message + " ");
            try {
                userInput = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }

        }
        return userInput;
    }

    public static double readDouble(String message) {
        double userInput = -1;
        Scanner scanner = new Scanner(System.in);
        while (userInput == -1) {
            System.out.print(message + " ");
            try {
                userInput = scanner.nextDouble();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a double.");
                scanner.nextLine();
            }

        }
        return userInput;
    }

    public static String readString(String message) {
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        while (userInput.equals("")) {
            System.out.print(message + " ");
            try {
                userInput = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a string.");
                scanner.nextLine();
            }

        }
        return userInput;
    }

}
