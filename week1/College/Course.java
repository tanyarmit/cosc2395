public class Course{
  //instance variables
  private String code;
  private String title;
  private Tutor tutor;
  private int weeks;
  
  //constructor/s
  public Course(String code, String title, int weeks){
    //assign parameters to instance variables
    this.code = code;
    this.title = title;
    this.weeks = weeks;
  }
  //standard methods
  //get or accessor methods
  public String getCode(){
    return code;
  }
  public String getTitle(){
    return title;
  }
  public int getWeeks(){
    return weeks;
  }
  public Tutor getTutor(){
    return tutor;
  }
  //set or mutator method/s
  public void setTutor(Tutor tutor){
    this.tutor = tutor;
  }
  //toString method to display object data
  public String toString(){
    return code + " " + title + " " + " lasts " + weeks + " weeks.";
  }
}
  
  