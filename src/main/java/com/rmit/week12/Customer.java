package com.rmit.week12;
/**
 *
 * @author e43814
 */

import java.io.Serializable; //Serializable interface
public class Customer implements Serializable{
    private int custID;
    private String custName;
    private String custAddress;
    static int nextID = 100;

    public Customer(String custName, String custAddress) {
        this.custName = custName;
        this.custAddress = custAddress;
        custID = nextID++;
    }

    public int getCustID() {
        return custID;
    }

    public String getCustName() {
        return custName;
    }
    

    public void setCustName(String custName) {
        this.custName = custName;
    }

 
    
    /*public void displayBooks(){
        for(int i = 0; i < booksCount; i++){
            System.out.println (books[i]);
        }
    }
    
   public Book search(int id) {
     for(int i = 0; i <booksCount; i++) {
         if(books[i].getBookId()==id)
             return books[i];
      } 
     return null;
   }
   public Book searchByTitle(String t){
        for(int i = 0; i <booksCount; i++) {
         if(books[i].getTitle().equals(t))
             return books[i];
      } 
     return null;
       
   }*/
  @Override
  public String toString(){
        return "Customer: " + custID + ", " + custName + ", " + custAddress;
      
  }
}
