/** Rmit.java will test subclasses of Person
 */
package com.rmit.week3.PersonArray;

public class Rmit {
  public static void main(String[] args) {
    Person[] persons = new Person[5];
    Student s1 = new Student("Greg Nickolson", "23 Black St",
        "1111111", "java@hot.com");
    s1.setProgram("Networking");
    s1.setYear(1);
    System.out.println(s1.toString());
    Student s2 = new Student("Sandra", "3 Space Rd", "3333333",
        "san@gmail.com", "CNNA", 2);
    System.out.println(s2);
    String dateHired = "23:02:2018";
    Employee e1 = new Employee("Bruce Willis", "3 White St",
        "99999999", "bruce@yahoo.com", 123000,
        dateHired, "51.3.3");
    System.out.println(e1.toString());
    Employee e2 = new Employee("John Doe", "5 Red St",
        "88888888", "john@gmail.com", 95000,
        dateHired, "51.3.4");

    // Add students and employees to the array
    persons[0] = s1;
    persons[1] = s2;
    persons[2] = e1;
    persons[3] = e2;

    // Display all array elements (do not display nulls).
    for (int i = 0; i < persons.length; i++) {
      if (persons[i] != null) {
        System.out.println(persons[i]);
      }
    }

    // Display only students with use of instanceof operator
    // Using enhanced for loop (for-each loop)
    for (Person person : persons) {
      if (person instanceof Student) {
        System.out.println(person);
      }
    }
  }
}