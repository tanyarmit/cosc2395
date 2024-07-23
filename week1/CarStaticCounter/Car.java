/** Car1 will have set methods and toString()
  */
public class Car{
  //instance variables
  private String make;
  private String model;
  private int year;
  private int carID;
  static int nextID = 1;
  //constructor with parameters
  public Car(String make, String model, int year){
    this.make = make;
    this.model = model;
    this.year = year;
    carID = nextID++;
  }
  //no-args constructor
  public Car(){
    carID = nextID++;
  }
   //get methods
  public String getMake(){
    return make;
  }
  public String getModel(){
    return model;
  }
  public int getYear(){
    return year;
  }
  public int getCarID(){
    return carID;
  }
  //set methods
  public void setMake(String make){
    this.make = make;
  }
  public void setModel(String model){
    this.model = model;
  }
  public void setYear(int year){
    this.year = year;
  }
  //standard method to display object
  public String toString(){
    return "Car#" + carID + " " + make + " " + model + " year " + year;
  }
   
 
}
  
  