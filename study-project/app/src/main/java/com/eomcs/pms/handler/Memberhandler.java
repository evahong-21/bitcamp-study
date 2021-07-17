package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class Memberhandler {
  // 회원 정보
  static final int MAX_LENGTH = 5;
  static Member[] members = new Member[MAX_LENGTH]; //static 변수는 method area에 저장.
  static int size = 0;

  public static void add() {
    System.out.println("[회원 등록]");
    Member member = new Member();
    members[size++] = member;

    member.no = Prompt.inputInt("번호? ");
    member.name= Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    //members[size++] = member;
  }

  public static void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      // 번호, 이름, 이메일, 전화, 가입일
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          members[i].no,
          members[i].name, 
          members[i].email, 
          members[i].tel, 
          members[i].registeredDate);
    }
  }

}
