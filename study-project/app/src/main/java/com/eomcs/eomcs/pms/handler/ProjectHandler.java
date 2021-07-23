package com.eomcs.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.eomcs.pms.domain.Project;
import com.eomcs.eomcs.util.Prompt;

public class ProjectHandler {
  static final int MAX_LENGTH = 5;
  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;


  public void add(MemberHandler memberHandler) {
    System.out.println("[프로젝트 등록]");
    Project project = new Project();
    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    /////멤버중에 만든이가 존재해야 만든이 생성.
    project.owner = promptOwner(memberHandler, null);
    // 입력값중에 멤버에 포함되지 않으면 project.owner 는 null이 됨.
    if (project.owner==null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return; 
    }

    //멤버중에 만든이가 존재해야 팀원생성.
    project.members = promptMembers(memberHandler, null);
    // 입력값중에 멤버에 포함되지 않으면 project.owner 는 null이 됨.
    if (project.members==null) {
      System.out.println("등록된 회원이 아닙니다.");
      System.out.println("프로젝트 등록을 취소합니다.");
      return; // 메서드 실행을 즉시 종료!
    }
    //생성된 projects 레퍼런스에 project 주소값 저장.
    this.projects[this.size++] = project;
  }

  /////레퍼런스에 저장된 project주소 전체의 인스턴스 변수를 가져옴.
  public void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          this.projects[i].no, 
          this.projects[i].title, 
          this.projects[i].startDate, 
          this.projects[i].endDate, 
          this.projects[i].owner,
          this.projects[i].members);
    }
  }

  /////하나의 project주소의 인스턴스 변수 값 불러옴.
  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");
    //입력 번호가 project에 저장되어 있음녀 호출
    Project project = findByNo(no);
    //아니면 return.
    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }
    System.out.printf("프로젝트명: %s\n", project.title);
    System.out.printf("내용: %s\n", project.content);
    System.out.printf("시작일: %s\n", project.startDate);
    System.out.printf("종료일: %s\n", project.endDate);
    System.out.printf("만든이: %s\n", project.owner);
    System.out.printf("팀원: %s\n", project.members);
  }

  ///// 기존에 저장되어 있던 레퍼런스 주소값들의 정보를 변경.
  public void update(MemberHandler memberHandler) {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");
    //입력 번호가 project에 저장되어 있음녀 호출.
    Project project = findByNo(no);
    //아니면 return.
    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.startDate));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));
    //기존의 project.owner가 존재하면 update메서드에서 사용.
    String owner = promptOwner(memberHandler, project.owner);
    // 새 입력한 만든이가 맴버에 존재하지 않으면 null 리턴 > 메서드 종료.
    if (owner == null) {
      System.out.println("등록된 회원이 아닙니다.");
      System.out.println("프로젝트 변경을 취소합니다.");
      return; // 메서드 실행을 즉시 종료!
    }
    //기존의 project.members가 존재하면 update메서드에서 사용.
    String members = promptMembers(memberHandler, project.members);
    // 새 입력한 팀원이 맴버에 존재하지 않으면 null 리턴 > 메서드 종료.
    if (members == null) {
      System.out.println("등록된 회원이 아닙니다.");
      System.out.println("프로젝트 변경을 취소합니다.");
      return; // 메서드 실행을 즉시 종료!
    }  

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }
    //변경 한다는 뜻.
    project.title = title;
    project.content = content;
    project.startDate = startDate;
    project.endDate = endDate;
    project.owner = owner;
    project.members = members;
    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");
    //입력한 번호가 이미 존재하는지 확인하여 없으면 메서드 종료.
    int index = indexOf(no);
    if (index == -1) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }
    //없앨 주소값에서 뒤 주소값이 하나씩 앞으로 덮어쓰기. 맨 뒤 주소값은 null로 채워넣음.
    for (int i = index + 1; i < this.size; i++) {
      this.projects[i - 1] = this.projects[i];
    }
    this.projects[--this.size] = null;
    System.out.println("프로젝트를 삭제하였습니다.");
  }

  private Project findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        return this.projects[i];
      }
    } return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        return i;
      }
    } return -1;
  }

  private String promptOwner(MemberHandler memberHandler, String oldOwner) {
    while (true) {
      // String owner값이 비어져 있으면 add // 만약에 들어가 있으면 update.
      String owner = Prompt.inputString(String.format(
          "만든이?%s(취소: 빈 문자열) ", 
          oldOwner != null ? "("+oldOwner+")" : ""));
      if (memberHandler.exist(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      } 
    }
  }

  private String promptMembers(MemberHandler memberHandler, String oldMember) {
    String newMember = "";
    while (true) {
      String member = Prompt.inputString(String.format(
          "팀원?%s(완료: 빈 문자열) ", 
          oldMember != null ? "("+oldMember+")":""));
      if (memberHandler.exist(member)) {
        if (newMember.length() > 0) {
          newMember += ",";
        }
        newMember += member;
        continue;
      } else if (member.length() == 0) {
        return newMember;
      } else {
        return null;
      }
    }
  }
}
