package week2;

public class Pet {
    private String name;
    private int age;
    private Person owner;

    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet(String name, int age, Person owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet [name=" + name + ", age=" + age + ", owner=" + owner.getName() + "]";
    }

}
