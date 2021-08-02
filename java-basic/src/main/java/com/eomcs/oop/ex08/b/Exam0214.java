// 캡슐화(encapsulation) - 접근 범위 테스트
package com.eomcs.oop.ex08.b;

public class Exam0214 extends com.eomcs.oop.ex08.b.sub.Y {

  public static void main(String[] args) {
    Exam0214 obj = new Exam0214();

    //obj.privateVar = 100; // 접근 불가! Y 클래스에서만 접근 가능
    //obj.defaultVar = 100; // 접근 불가! Y 클래스와 같은 패키지가 아니다.
    obj.protectedVar = 100; // OK! Exam0214은 Y의 자식 클래스이며,
    // 또한 Y로부터 상속 받아서 만든 자기 변수이다.
    obj.publicVar = 100;
  }

}

// private      : 클래스 안에서만 접근 가능
// (default)    : private + 같은 패키지 소속
// protected    : (default) + 서브 클래스로 만든 변수인 경우 서브 클래스에서 접근 가능
// public       : 모두 접근 가능
//


