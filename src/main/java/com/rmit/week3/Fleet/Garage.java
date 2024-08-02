package com.rmit.week3.Fleet;

import java.util.Scanner;

public class Garage {
    public static void main(String[] args) {
        Car fleet[] = new Car[15];
        // Task 1 of Lab 3

        Car car1 = new Car("Toyota", "Corolla", 2015, 1.8);
        Car car2 = new Car("Toyota", "Camry", 2016, 2.5);
        Car car3 = new Car("Toyota", "RAV4", 2017, 2.5);
        Car car4 = new Car("Mazda", "CX-5", 2024, 2.5);

        fleet[0] = car1;
        fleet[1] = car2;
        fleet[2] = car3;
        fleet[3] = car4;

        fleet[1].setInGarage(true);
        fleet[2].setInGarage(true);

        for (int i = 0; i < fleet.length; i++) {
            if (fleet[i] != null && fleet[i].isInGarage()) {
                System.out.println(fleet[i]);
            }
        }

        // Task 1a of Lab 3

        boolean moreEntries = true;
        Scanner input = new Scanner(System.in);
        int counter = 0;
        while (moreEntries) {
            System.out.println("Enter the make of the car: ");
            String make = input.nextLine();
            System.out.println("Enter the model of the car: ");
            String model = input.nextLine();
            System.out.println("Enter the year of the car: ");
            int year = input.nextInt();
            input.nextLine();
            System.out.println("Enter the engine size of the car: ");
            double engineSize = input.nextDouble();
            input.nextLine();
            Car car = new Car(make, model, year, engineSize);
            fleet[counter] = car;
            counter++;
            System.out.println("Do you want to enter more cars? (yes/no)");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                moreEntries = false;
            }
        }
        System.out.println("The cars in the garage are: ");
        for (int i = 0; i < fleet.length; i++) {
            if (fleet[i] != null) {
                System.out.println(fleet[i]);
            }
        }
    }
}
