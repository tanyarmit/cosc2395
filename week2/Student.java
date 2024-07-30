package week2;

public class Student extends Person {
    private String program;
    private int year;

    public Student() {
        super();
    }

    public Student(String name) {
        super(name);
    }

    public Student(String name, int age, String address, String program, int year) {
        super(name, age, address);
        this.program = program;
        this.year = year;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", program=" + program + ", age=" + age + ", year=" + year + ", address="
                + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
    }

}
