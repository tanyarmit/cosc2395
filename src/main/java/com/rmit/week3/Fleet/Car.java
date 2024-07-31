package com.rmit.week3.Fleet;
/*class Car will use overloaded constructors. Each constructor can use
 * another existing constructor. It's called constructor chaining
 */

public class Car {
  // instance variables
  private String make;
  private String model;
  private int year;
  private double engine;
  private boolean isInGarage = false;

  // constructors
  public Car() {
  } // null constructor

  public Car(String make, String model) {
    this.make = make;
    this.model = model;
  }

  public Car(String make, String model, int year) {
    this(make, model);
    this.year = year;
  }

  public Car(String make, String model, int year, double engine) {
    this(make, model, year);
    this.engine = engine;
  }

  // accressor methods
  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public double getEngine() {
    return engine;
  }

  @Override
  public String toString() {
    return make + " " + model + " " + year +
        "\nengine: " + engine;
  }

  public boolean isInGarage() {
    return isInGarage;
  }

  public void setInGarage(boolean isInGarage) {
    this.isInGarage = isInGarage;
  }
}
