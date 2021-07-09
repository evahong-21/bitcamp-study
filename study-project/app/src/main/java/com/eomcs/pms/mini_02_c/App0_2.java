package com.eomcs.pms.mini_02_c;

import java.util.Date;
import java.util.Scanner;

//4. for문 사용.

public class App0_2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] no = new int[5];
    String[] name = new String[5];
    String[] email = new String[5];
    String[] passwd = new String[5];
    String[] photo = new String[5];
    String[] tel = new String[5];
    Date[] regisDate = new Date[5];

    Scanner scn = new Scanner(System.in);
    ///////////////////////////////////1번째
    System.out.println("[회원]");
    for (int i=0;i<5;i++) {
      System.out.println("번호? ");
      no[i] = Integer.parseInt(scn.nextLine());

      System.out.println("이름? ");
      name[i] = scn.nextLine();

      System.out.println("이메일? ");
      email[i] = scn.nextLine();

      System.out.println("암호? ");
      passwd[i] = scn.nextLine();

      System.out.println("사진? ");
      photo[i] = scn.nextLine();

      System.out.println("전화? ");
      tel[i] = scn.nextLine();

      regisDate[i] = new Date();
      System.out.println();
    }

    scn.close();

    System.out.println("---------------------");
    for (int j =0; j<5;j++) {
      System.out.printf("번호: %s",no[j]);
      System.out.printf("\n이름: %s", name[j]);
      System.out.printf("\n이메일: %s", email[j]);
      System.out.printf("\n암호: %s", passwd[j]);
      System.out.printf("\n사진: %s", photo[j]);
      System.out.printf("\n전화: %s", tel[j]);
      //System.out.printf("\n가입일: %1$tY-%1$tm-%1$td", date); // 아래랑 같은 결과.
      System.out.printf("\n가입일: %s",regisDate[j]); 
      System.out.println();
    }
  }

}
