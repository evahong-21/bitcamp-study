package com.eomcs.prac.pms.handler;

import java.sql.Date;
import com.eomcs.prac.pms.domain.Board;
import com.eomcs.prac.util.Prompt;

public class BoardHandler {
  static final int MAX_LENGTH = 5;

  // Member 인스턴스의 주소를 저장할 레퍼런스를 3개 생성한다.
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add() {
    System.out.println("[새 게시글]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱 개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.
    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    this.boards[this.size++] = board;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].writer, 
          this.boards[i].registeredDate,
          this.boards[i].viewCount);
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");
    Board board = findByNo(no);

    if (board==null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");
    Board board = findByNo(no);

    if (board==null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String title = Prompt.inputString(String.format("제목(%s)?", board.title));
    String content =  Prompt.inputString(String.format("내용(%s)?", board.content));
    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
    if (input.equalsIgnoreCase("y")) {
      board.title = title;
      board.content = content;
      System.out.println("게시글을 변경하였습니다.");
    } else {
      System.out.println("게시글 변경을 취소하였습니다.");
    }

  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");
    int deleteNo =indexOf(no);

    if (deleteNo == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("y")) {
      for (int i=deleteNo+1 ; i<this.size; i++) {
        this.boards[i-1] = this.boards[i];
      }
      this.boards[--this.size] = null;
      System.out.println("게시글을 삭제하였습니다.");
    } else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }
  }

  private Board findByNo(int no) {
    for (int i=0; i<this.size; i++) {
      if (this.boards[i].no == no) {
        return this.boards[i];
      }
    } return null;
  }

  private int indexOf(int no) {
    for (int i=0; i<this.size; i++) {
      if (this.boards[i].no == no) {
        return i;
      }
    } return -1;
  }
}
