package com.rmit.week12;
/**
 * @author e43814
 */
import java.io.Serializable; //Serializable interface
public class Book implements Serializable{
    private int bookId;
    private String title;
    private String author;
    private boolean available;
    static int nextID = 1;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        bookId = nextID++;
    }

      public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

   
    public String toString(){
        return "Book ID:" + bookId + ". Author: " + author + ". Title: " + title ;
    }

}