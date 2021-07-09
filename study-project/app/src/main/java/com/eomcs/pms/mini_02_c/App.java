package com.eomcs.pms.mini_02_c;

import java.util.Scanner;

// 1) 배열 사용 전 Check!
// 2) 배열 사용 후 Check!
// 3) 반복문 적용 : while문 : Check!
// 4) 반복문 적용 : for문 : Check!
// 5) 여러 문장에서 반복해서 사용하는 값은 변수에 담아서 사용. : Check!
// 6) 조회용으로만 사용할 변수라면 상수로 선언한다. 
//      > 변수명 대문자, 두단어 사이엔 _ : refactory  > rename : Check!
// 7) 특정 조건에 따라 반복을 멈춘다. : Check! 
// 8) 날짜의 출력형식을 "yyyy-mm-dd"로 변경한다. :Check!
public class App {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    java.util.Date date = new java.util.Date();
    java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());

    final int MAX_LENGTH = 100;
    int[] num = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] mail = new String[MAX_LENGTH];
    String[] passwd = new String[MAX_LENGTH];
    String[] pic = new String[MAX_LENGTH];
    String[] phone = new String[MAX_LENGTH];

    // 키보드 입력 및 프로젝트 네임 출력
    Scanner scn = new Scanner(System.in);
    System.out.println("[회원]");

    // 입력값 배열에 저장.
    // int i = 0;
    int j = 0;
    for (int i=0; i<MAX_LENGTH; i++) {
      System.out.print("번호? ");
      num[i] = Integer.parseInt(scn.nextLine());

      System.out.print("이름? ");
      name[i] = scn.nextLine();

      System.out.print("이메일? ");
      mail[i] = scn.nextLine();

      System.out.print("암호? ");
      passwd[i] = scn.nextLine();

      System.out.print("사진? ");
      pic[i] = scn.nextLine();

      System.out.print("전화? ");
      phone[i] = scn.nextLine();
      //i++;

      System.out.print("\n계속 입력하시겠습니까? (y/N) ");
      String input = scn.nextLine();
      System.out.println();

      j++;
      if (input.equalsIgnoreCase("N")) {
        break;
      }
    }
    scn.close();

    System.out.println("---------------------");

    // MAX_LENGTH = 9; 일반 변수가 아닌 상수이므로 중간에 값 변경 불가.
    // 배열에 입력한 값 출력

    //i = 0; // i를 다시 초기화.
    for (int i=0; i<j; i++) {
      System.out.printf("%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n",
          num[i], name[i], mail[i], phone[i], registeredDate);
      //i++; while문에서 사용, for문에선 사용되지 X.
    }

  }

}
