package com.rmit.week4;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {
    private ArrayList<Item> items = new ArrayList<>();

    public ShoppingList() {
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeItemByIndex(int index) {
        items.remove(index);
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void displayNumberOfItems() {
        System.out.println("Number of items: " + items.size());
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public int findItemByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void run() {
        ShoppingList shoppingList = new ShoppingList();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        System.out.println("Welcome to Shopping List App");
        System.out.println("Please select one of the following options:");
        while (run) {
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Display items");
            System.out.println("4. Display number of items");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();
                    Item item = new Item(name, price, qty);
                    shoppingList.addItem(item);
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    int index = shoppingList.findItemByName(itemName);
                    if (index != -1) {
                        shoppingList.removeItemByIndex(index);
                        System.out.println("Item removed successfully");
                    } else {
                        System.out.println("Item not found");
                    }
                    break;
                case 3:
                    shoppingList.displayItems();
                    break;
                case 4:
                    shoppingList.displayNumberOfItems();
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
