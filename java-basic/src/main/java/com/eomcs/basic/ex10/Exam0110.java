package com.eomcs.basic.ex10;

public class Exam0110 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    java.util.Date d = new java.util.Date(); //Date 객체를 만드는 순간의 시각을 저장해둔다.
    System.out.println(d.toString());
    System.out.printf("%tY-%tm-%td",d,d,d);
    System.out.println();
    System.out.printf("%1$tY-%1$tm-%1$td",d);
  }

}
