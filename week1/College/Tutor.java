public class Tutor{
  private String staffID;
  private String staffName;
  
  public Tutor(){}
  public Tutor(String staffID, String staffName){
    this.staffID = staffID;
    this.staffName = staffName;
  }
  public String getStaffID(){
    return staffID;
  }
  public String getStaffName(){
    return staffName;
  }
  public void setStaffID(String staffID) {
    this.staffID = staffID;
  }
  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }
  @Override
  public String toString(){
    return staffID + " " + staffName;
  }
}