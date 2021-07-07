package com.eomcs.pms.mini_02_b;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    java.util.Date date = new java.util.Date();
    java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());

    Scanner scn = new Scanner(System.in);
    System.out.println("[회원]");

    System.out.println("번호? ");
    String num = scn.nextLine();

    System.out.println("이름? ");
    String name = scn.nextLine();

    System.out.println("이메일? ");
    String mail = scn.nextLine();

    System.out.println("암호? ");
    String passwd = scn.nextLine();

    System.out.println("사진? ");
    String pic = scn.nextLine();

    System.out.println("전화? ");
    String phone = scn.nextLine();
    scn.close();

    System.out.println("---------------------");
    System.out.printf("번호: %s",num);
    System.out.printf("\n이름: %s", name);
    System.out.printf("\n이메일: %s", mail);
    System.out.printf("\n암호: %s", passwd);
    System.out.printf("\n사진: %s", pic);
    System.out.printf("\n전화: %s", phone);
    //System.out.printf("\n가입일: %1$tY-%1$tm-%1$td", date); // 아래랑 같은 결과.
    System.out.printf("\n가입일: %s",registeredDate);
  }

}
