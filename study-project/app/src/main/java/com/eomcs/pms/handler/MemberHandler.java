package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  //Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  public class Node {
    Node next;
    Member member;

    public Node(Member member) {
      this.member = member;
    }
  }

  Node head;
  Node tail;

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    Node node = new Node(member);
    if (head ==null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public void list() {
    System.out.println("[회원 목록]");
    Node node = head;
    while(node!=null) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          node.member.no, 
          node.member.name, 
          node.member.email, 
          node.member.tel, 
          node.member.registeredDate);
      node = node.next;
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("사진: %s\n", member.photo);
    System.out.printf("전화: %s\n", member.tel);
    System.out.printf("등록일: %s\n", member.registeredDate);
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.name  + ")? ");
    String email = Prompt.inputString("이메일(" + member.email + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.photo + ")? ");
    String tel = Prompt.inputString("전화(" + member.tel + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.name = name;
    member.email = email;
    member.password = password;
    member.photo = photo;
    member.tel = tel;

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    Member delMember = findByNo(no);

    if (delMember == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }
    Node node = head;
    Node prev = null;

    while(node!=null) {
      if (node.member == delMember) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }
        node.next = null;

        if (node == tail) {
          tail = node.next;
        }
        break;
      }

      prev = node;
      node = node.next;

    }
    size--;
    System.out.println("회원을 삭제하였습니다.");
  }

  boolean exist(String name) {
    Node node = head;
    while (node!=null) {
      if (node.member.name.equals(name)) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

  private Member findByNo(int no) {
    Node node = head;
    while(node!=null) {
      if (node.member.no == no) {
        return node.member;
      }
      node = node.next;
    }
    return null;
  }

}







