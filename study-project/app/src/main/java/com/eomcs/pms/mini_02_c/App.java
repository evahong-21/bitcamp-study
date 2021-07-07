package com.eomcs.pms.mini_02_c;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 값 비교할땐 ==가 아니라 equals 사용하기..
    // equalsIgnoreCase() 는 대소문자 구분 X

    String[] numArr = new String[5];
    String[] nameArr = new String[5];
    String[] mailArr = new String[5];
    String[] passwdArr = new String[5];
    String[] picArr = new String[5];
    String[] phoneArr = new String[5];

    Scanner scn = new Scanner(System.in);
    //String question;
    for (int i=0;i<5;i++) {
      System.out.println("[회원]");
      System.out.print("번호:? ");
      String number = scn.nextLine();
      numArr[i] = number;

      System.out.print("이름:? ");
      String name = scn.nextLine();
      nameArr[i] = name;

      System.out.print("이메일:? ");
      String mail = scn.nextLine();
      mailArr[i] = mail;

      System.out.print("암호:? ");
      String passwd = scn.nextLine();
      passwdArr[i] = passwd;

      System.out.print("사진:? ");
      String picture = scn.nextLine();
      picArr[i] = picture;

      System.out.print("전화:? ");
      String phone = scn.nextLine();
      phoneArr[i] = phone;

      System.out.println("계속 입력하시겠습니까?(y/N)");
      String question = scn.nextLine();
      if (question.equals("N")) {
        break; //N를 입력하면 반복문 빠져나옴.
      }
    }
    scn.close();
    System.out.println("----------------------------");
    System.out.println(numArr.length);
    System.out.println(numArr.toString());
  }

}
