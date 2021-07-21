package com.eomcs.oop.ex00;

public class Test {
  static int a;
  int b;

  // this X
  static void m1(int c) {
    int d = c +100;
  }

  // Non-static 메서드 : built in 변수인 this 존재.
  // 인스턴스 주소를 받을 this 라는 레퍼런스 변수.
  void m2(int c) {
    int d = c + 100;
  }
}
