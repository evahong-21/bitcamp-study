package com.eomcs.pms.mini_02_c;

import java.util.Date;
import java.util.Scanner;

// 8. 날짜의 출력형식을 "yyyy-mm-dd"로 변경.
// 9. 받은 배열값 출력하기.
public class App0_5 {

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

      System.out.print("계속 입력하시겠습니까? (y/N) "); // 그냥 엔터치면 N가 defualt.
      String input = scn.nextLine();
      size++;
      if (input.equalsIgnoreCase("N") || input.equals("")) { //문자열끼리 비교할때는 == 이 성립되지 않음. .equals(비교문자)
        break;
      }
      System.out.println();
    }

    scn.close();

    System.out.println("---------------------");
    for (int j =0; j<size;j++) {
      System.out.printf("\n%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n",
          no[j],
          name[j],
          email[j],
          tel[j],
          regisDate[j]);
    }
  }

}
