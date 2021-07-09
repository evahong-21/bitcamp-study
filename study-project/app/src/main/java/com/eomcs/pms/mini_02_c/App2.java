package com.eomcs.pms.mini_02_c;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    //java.util.Date date = new java.util.Date();
    //java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());

    final int MAX_LENGTH = 100;
    int[] num = new int[MAX_LENGTH];
    String[] projectName = new String[MAX_LENGTH];
    String[] Context = new String[MAX_LENGTH];
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] maker = new String[MAX_LENGTH];
    String[] team = new String[MAX_LENGTH];

    // 키보드 입력 및 프로젝트 네임 출력
    Scanner scn = new Scanner(System.in);
    System.out.println("[프로젝트]");

    // 입력값 배열에 저장.
    // int i = 0;
    int j = 0;
    for (int i=0; i<MAX_LENGTH; i++) {
      System.out.print("번호? ");
      num[i] = Integer.parseInt(scn.nextLine());

      System.out.print("프로젝트명? ");
      projectName[i] = scn.nextLine();

      System.out.print("내용? ");
      Context[i] = scn.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(scn.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(scn.nextLine());

      System.out.print("만든이? ");
      maker[i] = scn.nextLine();

      System.out.print("팀원? ");
      team[i] = scn.nextLine();


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
      System.out.printf("%d, %s, %s, %s, %s\n",
          num[i], projectName[i], startDate[i], endDate[i], maker[i]);
      //i++; while문에서 사용, for문에선 사용되지 X.
    }

  }

}
