package com.eomcs.prac.pms.handler;

import java.sql.Date;
import com.eomcs.prac.pms.domain.Task;
import com.eomcs.prac.util.Prompt;

public class TaskHandler {

  static final int MAX_LENGTH = 5;
  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add(MemberHandler memberHandler) {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");
    task.status = promptStatus();

    task.owner = promptOwner(memberHandler);
    if (task.owner == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; // 메서드 실행을 즉시 종료!
    }
    this.tasks[this.size++] = task;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < this.size; i++) {
      String stateLabel = getStatusLabel(this.tasks[i].status);

      System.out.printf("%d, %s, %s, %s, %s\n",
          this.tasks[i].no, 
          this.tasks[i].content, 
          this.tasks[i].deadline, 
          stateLabel, 
          this.tasks[i].owner);
    }
  }
  public void detail() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");
    Task task = findByNo(no);

    if (task==null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }
    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);

    String stateLabel = getStatusLabel(task.status);

    System.out.printf("상태: %s\n", stateLabel);
    System.out.printf("담당자: %s\n", task.owner);
  }

  public void update(MemberHandler memberHandler) {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");
    Task task = findByNo(no);

    if (task==null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }
    String content =  Prompt.inputString(String.format("내용(%s)?", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)?", task.deadline));
    int status = promptStatus(task.status);

    String owner = promptOwner(memberHandler, task.owner);
    if (task.owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return; // 메서드 실행을 즉시 종료!
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");

    if (input.equalsIgnoreCase("y")) {
      task.content = content;
      task.deadline = deadline;
      task.owner = owner;
      task.status = status;

      System.out.println("작업을 변경하였습니다.");
    } else {
      System.out.println("작업 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[작업 삭제]");
    int no = Prompt.inputInt("번호? ");
    int deleteNo = indexOf(no);
    if (deleteNo == -1) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("y")) {
      for (int i=deleteNo+1 ; i<this.size; i++) {
        this.tasks[i-1] = this.tasks[i];
      }
      this.tasks[--this.size] = null;
      System.out.println("작업을 삭제하였습니다.");
    } else {
      System.out.println("작업 삭제를 취소하였습니다.");
    }
  }
  private Task findByNo(int no) {
    for (int i=0; i<this.size; i++) {
      if (this.tasks[i].no == no) {
        return this.tasks[i];
      }
    } return null;
  }

  private int indexOf(int no) {
    for (int i=0; i<this.size; i++) {
      if (this.tasks[i].no == no) {
        return i;
      }
    } return -1;
  }

  private String promptOwner(MemberHandler memberHandler) {
    return promptOwner(memberHandler,null);
  }

  private String promptOwner(MemberHandler memberHandler, String oldOwner) {
    String owner = null;
    while (true) {
      owner = Prompt.inputString(String.format(
          "만든이%s?(취소: 빈 문자열) ", 
          oldOwner != null ? "("+oldOwner+")": ""));
      if (memberHandler.exist(owner)) {
        return owner;
      }
      System.out.println("등록된 회원이 아닙니다.");
      return null;
    }
  }

  private String getStatusLabel(int status) {
    String stateLabel = null;
    switch (status) {
      case 1:
        stateLabel = "진행중";
        return stateLabel;
      case 2:
        stateLabel = "완료";
        return stateLabel;
      default:
        stateLabel = "신규";
        return stateLabel;
    }
  }
  private int promptStatus() {
    return promptStatus(-1);
  }

  private int promptStatus(int oldStatus) {
    System.out.printf(String.format("상태%s?\n",
        oldStatus != -1 ? "("+oldStatus+")":""));
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }
}
