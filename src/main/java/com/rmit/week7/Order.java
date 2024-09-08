package com.rmit.week7;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Order {
    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private ArrayList<Item> items = new ArrayList<Item>();

    public void addItem() {
        String item = Utils.readString("Enter item:");
        double price = Utils.readDouble("Enter price:");
        items.add(new Item(item, price));
    }

    public void saveItems() {
        try {
            fos = new FileOutputStream("items.dat");
            oos = new ObjectOutputStream(fos);
            for (Item item : items) {
                oos.writeObject(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readItems() {
        items.clear();
        try {
            fis = new FileInputStream("items.dat");
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Object object = ois.readObject();
                    Item item = (Item) object;
                    items.add(item);
                    System.out.println(item);
                } catch (EOFException eof) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Add item");
            System.out.println("2. List items");
            System.out.println("3. Save items");
            System.out.println("4. Read items");
            System.out.println("5. Exit");
            choice = Utils.readInt("Enter your choice:");
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    for (Item item : items) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    saveItems();
                    break;
                case 4:
                    readItems();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
