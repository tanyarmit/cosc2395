package week2;

public class RunPet {
    public static void main(String[] args) {
        Person person = new Person("John", 30, "123 Main St");
        Pet pet = new Pet("Fido", 5, person);
        // System.out.println(pet.getName());
        // System.out.println(pet.getAge());
        System.out.println(pet);
        System.out.println(pet.getOwner().getName());
        System.out.println(pet.getOwner().getAge());
        System.out.println(pet.getOwner().getAddress());
    }
}
