/**
 * @author e43814
 */
package com.rmit.week5.Shop;
public class Item implements Comparable<Item> {
    private double price;
    private String name;
    private int quantity;
    //these three constructors are overloaded because they have
    //different list of parameters
    public Item() {
    } 
    public Item(String name, double price) {
        this.price = price;
        this.name = name;
    }
    public Item(String name, double price, int quantity) {
       this(name, price); //constructor chaining
       //this.name = name;
       //this.price = price;
       this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity(){
      return quantity;
    }
    public void setQuantity(int quantity){
      this.quantity = quantity;
    }
  
    @Override
    public String toString(){
        return name + "  $" + price;
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.price, o.price);
    }

}
