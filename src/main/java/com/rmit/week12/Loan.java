package com.rmit.week12;

import java.time.LocalDate;

public class Loan {
  private static int loanId;
  private int custId;
  private int bookId;
  private LocalDate date;
  private int days;

  public Loan(int cid, int bid) {
    custId = cid;
    bookId = bid;
    date = LocalDate.now();
    loanId++;
  }

  public Loan(int cid, int bid, int days) {
    custId = cid;
    bookId = bid;
    this.days = days;
    date = LocalDate.now();
    loanId++;
  }

  public int getCustId() {
    return custId;
  }

  public int getBookId() {
    return bookId;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(int year, int month, int d) {
    LocalDate newDate = LocalDate.of(year, month, d);
    date = newDate;
  }

  public void setDate(String dateStr) {
    LocalDate newDate = LocalDate.parse(dateStr);
    date = newDate;
  }

  public void setDays(int days) {
    this.days = days;
  }

  public String toString() {
    return "Customer #" + custId + " has on loan book #" + bookId + "\nfrom " + date + " for " + days + " days";
  }
}