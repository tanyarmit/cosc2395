public class Garage {
    public static void main(String[] args) {

        Car.test(12345);
        
        Car car1 = new Car("Toyota", "Camry", 2018, 1);
        Car car2 = new Car("Toyota", "Corolla", 2018, 2);
        Car car3 = new Car("Toyota", "Prius", 2018, 3);
        Car car4 = new Car("Toyota", "RAV4", 2018, 4);
        Car car5 = new Car("Toyota", "Highlander", 2018, 5);
        car5.setCarID(6);

        System.out.println(
                "Car 1: " + car1.getMake() + " " + car1.getModel() + " " + car1.getYear() + " " + car1.getCarID());
        System.out.println(
                "Car 2: " + car2.getMake() + " " + car2.getModel() + " " + car2.getYear() + " " + car2.getCarID());
        System.out.println(
                "Car 3: " + car3.getMake() + " " + car3.getModel() + " " + car3.getYear() + " " + car3.getCarID());
        System.out.println(
                "Car 4: " + car4.getMake() + " " + car4.getModel() + " " + car4.getYear() + " " + car4.getCarID());
        System.out.println(
                "Car 5: " + car5.getMake() + " " + car5.getModel() + " " + car5.getYear() + " " + car5.getCarID());

    }
}
