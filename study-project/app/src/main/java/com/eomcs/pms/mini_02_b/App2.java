package com.eomcs.pms.mini_02_b;

import java.sql.Date;
import java.util.Scanner;


public class App2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    /* Scanner 와 Date 의 다른점!
     * Scanner는 클래스를 생성(가져와야)해야 뒤의 모듈을 사용할 수 있는데,
     * Date같은 경우 자동으로 생성되는(valueOf) 모듈이 있으므로 new를 사용안함.
     */

    Scanner scn = new Scanner(System.in);
    System.out.println("[프로젝트]");
    System.out.println("번호? ");
    /* 방법 1.
     * String num = scn.nextLine();
     * 
     * 방법 2.
     * int num = scn.nextInt();
     * scn.nextLine();
     * 
     * 방법 3.
     */

    int num = Integer.parseInt(scn.nextLine()); //만약 문자입력시 에러.

    System.out.println("프로젝트명? ");
    String projectName = scn.nextLine();

    System.out.println("내용? ");
    String context = scn.nextLine();

    System.out.println("시작일? ");
    //String BeginDate = scn.nextLine();
    Date beginDate = Date.valueOf(scn.nextLine()); //앞에 new가 필요없음. valueof 

    System.out.println("종료일? ");
    //String FinishDate = scn.nextLine();
    Date finishDate = Date.valueOf(scn.nextLine());

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
