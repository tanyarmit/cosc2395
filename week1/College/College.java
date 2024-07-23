public class College{
  public static void main(String[] args){
    Tutor tutor1 = new Tutor("e43888", "Christina");
    //create instance of Course
    Course c1 = new Course("COSC2395", "Programming", 20);
    System.out.println(c1.toString());
    //set tutor
    c1.setTutor(tutor1);
    //display tutor
    System.out.println("Tutor: " + c1.getTutor());
   
  }
}