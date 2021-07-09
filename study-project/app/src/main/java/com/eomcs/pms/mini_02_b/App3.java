package com.eomcs.pms.mini_02_b;

import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("[작업]");
    Scanner scn = new Scanner(System.in); // scn은 reference = 곧 리모콘

    System.out.println("프로젝트? ");
    String project = scn.nextLine();

    System.out.println("번호? ");
    String num = scn.nextLine();

    System.out.println("내용? ");
    String context = scn.nextLine();

    System.out.println("완료일? ");
    //String finishDate = scn.nextLine();
    java.sql.Date endDate = java.sql.Date.valueOf(scn.nextLine());

    System.out.println("상태? \n0: 신규\n1: 진행중\n2: 완료\n> ");
    int nowState = scn.nextInt();
    scn.nextLine();

    System.out.println("담당자? ");
    String manager = scn.nextLine();
    scn.close();
    System.out.println(nowState+2);
    System.out.println("---------------------");
    System.out.printf("프로젝트: %s",project);
    System.out.printf("\n번호: %s",num);
    System.out.printf("\n내용: %s", context);
    System.out.printf("\n완료일: %s",endDate);

    /*
    방법 1.
    if (nowState==0) {  
      System.out.println("\n상태: 신규");
      } else if(nowState==1) { 
      System.out.println("\n상태: 진행중");
      } else if(nowState==2) { 
      System.out.println("\n상태: 완료");
      } else {  
      System.out.println("\n잘못 입력하셨습니다.");
      }

    //System.out.printf("\n상태: %%d$s",nowState+2,"신규","진행중","완료"); > 해결못함.
     */
    //방법 2
    switch(nowState) {
      case 0:
        System.out.println("\n상태: 신규");
        break;
      case 1:
        System.out.println("\n상태: 진행중");
        break;
      case 2:
        System.out.println("\n상태: 완료");
    }

    System.out.printf("담당자: %s",manager);


  }

}
