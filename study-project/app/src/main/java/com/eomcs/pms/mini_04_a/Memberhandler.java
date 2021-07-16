package com.eomcs.pms.mini_04_a;

import java.sql.Date;

public class Memberhandler {

  static void addMember() {
    System.out.println("[회원 등록]");

    //    String input = prompt("번호? ");
    //    no[size] = Integer.parseInt(input);

    no[size] = Prompt.inputInt("번호? ");
    name[size] = Prompt.inputString("이름? ");
    email[size] = Prompt.inputString("이메일? ");
    password[size] = Prompt.inputString("암호? ");
    photo[size] = Prompt.inputString("사진? ");
    tel[size] = Prompt.inputString("전화? ");
    registeredDate[size] = new Date(System.currentTimeMillis());

    size++;
  }

  static void listMembers() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      // 번호, 이름, 이메일, 전화, 가입일
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
  }

}
