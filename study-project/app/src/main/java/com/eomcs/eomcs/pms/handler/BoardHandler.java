package com.eomcs.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.eomcs.pms.domain.Board;
import com.eomcs.eomcs.util.Prompt;

public class BoardHandler {
  static class Node {
    Board board;
    Node next;

    public Node(Board board) {
      this.board = board;
    }
  }
  // 클래스 위치와 인스턴스 변수의 위치는 중요하지 않음.
  //어쩌피 인스턴스 변수는 new 로 객체생성해야 하므로.
  Node head;
  Node tail;

  static final int MAX_LENGTH = 5;

  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  public void add() {

    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    Node node = new Node(board);
    if (head == null) {
      head=tail=node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public void list() {
    System.out.println("[게시글 목록]");
    if (head==null) {
      System.out.println("등록된 게시판이 없습니다.");
      return;
    }
    Node node = head;

    do {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          node.board.no, 
          node.board.title, 
          node.board.writer,
          node.board.registeredDate,
          node.board.viewCount, 
          node.board.like);
      node = node.next;
    } while (node!=null);
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
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

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");

    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }


    Node node = head;
    Node prev = null;

    while(node!=null) {
      if (node.board == board) {
        if (node == head) {
          head = node.next;
        } else if (node == tail) {
          tail = prev;
          prev.next = null;
        } else {
          prev.next = node.next;
          node.next = null;
        }
      }


      prev = node; // prev에는 직전 노드의 주소값을 저장.
      node = node.next; // node에는 다음에 올 노드의 주소값을 저장.
    }

    size--;
    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {
    //head
    Node node = head;
    while (node!=null) {
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    }
    return null;
  }

}







