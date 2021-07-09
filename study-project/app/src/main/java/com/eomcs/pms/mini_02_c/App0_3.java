package com.eomcs.pms.mini_02_c;

import java.util.Date;
import java.util.Scanner;

//5. 여러 분장에서 반복해서 사용하는 값은 변수에 담아서 사용한다.
public class App0_3 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int maxLength = 3;


    int[] no = new int[maxLength];
    String[] name = new String[maxLength];
    String[] email = new String[maxLength];
    String[] passwd = new String[maxLength];
    String[] photo = new String[maxLength];
    String[] tel = new String[maxLength];
    Date[] regisDate = new Date[maxLength];

    Scanner scn = new Scanner(System.in);
    ///////////////////////////////////1번째
    System.out.println("[회원]");
    for (int i=0;i<maxLength;i++) {
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
    for (int j =0; j<maxLength;j++) {
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
