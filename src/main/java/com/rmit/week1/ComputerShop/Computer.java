package com.rmit.week1.ComputerShop;

public class Computer {
  // instance variables
  private String make;
  private String processor;
  private int memory;
  private int year;
  private double price;

  // constructors
  public Computer() {
  }

  public Computer(String make, String processor) {
    this.make = make;
    this.processor = processor;
  }

  public Computer(String make, String processor, int memory) {
    this(make, processor);
    /*
     * if(memory >=4 && memory <=20)
     * this.memory = memory;
     * else
     * memory = 0;
     */
    setMemory(memory);
  }

  // get methods or accessor methods
  public String getMake() {
    return make;
  }

  public String getProcessor() {
    return processor;
  }

  public int getMemory() {
    return memory;
  }

  public int getYear() {
    return year;
  }

  public double getPrice() {
    return price;
  }

  // set methods or mutator methods
  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public void setMemory(int memory) {
    if (memory >= 4 && memory <= 20)
      this.memory = memory;
    else
      memory = 0;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String toString() {
    return "Computer: " + make + " " + processor + " " + memory + " Tb\nYear: " + year + "\nprice: " + price;
  }
}// class