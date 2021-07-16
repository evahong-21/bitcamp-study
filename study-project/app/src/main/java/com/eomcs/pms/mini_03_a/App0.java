package com.eomcs.pms.mini_03_a;

import java.sql.Date;
import java.util.Scanner;
//1) 변경준비.
//2) 사용자에게 명령 프롬프트 출력.
//3) 사용자의 명령을 입력받아 출력.
//4) 명령어 입력받아 출력하는것을 무한반복.
//5) exit나 quit 명력을 입력할 때 반복 실행 중지.
//6) /member/add, /member/list 명령 받기.
//7) /member/add 명령 처리.
//8) /member/list 명령 처리.

public class App0 {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH];

    while (true) {
      System.out.print("명령 > ");
      String input = keyboardScan.nextLine();
      //System.out.println(input);

      int size = 0;
      if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/list")) {
        System.out.println("[회원 목록]");
        for (int i = 0; i < size; i++) {
          // 번호, 이름, 이메일, 전화, 가입일
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], name[i], email[i], tel[i], registeredDate[i]);
        }
      } else if (input.equals("/member/add")) {
        System.out.println("[회원 등록]");
        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        name[size] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        email[size] = keyboardScan.nextLine();

        System.out.print("암호? ");
        password[size] = keyboardScan.nextLine();

        System.out.print("사진? ");
        photo[size] = keyboardScan.nextLine();

        System.out.print("전화? ");
        tel[size] = keyboardScan.nextLine();

        registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

        ++size;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
    keyboardScan.close();
    /*
    System.out.println("[회원]");


    // 최대 입력 개수



    int size = 0;

    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());

      System.out.print("이름? ");
      name[i] = keyboardScan.nextLine();

      System.out.print("이메일? ");
      email[i] = keyboardScan.nextLine();

      System.out.print("암호? ");
      password[i] = keyboardScan.nextLine();

      System.out.print("사진? ");
      photo[i] = keyboardScan.nextLine();

      System.out.print("전화? ");
      tel[i] = keyboardScan.nextLine();


      size++;
      System.out.println(); // 빈 줄 출력

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println(); // 빈 줄 출력
    }

    keyboardScan.close();

    System.out.println("--------------------------------");


     */
  }
}
