package com.rmit.week3.PersonArray;

public class Employee extends Person {
  private double salary;
  private String dateHired;
  private String office;

  public Employee() {
    super();
  }

  public Employee(String name, String address, String phone, String email, double salary, String dateHired,
      String office) {
    super(name, address, phone, email);
    this.salary = salary;
    this.dateHired = dateHired;
    this.office = office;
  }

  // get and set methods for salary and office
  public String getDateHired() {
    return dateHired;
  }

  public void setDateHired(String dateHired) {
    this.dateHired = dateHired;
  }

  public String toString() {
    return super.toString() + "\nSalary: " +
        salary + "\nHired: " + dateHired + "\nOffice: " + office;
  }
}
