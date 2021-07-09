package com.eomcs.pms.mini_02_c;

import java.util.Date;
import java.util.Scanner;

// 6. 조회용으로만 사용할 변수라면 상수로 선언한다. final 변수명 대문자
// 상수값은 초기화되면 그뒤로 바뀔 수 없음.
// 7 특정 조건에 따라 반복을 멈춘다.
public class App0_4 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    final int MAX_LENGTH = 100;
    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] passwd = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] tel = new String[MAX_LENGTH];
    Date[] regisDate = new Date[MAX_LENGTH];

    Scanner scn = new Scanner(System.in);
    int size = 0;

    System.out.println("[회원]");
    for (int i=0;i<MAX_LENGTH;i++) {
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

      System.out.println("계속 입력하시겠습니까? (y/N) "); // 그냥 엔터치면 N가 defualt.
      String input = scn.nextLine();
      size++;
      if (input.equalsIgnoreCase("N") || input.equals("")) { //문자열끼리 비교할때는 == 이 성립되지 않음. .equals(비교문자)
        break;
      }
    }

    scn.close();

    System.out.println("---------------------");
    for (int j =0; j<size;j++) {
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
