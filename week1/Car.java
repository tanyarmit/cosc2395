
/**
 * The Car class represents a car object with make, model, year, and carID
 * attributes.
 */
public class Car {

    /**
     * The make of the car.
     */
    private String make;

    /**
     * The model of the car.
     */
    private String model;

    /**
     * The year of the car.
     */
    private int year;

    /**
     * The unique identifier of the car.
     */
    private int carID;

    /**
     * The next available identifier for a new car.
     */
    int nextID;

    /**
     * Constructs a default Car object.
     */
    public Car() {
    }

    /**
     * Constructs a Car object with the specified make, model, and year.
     *
     * @param make  the make of the car
     * @param model the model of the car
     * @param year  the year of the car
     */
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * Constructs a Car object with the specified carID.
     *
     * @param carID the unique identifier of the car
     */
    public Car(int carID) {
        this.carID = carID;
    }

    /**
     * Constructs a Car object with the specified make, model, year, and carID.
     *
     * @param make  the make of the car
     * @param model the model of the car
     * @param year  the year of the car
     * @param carID the unique identifier of the car
     */
    public Car(String make, String model, int year, int carID) {
        this(make, model, year);
        this.carID = carID;
    }

    /**
     * Sets the make of the car.
     *
     * @param make the make of the car
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Sets the model of the car.
     *
     * @param model the model of the car
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets the year of the car.
     *
     * @param year the year of the car
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Sets the carID of the car.
     *
     * @param carID the unique identifier of the car
     */
    public void setCarID(int carID) {
        this.carID = carID;
    }

    /**
     * Sets the nextID for the next available identifier of a new car.
     *
     * @param nextID the next available identifier for a new car
     */
    public void setNextID(int nextID) {
        this.nextID = nextID;
    }

    /**
     * Returns the make of the car.
     *
     * @return the make of the car
     */
    public String getMake() {
        return make;
    }

    /**
     * Returns the model of the car.
     *
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the year of the car.
     *
     * @return the year of the car
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the carID of the car.
     *
     * @return the unique identifier of the car
     */
    public int getCarID() {
        return carID;
    }

    /**
     * Returns the nextID for the next available identifier of a new car.
     *
     * @return the next available identifier for a new car
     */
    public int getNextID() {
        return nextID;
    }

    public static void test(int nextID) {
        System.out.println("Next ID: " + nextID);

    }
}