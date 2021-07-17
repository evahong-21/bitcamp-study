package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class Projecthandler {
  // 프로젝트 정보
  static final int MAX_LENGTH = 1000;
  static Project[] projects = new Project[MAX_LENGTH];
  static int Size = 0;

  public static void add() {
    System.out.println("[프로젝트 등록]");
    Project project = new Project();
    project.No = Prompt.inputInt("번호? ");
    project.Title = Prompt.inputString("프로젝트명? ");
    project.Content = Prompt.inputString("내용? ");
    project.StartDate = Prompt.inputDate("시작일? ");
    project.EndDate = Prompt.inputDate("종료일? ");
    project.Owner = Prompt.inputString("만든이? ");
    project.Members = Prompt.inputString("팀원? ");

    projects[Size++] = project;
  }

  public static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < Size; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          projects[i].No, 
          projects[i].Title, 
          projects[i].StartDate, 
          projects[i].EndDate, 
          projects[i].Owner);
    }
  }
}


