package com.eomcs.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.eomcs.pms.domain.Board;
import com.eomcs.eomcs.util.Prompt;

public class BoardHandler {
  static final int MAX_LENGTH = 5;

  // Member 인스턴스의 주소를 저장할 레퍼런스를 3개 생성한다.
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public static void add(BoardHandler that) {
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱 개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.
    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    System.out.println("게시글을 등록하였습니다.");

    that.boards[that.size++] = board;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public static void list(BoardHandler that) {
    System.out.println("[회원 목록]");
    for (int i = 0; i < that.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          that.boards[i].no, 
          that.boards[i].title, 
          that.boards[i].writer,
          that.boards[i].registeredDate,
          that.boards[i].viewCount,
          that.boards[i].like);
    }
  }
}
