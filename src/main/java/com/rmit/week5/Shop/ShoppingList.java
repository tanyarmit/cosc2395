package com.rmit.week5.Shop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author e43814
 */

public class ShoppingList {
  ArrayList<Item> list = new ArrayList<Item>();

  public ShoppingList() {
  }

  // add Item
  public void addItem() {
    Scanner input = new Scanner(System.in);
    System.out.print("Item name: ");
    String name = input.nextLine();
    System.out.print("Item price: ");
    double price = input.nextDouble();
    System.out.print("Quantity: ");
    int quantity = input.nextInt();
    // create an item
    Item item = new Item(name, price, quantity);
    // add to ArrayList
    list.add(item);
  }

  public void addItems() {
    Scanner input = new Scanner(System.in);
    String answer = "n";
    do {
      addItem();
      System.out.println("Do you want to add another item? y/n");
      answer = input.nextLine();
    } while (answer.equals("y"));
  }

  // display list
  public void listItems() {
    for (Item item : list)
      System.out.println(item);
  }

  // search by name
  private void searchByName() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name for search: ");
    String name = input.nextLine();
    for (Item currentItem : list) {
      if (name.equalsIgnoreCase(currentItem.getName()))
        System.out.println(currentItem);
    }
  }

  // better version of method searchByName
  public Item searchItemByName(String name) {
    for (Item currentItem : list) {
      if (name.equalsIgnoreCase(currentItem.getName()))
        return currentItem;
    }
    return null;
  }

  private void removeByName() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name to remove: ");
    String name = input.nextLine();
    for (int i = 0; i < list.size(); i++) {
      Item item = list.get(i);
      if (name.equalsIgnoreCase(item.getName()))
        list.remove(item);
    }
  }

  // better version of method removeByName using search method
  private void removeByName2() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name to remove: ");
    String name = input.nextLine();
    Item item = searchItemByName(name);
    list.remove(item);

  }

  private void displayNumberOfItems() {
    System.out.println("Number of items on list: " + list.size());
    int totalNumber = 0;
    for (Item item : list) {
      totalNumber += item.getQuantity();
    }
    System.out.println("Total Number of items: " + totalNumber);
  }

  private void totalAmount() {
    double totalPrice = 0.0;
    for (Item item : list) {
      totalPrice += item.getPrice() * item.getQuantity();
    }
    System.out.println("Total price of items: " + totalPrice);
  }

  public void sortByPrice() {
    list.sort(null);
    System.out.println("Sorted by price");
    listItems();
  }

  public void run() {
    boolean flag = true;
    while (flag) {
      System.out.println("Choose:\n" +
          "1-Add item\n" +
          "2-List items\n" +
          "3-Search by name\n" +
          "4-Remove by name\n" +
          "5-Display number of items\n" +
          "6-Sort items\n" +
          "7-Exit\n");
      int option = 0;
      Scanner input = new Scanner(System.in);
      option = input.nextInt();
      switch (option) {
        case 1:
          addItem();
          break;
        case 2:
          listItems();
          break;
        case 3:
          searchByName();
          break;
        case 4:
          removeByName();
          break;
        case 5:
          displayNumberOfItems();
          totalAmount();
          break;
        case 6:
          sortByPrice();
          break;
        case 7:
          flag = false;
          break;
        default:
          System.out.println("Wrong option");
      }// switch
    } // while
  } // run
} // end of class