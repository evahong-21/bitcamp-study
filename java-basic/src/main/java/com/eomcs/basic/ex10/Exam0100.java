package com.eomcs.basic.ex10;

public class Exam0100 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    long millis = System.currentTimeMillis();
    System.out.println(millis); //millis는 arguments
    java.util.Date d = new java.util.Date(millis);
    System.out.println(d.toString());

    java.sql.Date d1 = new java.sql.Date(millis);
    System.out.println(d1);
    //new java.sql.Time();

  }

}
