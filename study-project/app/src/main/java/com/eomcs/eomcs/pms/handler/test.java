package com.eomcs.eomcs.pms.handler;

import com.eomcs.eomcs.pms.domain.Member;
import com.eomcs.eomcs.util.Prompt;

public class test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  public void detail() {
    System.out.println("멤버 상세보기");
    int j = 0;

    do {
      int no = Prompt.inputInt("번호? ");
      Member member = null;

      for(int i = 0 ; i < size ; i++) {
        if(members[i].no == no) {
          member = members[i];
          break;
        }
      }

      if(member != null)
        j++;


      if(member == null) {

        System.out.println("등록된 고객번호가 없습니다.");
        System.out.println("현재 등록된 고객번호는 아래와 같습니다.");
        for(int i = 0 ; i < size ; i++) 
          System.out.print(members[i].no+", ");
      }

    }while(j == 0);

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("비밀번호: %s\n", member.password);
    System.out.printf("전화번호: %s\n", member.tel);
    System.out.printf("생성일: %s\n", member.registeredDate);

  }
}
