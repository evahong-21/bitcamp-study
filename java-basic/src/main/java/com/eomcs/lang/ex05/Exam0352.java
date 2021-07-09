package com.eomcs.lang.ex05;

//# 비트 연산자 & 를 이용하여 % 연산 구현하기 응용 I
//
public class Exam0352 {
  public static void main(String[] args) {
    // % 연산자를 이용하여 짝수/홀수 알아내기
    System.out.println(57 % 2 == 0 ? "짝수" : "홀수");

    // & 연산자를 이용하여 짝수/홀수 알아내기
    System.out.println((57 & 0x0001) == 0 ? "짝수" : "홀수"); //16진수
    System.out.println((57 & 0x1) == 0 ? "짝수" : "홀수"); // 위에서 0을 제거.
    // 1 bit가 0이면 짝고, 1이면 홀수
    // 0000_0000_0000_0000 : 8 4 2 1... 
  }
}

