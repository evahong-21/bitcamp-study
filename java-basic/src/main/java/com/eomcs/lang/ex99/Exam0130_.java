package com.eomcs.lang.ex99;

public class Exam0130_ {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    java.util.Date today = new java.util.Date();

    /* 형식 : %t(입력)
     * 년 : Y(4자리표시), y(2자리표시)
     * 월 : 문자 - B(January), b(Jan) / 숫자 - m
     * 일 : d(2자리 표시), e(1자리 표시)
     * 요일 : A(Sunday), a(Sun)
     * 시간 : H(24시), I(12시), M(분), S(초), L(밀리초), N(나노초)
     */

    System.out.println(today);
    System.out.printf("%1$tm %1$tM", today);
    System.out.printf("\n%1$tY %1$ty", today);
    System.out.printf("\n%1$td %1$tD", today);
    System.out.printf("\n%1$ts %1$tS", today);
    System.out.printf("\n%1$ta %1$tA", today);
    System.out.printf("\n%1$tH %1$tM", today);

  }

}
