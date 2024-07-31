package com.rmit.week2.Uni;

public class RunStudent {
    public static void main(String[] args) {
        Student student = new Student("John", 30, "123 Main St", "Computer Science", 2);
        System.out.println(student);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getAddress());
        System.out.println(student.getProgram());
        System.out.println(student.getYear());

        Employee employee1 = new Employee();
        employee1.setName("Jane");
        employee1.setAge(25);
        employee1.setAddress("456 Elm St");
        employee1.setPhoneNumber("555-1234");
    }
}
