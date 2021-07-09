package com.eomcs.pms.mini_02_c;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 최대 몇번 돌아갈지 상수로 값 받아옴.
    final int MAX_LENGTH = 100;

    //배열생성.
    int[] num = new int[MAX_LENGTH];
    String[] context = new String[MAX_LENGTH];
    Date[] deadLine = new Date[MAX_LENGTH];
    int[] state = new int[MAX_LENGTH];
    String[] manager = new String[MAX_LENGTH];

    // 키보드 입력 및 프로젝트 네임 출력
    Scanner scn = new Scanner(System.in);
    System.out.println("[작업]");
    System.out.print("프로젝트? ");
    String project = scn.nextLine();
    System.out.println();

    // 입력값 배열에 저장.
    int j = 0;
    for (int i=0; i<MAX_LENGTH; i++) {

      // 입력값 받음.
      System.out.print("번호? ");
      num[i] = Integer.parseInt(scn.nextLine());

      System.out.print("내용? ");
      context[i] = scn.nextLine();

      System.out.print("마감일? ");
      deadLine[i] = Date.valueOf(scn.nextLine());

      System.out.print("상태?\n0: 신규\n1: 진행중\n2: 완료\n> ");
      state[i] = Integer.parseInt(scn.nextLine());

      System.out.print("담당자? ");
      manager[i] = scn.nextLine();

      //입력 여부 출력.
      System.out.print("\n계속 입력하시겠습니까? (y/N) ");
      String input = scn.nextLine();
      System.out.println();

      // 몇번 입력 했는지 j에 저장.
      j++;
      if (input.equalsIgnoreCase("N")) {
        break;
      }
    }

    // Scanner 종료.
    scn.close();

    System.out.println("---------------------");
    System.out.printf("[%s]\n", project);
    String stateInput="";

    for (int i=0; i<j; i++) {
      //
      switch(state[i]) {
        case 0:
          stateInput = "신규";
          break;
        case 1:
          stateInput = "진행중";
          break;
        case 2:
          stateInput = "완료";
      }

      System.out.printf("%d, %s, %s, %s, %s\n",
          num[i], context[i], deadLine[i], stateInput, manager[i]);
    }

  }

}
