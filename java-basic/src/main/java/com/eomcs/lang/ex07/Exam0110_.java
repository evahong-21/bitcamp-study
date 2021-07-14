package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
// 1) 공백 띄우는 코드를 메소드 작성.
// 2) 별을 출력하는 코드를 메소드 작성.
// 3) while문 대신 for 문 사용.
// 4) 공백 계산
public class Exam0110_ {
  static void printSpace(int spaceLen) {
    for (int spaceCnt = 1; spaceCnt <= spaceLen; spaceCnt++) {
      System.out.print(" ");
    }
  }
  static void printStar(int starLen) {
    for (int starCnt = 1;starCnt <= starLen;starCnt++) {
      System.out.print("*");
    }
  }

  static int getSpaceLength(int len, int starLen) {
    return (len - starLen) / 2;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();


    for (int starLen = 1;starLen <= len; starLen += 2) {
      // 별 앞에 공백 출력
      printSpace(getSpaceLength(len, starLen));
      // 별 출력
      printStar(starLen);
      // 출력 줄 바꾸기
      System.out.println();

    }
  }
}