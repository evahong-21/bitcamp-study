package com.eomcs.pms.mini_02_b;

import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    //java.sql.Date date = new java.sql.Date();

    Scanner scn = new Scanner(System.in);
    System.out.println("[프로젝트]");

    System.out.println("번호? ");
    String num = scn.nextLine();

    System.out.println("프로젝트명? ");
    String projectName = scn.nextLine();

    System.out.println("내용? ");
    String context = scn.nextLine();

    System.out.println("시작일? ");
    //String BeginDate = scn.nextLine();
    java.sql.Date beginDate = java.sql.Date.valueOf(scn.nextLine());

    System.out.println("종료일? ");
    //String FinishDate = scn.nextLine();
    java.sql.Date finishDate = java.sql.Date.valueOf(scn.nextLine());

    System.out.println("만든이? ");
    String makerName = scn.nextLine();

    System.out.println("팀원? ");
    String teamMate = scn.nextLine();
    scn.close();

    System.out.println("------------------------");
    System.out.printf("번호: %s", num);
    System.out.printf("\n프로젝트명: %s", projectName);
    System.out.printf("\n내용: %s", context);
    System.out.printf("\n시작일: %s", beginDate);
    System.out.printf("\n종료일: %s", finishDate);
    System.out.printf("\n만든이: %s", makerName);
    System.out.printf("\n팀원: %s", teamMate);

  }

}
