package com.eomcs.pms.mini_04_a;

public class Projecthandler {
  static void addProject() {
    System.out.println("[프로젝트 등록]");

    pNo[pSize] = Prompt.inputInt("번호? ");
    pTitle[pSize] = Prompt.inputString("프로젝트명? ");
    pContent[pSize] = Prompt.inputString("내용? ");
    pStartDate[pSize] = Prompt.inputDate("시작일? ");
    pEndDate[pSize] = Prompt.inputDate("종료일? ");
    pOwner[pSize] = Prompt.inputString("만든이? ");
    pMembers[pSize] = Prompt.inputString("팀원? ");

    pSize++;
  }

  static void listProjects() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < pSize; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
    }
  }
}
