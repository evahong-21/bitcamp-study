package com.eomcs.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  static Scanner keyboardScan = new Scanner(System.in);
  // 사용자로부터 문자열을 입력 받아 리턴한다.
  public static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  // 사용자로부터 숫자를 입력 받아 리턴한다.
  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  // 사용자로부터 날짜를 입력 받아 리턴한다.
  public static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  public static void close() {
    keyboardScan.close();
  }

}
