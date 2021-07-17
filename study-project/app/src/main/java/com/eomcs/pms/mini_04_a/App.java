package com.eomcs.pms.mini_04_a;

import com.eomcs.pms.handler.Memberhandler;
import com.eomcs.pms.handler.Projecthandler;
import com.eomcs.pms.handler.Taskhandler;
import com.eomcs.util.Prompt;

// eomcs-java-project의 app-03-b App.java 파일 가져와서 시작.
// app-04-a, app-04-b, app-04-c 순차적으로 해보기.

public class App {
  public static void main(String[] args) {

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        // 메서드로 분리한 코드를 실행하기(메서드 호출)
        // => 메서드명();
        Memberhandler.add();

      } else if (input.equals("/member/list")) {
        Memberhandler.list();

      }  else if (input.equals("/project/add")) {
        Projecthandler.add();

      }  else if (input.equals("/project/list")) {
        Projecthandler.list();

      }  else if (input.equals("/task/add")) {
        Taskhandler.add();

      }  else if (input.equals("/task/list")) {
        Taskhandler.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    Prompt.close();
  }


}












